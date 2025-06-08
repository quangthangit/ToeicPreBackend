package com.ToeicPreBackend.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "topic_vocab")
public class TopicVocab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int topicVocabId;

    @Column
    @NotNull
    private String name;

    @Column
    private int totalWord;

    @Column
    private int totalLesson;
}