package com.iritm.iritmservices.Controller;

import com.iritm.iritmservices.Dto.TopicCommentListModel;
import com.iritm.iritmservices.Dto.TopicCommentModel;
import com.iritm.iritmservices.Dto.TopicListModel;
import com.iritm.iritmservices.Dto.TopicModel;
import com.iritm.iritmservices.Service.DiscussionCommentService;
import com.iritm.iritmservices.Service.DiscussionTopicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/discussionForum/")
public class DiscussionForumController {

    @Autowired
    DiscussionTopicService discussionTopicService;

    @Autowired
    DiscussionCommentService discussionCommentService;

    @PostMapping("/addTopic")
    public TopicListModel addTopic(@Valid @RequestBody TopicModel topicModel){
        return discussionTopicService.addTopic(topicModel);
    }

    @GetMapping("/listAllTopics/{pageNo}")
    public TopicListModel listAllTopics(@PathVariable(value="pageNo") int pageNo,@Valid @RequestParam(value="searchTopic",required = false) String searchTopic){
        return discussionTopicService.listAllTopics(pageNo,searchTopic);
    }

    @PostMapping("/addComment/{pageNo}")
    public TopicCommentListModel addComment(@Valid @RequestBody TopicCommentModel topicCommentModel,@PathVariable(value="pageNo") int pageNo){

        return discussionCommentService.addComment(topicCommentModel,pageNo);
    }

    @GetMapping("/getCommentsByTopic/{topicId}/{pageNo}")
    public TopicCommentListModel getCommentsByTopic(@PathVariable(value="topicId") Long topicId,@PathVariable(value="pageNo") int pageNo){

        return discussionTopicService.getCommentsByTopic(topicId,pageNo);
    }

    @PostMapping("/closeTopic/{pageNo}")
    public TopicListModel closeTopic(@Valid @RequestBody TopicModel topicModel,@PathVariable(value="pageNo") int pageNo){
        return discussionTopicService.closeTopic(topicModel,pageNo);
    }

}
