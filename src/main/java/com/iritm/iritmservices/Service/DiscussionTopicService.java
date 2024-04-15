package com.iritm.iritmservices.Service;

import com.iritm.iritmservices.Dto.TopicCommentListModel;
import com.iritm.iritmservices.Dto.TopicListModel;
import com.iritm.iritmservices.Dto.TopicModel;

import java.util.List;

public interface DiscussionTopicService {
    TopicListModel addTopic(TopicModel topicModel);

    TopicListModel listAllTopics(int pageNo,String searchTopic);

    TopicCommentListModel getCommentsByTopic(Long topicId,int pageNo);

    TopicListModel closeTopic(TopicModel topicModel, int pageNo);
}
