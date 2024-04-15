package com.iritm.iritmservices.Service;


import com.iritm.iritmservices.Dto.TopicCommentListModel;
import com.iritm.iritmservices.Dto.TopicCommentModel;

public interface DiscussionCommentService {
    TopicCommentListModel addComment(TopicCommentModel topicCommentModel,int pageNo);

}
