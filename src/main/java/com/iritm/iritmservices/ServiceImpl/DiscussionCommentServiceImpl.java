package com.iritm.iritmservices.ServiceImpl;

import com.iritm.iritmservices.Dto.TopicCommentListModel;
import com.iritm.iritmservices.Dto.TopicCommentModel;
import com.iritm.iritmservices.Entity.DiscussionComment;
import com.iritm.iritmservices.Entity.DiscussionTopic;
import com.iritm.iritmservices.Repo.DiscussionCommentRepository;
import com.iritm.iritmservices.Repo.DiscussionTopicRepository;
import com.iritm.iritmservices.Service.DiscussionCommentService;
import com.iritm.iritmservices.Service.DiscussionTopicService;
import com.iritm.iritmservices.adapter.DiscussionCommentAdapter;
import com.iritm.iritmservices.exception.AppException;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscussionCommentServiceImpl implements DiscussionCommentService {

    @Autowired
    DiscussionCommentRepository discussionCommentRepository;

    @Autowired
    DiscussionTopicRepository discussionTopicRepository;

    @Autowired
    DiscussionTopicService discussionTopicService;


    @Override
    @SneakyThrows
    public TopicCommentListModel addComment(TopicCommentModel topicCommentModel,int pageNo) {
        DiscussionTopic discussionTopic = discussionTopicRepository.findByActiveTrueAndOpenTrueAndId(topicCommentModel.getDiscussionTopicId())
                .orElseThrow(()->new AppException("Open discussion topic not found"));
        DiscussionComment parentComment = topicCommentModel.getParentCommentId()!=null?discussionCommentRepository.findByActiveTrueAndId(topicCommentModel.getParentCommentId())
                .orElseThrow(()->new AppException("Discussion Comment not found")):new DiscussionComment();
        if(parentComment.getDiscussionTopic()!=null&&!parentComment.getDiscussionTopic().getId().equals(discussionTopic.getId())){
            throw new AppException("Parent does not belong to discussion topic");
        }
        discussionCommentRepository.save(DiscussionCommentAdapter.topicCommentModelToDiscussionComment(topicCommentModel,discussionTopic,parentComment));
        return discussionTopicService.getCommentsByTopic(discussionTopic.getId(),pageNo);
    }

}
