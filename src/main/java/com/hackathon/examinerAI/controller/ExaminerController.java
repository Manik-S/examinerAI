package com.hackathon.examinerAI.controller;


import com.hackathon.examinerAI.model.*;
import com.hackathon.examinerAI.service.ExaminerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Gopinath Rangappa
 */
@RestController
@Slf4j
public class ExaminerController {

  @Autowired
  ExaminerService examinerService;

  @PostMapping(path = "/genExam", consumes = "application/json", produces = "application/json")
  @CrossOrigin(origins = "http://localhost:3000")
  public QuestionPaperResult examinerApi(
      @Validated @RequestBody ExaminerRequest request) {
    QuestionPaperResult result = examinerService.generateResult(request);
    return result;
  }
  @PostMapping(path = "/genExamDetailed", consumes = "application/json", produces = "application/json")
  public QuestionPaperResult detailedExaminerApi(
          @Validated @RequestBody DetailedExaminerRequest detailedExaminerRequest) {
    QuestionPaperResult result = examinerService.generateResult(detailedExaminerRequest);
    return result;
  }

  @PostMapping(path = "/genExamWithText", consumes = "application/json", produces = "application/json")
  @CrossOrigin(origins = "http://localhost:3000")
  public QuestionPaperResult examinerApiWithText(
          @Validated @RequestBody ExaminerRequestWithText request) {
    QuestionPaperResult result = examinerService.generateResult(request);
    return result;
  }

  @PostMapping(path = "/genExamWithPDF", consumes = "application/json", produces = "application/json")
  @CrossOrigin(origins = "http://localhost:3000")
  public QuestionPaperResult examinerApiWithPDF(
          @Validated @RequestBody ExaminerRequestWithPDF request) {
    QuestionPaperResult result = examinerService.generateResult(request);
    return result;
  }
}
