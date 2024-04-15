package com.iritm.iritmservices.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Table(name = "discussion_comment")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class DiscussionComment {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=20)
    private Long id;
    @Column
    private Long parentCommentId;
    @Column
    private String comment;
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

    @ManyToOne
    @JoinColumn(name = "discussion_topic_id")
    private DiscussionTopic discussionTopic;

}
