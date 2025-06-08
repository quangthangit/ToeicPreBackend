package com.ToeicPreBackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "sub_topic_vocab")
public class SubTopicVocab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subTopicVocabId;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private int totalWord;

    @ManyToOne
    @JoinColumn(name = "topic_vocab_id", referencedColumnName = "topicVocabId")
    private TopicVocab topicVocab;
}
