package com.hackathon.examinerAI.model;

public class SectionRequest {
  private String sectionName;
  private QuestionType questionType;
  private long numberOfQuestions;
  private double marks;

  private double sectionMarks;

  public String getSectionName() {
    return sectionName;
  }

  public void setSectionName(String sectionName) {
    this.sectionName = sectionName;
  }

  public QuestionType getQuestionType() {
    return questionType;
  }

  public void setQuestionType(QuestionType questionType) {
    this.questionType = questionType;
  }

  public long getNumberOfQuestions() {
    return numberOfQuestions;
  }

  public void setNumberOfQuestions(long numberOfQuestions) {
    this.numberOfQuestions = numberOfQuestions;
  }

  public double getMarks() {
    return marks;
  }

  public void setMarks(double marks) {
    this.marks = marks;
  }

  public double getSectionMarks() {
    this.sectionMarks = marks * numberOfQuestions;
    return sectionMarks;
  }

  public void setSectionMarks(double sectionMarks) {
    this.sectionMarks = sectionMarks;
  }
}
