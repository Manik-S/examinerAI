package com.hackathon.examinerAI.model;

import java.util.List;

public class ExaminerRequestWithPDF {
    private long id;
    private String filePath;
    private Difficulty difficulty;
    private List<SectionRequest> sectionsInRequest;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public List<SectionRequest> getSectionsInRequest() {
        return sectionsInRequest;
    }

    public void setSectionsInRequest(List<SectionRequest> sectionsInRequest) {
        this.sectionsInRequest = sectionsInRequest;
    }
}
