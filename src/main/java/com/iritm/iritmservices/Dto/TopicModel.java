package com.iritm.iritmservices.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TopicModel {

    Long id;
    @NotNull
    @NotEmpty
    String topic;
    Boolean open;
    String createdBy;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern= "MMMM dd, yyyy hh:mm a" )
    LocalDateTime createdAt;
    String updatedBy;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern= "MMMM dd, yyyy hh:mm a" )
    LocalDateTime updatedAt;
    Integer totalPages;
    Integer sno;
    String searchTopic;
}
