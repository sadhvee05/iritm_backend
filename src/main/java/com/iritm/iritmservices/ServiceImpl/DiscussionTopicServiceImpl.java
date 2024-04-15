package com.iritm.iritmservices.ServiceImpl;

import com.iritm.iritmservices.Dto.TopicCommentListModel;
import com.iritm.iritmservices.Dto.TopicCommentModel;
import com.iritm.iritmservices.Dto.TopicListModel;
import com.iritm.iritmservices.Dto.TopicModel;
import com.iritm.iritmservices.Entity.DiscussionComment;
import com.iritm.iritmservices.Entity.DiscussionTopic;
import com.iritm.iritmservices.Repo.DiscussionTopicRepository;
import com.iritm.iritmservices.Service.DiscussionTopicService;
import com.iritm.iritmservices.adapter.DiscussionCommentAdapter;
import com.iritm.iritmservices.adapter.DiscussionTopicAdapter;
import com.iritm.iritmservices.exception.AppException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class DiscussionTopicServiceImpl implements DiscussionTopicService {

    private final int commentPageSize =10;
    private final int topicPageSize=10;

    @Autowired
    DiscussionTopicRepository discussionTopicRepository;
    @Override
    public TopicListModel addTopic(TopicModel topicModel) {
        discussionTopicRepository.save(DiscussionTopicAdapter.topicModelToDiscussionTopic(topicModel));
        return listAllTopics(1,null);
    }

    @Override
    public TopicListModel listAllTopics(int pageNo, String searchTopic) {
        int totalRecords = 0;
        Integer totalPages ;
        List<DiscussionTopic> discussionTopicList;
        if(searchTopic!=null&& !searchTopic.trim().isEmpty()){
            totalRecords = discussionTopicRepository.countByActiveTrueAndTopicContaining(searchTopic);
            discussionTopicList = discussionTopicRepository.findByActiveTrueAndTopicContainingOrderByIdDesc(searchTopic,PageRequest.of(pageNo - 1, topicPageSize));
        }else {
            totalRecords = discussionTopicRepository.countByActiveTrue();
            discussionTopicList = discussionTopicRepository.findByActiveTrueOrderByIdDesc(PageRequest.of(pageNo - 1, topicPageSize));
        }
        totalPages = totalRecords / topicPageSize + ((totalRecords % topicPageSize == 0) ? 0 : 1);
        return TopicListModel.builder()
                .totalPages(totalPages)
                .searchTopic(searchTopic)
                .topicModelList(DiscussionTopicAdapter.discussionTopicListToTopicModelList(discussionTopicList,pageNo,topicPageSize))
                .build();
    }

    @Override
    public TopicCommentListModel getCommentsByTopic(Long topicId,int pageNo) {
        DiscussionTopic discussionTopic = discussionTopicRepository.findByActiveTrueAndId(topicId)
                .orElseThrow(()->new AppException("Discussion topic not found"));
        List<DiscussionComment> discussionCommentList = discussionTopic.getDiscussionCommentList();
        Map<Long,List<DiscussionComment>> commentByParentMap = new HashMap<>();
        for(DiscussionComment discussionComment:discussionCommentList){
            if(discussionComment.getActive()) {
                Long parentId = discussionComment.getParentCommentId() != null ? discussionComment.getParentCommentId() : 0L;
                List<DiscussionComment> tempList = commentByParentMap.get(parentId);
                if (tempList == null) {
                    tempList = new ArrayList<>();
                }
                tempList.add(discussionComment);
                commentByParentMap.put(parentId, tempList);
            }
        }
        if(commentByParentMap.get(0L)==null){
            return TopicCommentListModel.builder()
                    .topicModel(DiscussionTopicAdapter.discussionTopicToTopicModel(discussionTopic,0,null))
                    .topicCommentModelList(new ArrayList<>())
                    .build();
        }

        commentByParentMap.get(0L).sort((a,b)->b.getId().compareTo(a.getId()));
        int noOfFirstLevelComments = commentByParentMap.get(0L).size();
        Integer totalPages = noOfFirstLevelComments / commentPageSize + ((noOfFirstLevelComments % commentPageSize == 0) ? 0 : 1);
        if(totalPages<pageNo||pageNo<1){
            throw new AppException("Enter the valid page number");
        }
        int from = (pageNo-1)*commentPageSize;
        int to = pageNo*commentPageSize;
        return TopicCommentListModel.builder()
                .topicModel(DiscussionTopicAdapter.discussionTopicToTopicModel(discussionTopic,totalPages,null))
                .topicCommentModelList(addCommentsByTopicToModel(commentByParentMap,0L,from, Math.min(to, noOfFirstLevelComments)))
                .build();
    }

    @Override
    public TopicListModel closeTopic(TopicModel topicModel, int pageNo) {
        DiscussionTopic discussionTopic = discussionTopicRepository.findByActiveTrueAndOpenTrueAndId(topicModel.getId())
                .orElseThrow(()->new AppException("Open discussion topic not found"));
        discussionTopic.setOpen(false);
        discussionTopic.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
        discussionTopic.setUpdatedBy(2L);
        discussionTopicRepository.save(discussionTopic);
        return listAllTopics(pageNo,topicModel.getSearchTopic());
    }

    public List<TopicCommentModel> addCommentsByTopicToModel(Map<Long,List<DiscussionComment>> commentByParentMap,Long parentId,int from, int to){
        List<DiscussionComment> discussionCommentList = (parentId.equals(0L))?commentByParentMap.get(parentId).subList(from,to):commentByParentMap.get(parentId);
        if(discussionCommentList==null){
            return null;
        }
        List<TopicCommentModel> topicCommentModelList = new ArrayList<>();
        for(DiscussionComment discussionComment:discussionCommentList){
            topicCommentModelList.add(DiscussionCommentAdapter.discussionCommentToTopicCommentModel(discussionComment,addCommentsByTopicToModel(commentByParentMap,discussionComment.getId(),from,to)));
        }
        topicCommentModelList.sort((a,b)->b.getId().compareTo(a.getId()));
        return topicCommentModelList;
    }
}
