package com.hackathon.examinerAI.model;

public class SectionRequest {
  private String sectionName;
  private QuestionType questionType;
  private int numberOfQuestions;
  private int marks;

  private int sectionMarks;

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

  public void setNumberOfQuestions(int numberOfQuestions) {
    this.numberOfQuestions = numberOfQuestions;
  }

  public int getMarks() {
    return marks;
  }

  public void setMarks(int marks) {
    this.marks = marks;
  }

  public int getSectionMarks() {
    this.sectionMarks = marks * numberOfQuestions;
    return sectionMarks;
  }

  public void setSectionMarks(int sectionMarks) {
    this.sectionMarks = sectionMarks;
  }
}
