package com.hackathon.examinerAI.model;

import java.util.List;

public class ExaminerRequestWithText {

    private long id;
    private String text;

    private Difficulty difficulty;
    private List<SectionRequest> sectionsInRequest;

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<SectionRequest> getSectionsInRequest() {
        return sectionsInRequest;
    }

    public void setSectionsInRequest(List<SectionRequest> sectionsInRequest) {
        this.sectionsInRequest = sectionsInRequest;
    }
}
