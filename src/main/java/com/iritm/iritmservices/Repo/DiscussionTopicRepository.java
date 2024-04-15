package com.iritm.iritmservices.Repo;

import com.iritm.iritmservices.Entity.DiscussionTopic;
import org.hibernate.query.spi.Limit;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DiscussionTopicRepository extends JpaRepository<DiscussionTopic, Long> {

    Optional<DiscussionTopic> findByActiveTrueAndId(Long discussionTopicId);

    Optional<DiscussionTopic> findByActiveTrueAndOpenTrueAndId(Long discussionTopicId);

    List<DiscussionTopic> findByActiveTrueOrderByIdDesc(Pageable pageable);

    int countByActiveTrue();

    int countByActiveTrueAndTopicContaining(String searchTopic);

    List<DiscussionTopic> findByActiveTrueAndTopicContainingOrderByIdDesc(String searchTopic, Pageable pageable);
}
