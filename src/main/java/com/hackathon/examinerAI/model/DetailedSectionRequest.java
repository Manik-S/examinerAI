package com.hackathon.examinerAI.model;

import java.util.List;

public class DetailedSectionRequest {
    private String sectionName;
    private long numberOfQuestions;
    private double sectionMarks;
    private List<Question> questionList;

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public long getNumberOfQuestions() {
        return this.questionList.size();
    }

    public void setNumberOfQuestions(long numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

    public double getSectionMarks() {
        double m=0;
        for(Question q :this.questionList){
            m=m+q.getMarks();
        }
        return m;
    }

    public void setSectionMarks(double sectionMarks) {
        this.sectionMarks = sectionMarks;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }
}
