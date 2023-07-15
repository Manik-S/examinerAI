package com.hackathon.examinerAI.model;

import org.springframework.stereotype.Component;

@Component
public class QuestionPaperResult {

  private long id;
  private String questionPaper;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getQuestionPaper() {
    return questionPaper;
  }

  public void setQuestionPaper(String questionPaper) {
    this.questionPaper = questionPaper;
  }
}
