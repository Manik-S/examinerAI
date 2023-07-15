package com.hackathon.examinerAI.model;

import java.util.List;

public class DetailedExaminerRequest {
    private long id;
    private String subject;
    private List<String> topic;
    private List<DetailedSectionRequest> detailedSectionRequest;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<String> getTopic() {
        return topic;
    }

    public void setTopic(List<String> topic) {
        this.topic = topic;
    }

    public List<DetailedSectionRequest> getDetailedSectionRequest() {
        return detailedSectionRequest;
    }

    public void setDetailedSectionRequest(List<DetailedSectionRequest> detailedSectionRequest) {
        this.detailedSectionRequest = detailedSectionRequest;
    }
}
