package com.ToeicPreBackend.service.impl;

import com.ToeicPreBackend.entity.TopicVocab;
import com.ToeicPreBackend.entity.User;
import com.ToeicPreBackend.exception.NotFoundException;
import com.ToeicPreBackend.repository.TopicVocabRepository;
import com.ToeicPreBackend.service.TopicVocabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TopicVocabServiceImpl implements TopicVocabService {

    private final TopicVocabRepository topicVocabRepository;

    @Autowired
    public TopicVocabServiceImpl(TopicVocabRepository topicVocabRepository) {
        this.topicVocabRepository = topicVocabRepository;
    }

    @Override
    public TopicVocab create(TopicVocab entity) {
        return topicVocabRepository.save(entity);
    }

    @Override
    public TopicVocab update(Integer integer, TopicVocab entity) {
        TopicVocab topicVocab = topicVocabRepository.findById(integer)
                .orElseThrow(() -> new NotFoundException("Topic ID " + integer + " not found"));
        topicVocab.setName(entity.getName());
        topicVocab.setTotalLesson(entity.getTotalLesson());
        topicVocab.setTotalWord(entity.getTotalWord());
        return topicVocabRepository.save(topicVocab);
    }

    @Override
    public TopicVocab getById(Integer integer) {
        return topicVocabRepository.findById(integer)
                .orElseThrow(() -> new NotFoundException("Topic ID " + integer + " not found"));
    }

    @Override
    public void delete(Integer integer) {
        topicVocabRepository.findById(integer).orElseThrow(() -> new NotFoundException("Topic ID " + integer + " Not Found"));
        topicVocabRepository.deleteById(integer);
    }

    @Override
    public List<TopicVocab> getAll() {
        return topicVocabRepository.findAll();
    }
}
