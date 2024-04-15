package com.iritm.iritmservices.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TopicCommentListModel {
    TopicModel topicModel;
    List<TopicCommentModel> topicCommentModelList;
}
