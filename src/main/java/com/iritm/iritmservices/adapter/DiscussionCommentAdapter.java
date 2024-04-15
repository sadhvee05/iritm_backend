package com.iritm.iritmservices.adapter;


import com.iritm.iritmservices.Dto.TopicCommentModel;
import com.iritm.iritmservices.Entity.DiscussionComment;
import com.iritm.iritmservices.Entity.DiscussionTopic;
import org.springframework.util.Assert;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class DiscussionCommentAdapter {

    public static DiscussionComment topicCommentModelToDiscussionComment(final TopicCommentModel topicCommentModel,
                                                                         final DiscussionTopic discussionTopic,
                                                                         final DiscussionComment parentComment){
        Assert.notNull(topicCommentModel,"Comment cannot be null");
        Assert.notNull(discussionTopic,"Topic cannot be null");
        Assert.notNull(parentComment,"Parent comment cannot be null");
        return DiscussionComment.builder()
                .parentCommentId(parentComment.getId())
                .comment(topicCommentModel.getComment())
                .active(true)
                .createdBy(1L)
                .createdAt(Timestamp.valueOf(LocalDateTime.now()))
                .updatedBy(1L)
                .updatedAt(Timestamp.valueOf(LocalDateTime.now()))
                .discussionTopic(discussionTopic)
                .build();
    }

    public static TopicCommentModel discussionCommentToTopicCommentModel(final DiscussionComment discussionComment,final List<TopicCommentModel> innerCommentList){
        Assert.notNull(discussionComment,"Discussion Comment cannot be null");
        return TopicCommentModel.builder()
                .id(discussionComment.getId())
                .discussionTopicId(discussionComment.getDiscussionTopic().getId())
                .parentCommentId(discussionComment.getParentCommentId())
                .comment(discussionComment.getComment())
                .createdBy("User")
                .createdAt(discussionComment.getCreatedAt().toLocalDateTime())
                .updatedBy("User")
                .updatedAt(discussionComment.getUpdatedAt().toLocalDateTime())
                .innerCommentList(innerCommentList)
                .build();
    }


}
