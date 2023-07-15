package com.hackathon.examinerAI.model;

import java.util.List;

/**
 * This POJO represents request model for REST API <b>TBD</b>
 */
public class ExaminerRequest {

    private long id;
    private String subject;
    private List<String> topic;
    private List<SectionRequest> sectionsInRequest;

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

    public List<SectionRequest> getSectionsInRequest() {
        return sectionsInRequest;
    }

    public void setSectionsInRequest(List<SectionRequest> sectionsInRequest) {
        this.sectionsInRequest = sectionsInRequest;
    }

}
