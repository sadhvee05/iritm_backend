package com.iritm.iritmservices.adapter;

import com.iritm.iritmservices.Dto.TopicModel;
import com.iritm.iritmservices.Entity.DiscussionTopic;
import org.springframework.util.Assert;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class DiscussionTopicAdapter {

    public static DiscussionTopic topicModelToDiscussionTopic(final TopicModel topicModel){
        Assert.notNull(topicModel,"Topic Model cannot be null");
        return DiscussionTopic.builder()
                .topic(topicModel.getTopic())
                .open(true)
                .active(true)
                .createdBy(1L)
                .createdAt(Timestamp.valueOf(LocalDateTime.now()))
                .updatedBy(1L)
                .updatedAt(Timestamp.valueOf(LocalDateTime.now()))
                .build();
    }

    public static TopicModel discussionTopicToTopicModel(final DiscussionTopic discussionTopic,Integer totalPages,Integer sNo){
        Assert.notNull(discussionTopic,"Discussion Topic cannot be null");
        return TopicModel.builder()
                .id(discussionTopic.getId())
                .topic(discussionTopic.getTopic())
                .open(discussionTopic.getOpen())
                .createdBy("User")
                .createdAt(discussionTopic.getCreatedAt().toLocalDateTime())
                .updatedBy("User")
                .updatedAt(discussionTopic.getUpdatedAt().toLocalDateTime())
                .totalPages(totalPages)
                .sno(sNo)
                .build();
    }

    public static List<TopicModel> discussionTopicListToTopicModelList(final List<DiscussionTopic> discussionTopicList,int pageNo,int pageSize) {
        AtomicInteger sNo = new AtomicInteger(((pageNo - 1) * pageSize)+1);
        Assert.notNull(discussionTopicList,"Discussion Topic List cannot be null");
        return discussionTopicList.stream().map(discussionTopic -> discussionTopicToTopicModel(discussionTopic,null, sNo.getAndIncrement())).collect(Collectors.toList());
    }
}
