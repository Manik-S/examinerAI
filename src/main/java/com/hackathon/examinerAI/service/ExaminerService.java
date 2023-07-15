package com.hackathon.examinerAI.service;

import com.hackathon.examinerAI.model.DetailedExaminerRequest;
import com.hackathon.examinerAI.model.ExaminerRequest;
import com.hackathon.examinerAI.model.QuestionPaperResult;

public interface ExaminerService {
    QuestionPaperResult generateResult(ExaminerRequest examinerRequest);
    QuestionPaperResult generateResult(DetailedExaminerRequest detailedExaminerRequest);

}
