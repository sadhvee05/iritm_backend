package com.iritm.iritmservices.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TopicCommentModel {

    Long id;
    @NotNull
    Long discussionTopicId;
    Long parentCommentId;
    @NotNull
    String comment;
    String createdBy;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern= "MMMM dd, yyyy hh:mm a" )
    LocalDateTime createdAt;
    String updatedBy;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern= "MMMM dd, yyyy hh:mm a" )
    LocalDateTime updatedAt;
    List<TopicCommentModel> innerCommentList;

}
