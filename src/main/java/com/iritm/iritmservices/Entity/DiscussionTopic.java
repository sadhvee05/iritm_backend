package com.iritm.iritmservices.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "discussion_topic")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class DiscussionTopic {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=20)
    private Long id;
    @Column
    private String topic;
    @Column
    private Boolean open;
    @Column
    private Boolean active;
    @Column
    private Long createdBy;
    @Column
    private Timestamp createdAt;
    @Column
    private Long updatedBy;
    @Column
    private Timestamp updatedAt;

    @OneToMany(mappedBy = "discussionTopic")
    List<DiscussionComment> discussionCommentList;

}
