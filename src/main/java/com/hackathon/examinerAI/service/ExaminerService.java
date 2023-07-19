package com.hackathon.examinerAI.service;

import com.hackathon.examinerAI.model.*;

public interface ExaminerService {
    QuestionPaperResult generateResult(ExaminerRequest examinerRequest);

    QuestionPaperResult generateResult(DetailedExaminerRequest detailedExaminerRequest);

    QuestionPaperResult generateResult(ExaminerRequestWithText examinerRequest);

    QuestionPaperResult generateResult(ExaminerRequestWithPDF request);
}
