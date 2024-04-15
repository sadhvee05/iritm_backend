package com.iritm.iritmservices.Repo;

import com.iritm.iritmservices.Entity.DiscussionComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DiscussionCommentRepository extends JpaRepository<DiscussionComment, Long> {
    Optional<DiscussionComment> findByActiveTrueAndId(Long id);

    List<DiscussionComment> findByActiveTrueAndDiscussionTopicIdOrderByCreatedAtDesc(Long topicId);
}
