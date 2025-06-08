package com.ToeicPreBackend.repository;

import com.ToeicPreBackend.entity.TopicVocab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicVocabRepository extends JpaRepository<TopicVocab, Integer> {
}
