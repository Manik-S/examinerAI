package com.hackathon.examinerAI.model;

public class Question {
  private long id;
  private QuestionType questionType;
  private double marks;
  private Difficulty difficulty;

  public Question(){}

  public Question(long id, QuestionType questionType, Difficulty difficulty) {
    this.id = id;
    this.questionType = questionType;
    double temp = 1;
    if (questionType.equals(QuestionType.DESCRIPTIVE_LONG)) temp = 10;
    else if (questionType.equals(QuestionType.DESCRIPTIVE_MEDIUM)) temp = 5;
    else if (questionType.equals(QuestionType.DESCRIPTIVE_SHORT)) temp = 2;
    this.marks = temp;
    this.difficulty=difficulty;
  }

  public Question(long id, QuestionType questionType, double marks, Difficulty difficulty) {
    this.id = id;
    this.questionType = questionType;
    this.marks = marks;
    this.difficulty=difficulty;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public QuestionType getQuestionType() {
    return questionType;
  }

  public void setQuestionType(QuestionType questionType) {
    this.questionType = questionType;
  }

  public double getMarks() {
    return marks;
  }

  public void setMarks(double marks) {
    this.marks = marks;
  }

  public Difficulty getDifficulty() {
    return difficulty;
  }

  public void setDifficulty(Difficulty difficulty) {
    this.difficulty = difficulty;
  }
}
