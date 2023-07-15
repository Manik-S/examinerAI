package com.hackathon.examinerAI.service;

import static com.hackathon.examinerAI.configuration.ExaminerConstants.promptPrefix;
import static com.hackathon.examinerAI.configuration.ExaminerConstants.promptSuffix;

import com.hackathon.examinerAI.model.*;
import com.hackathon.examinerAI.util.OpenAIUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ExaminerServiceImp implements ExaminerService {
    @Autowired
    OpenAIUtil openAIUtil;

    public QuestionPaperResult generateResult(ExaminerRequest examinerRequest) {
        QuestionPaperResult questionPaperResult = new QuestionPaperResult();
        questionPaperResult.setId(examinerRequest.getId());
        log.info("Generating prompt..");
        String prompt = generatePrompt(examinerRequest);
        log.info("Prompt generated successfully\n" + prompt + "\n");
        questionPaperResult.setQuestionPaper(promptOpenAI(prompt));
        return questionPaperResult;
    }

    public QuestionPaperResult generateResult(DetailedExaminerRequest detailedExaminerRequest) {
        QuestionPaperResult questionPaperResult = new QuestionPaperResult();
        questionPaperResult.setId(detailedExaminerRequest.getId());
        log.info("Generating detailed prompt..");
        String prompt = generatePromptDetailed(detailedExaminerRequest);
        log.info("Prompt generated successfully\n" + prompt + "\n");
        questionPaperResult.setQuestionPaper(promptOpenAI(prompt));
        return questionPaperResult;
    }

    private String promptOpenAI(String prompt) {

        return openAIUtil.generateMessage(prompt);
    }

    private String generatePromptDetailed(DetailedExaminerRequest detailedRequest) {
        Double ttl = 0.0;
        String topics = String.join(", ", detailedRequest.getTopic());
        String prompt =
                "Subject = "
                        + detailedRequest.getSubject()
                        + "\nTopics = "
                        + topics
                        + "\nThis question paper must have "
                        + detailedRequest.getDetailedSectionRequest().size()
                        + " Sections with following details";
        for (DetailedSectionRequest s : detailedRequest.getDetailedSectionRequest()) {
            ttl = ttl + s.getSectionMarks();
            prompt =
                    prompt
                            + "\nSection "
                            + s.getSectionName()
                            + " carrying " + s.getSectionMarks() + " marks "
                            + " having " + s.getNumberOfQuestions() +
                            " questions, details for each question is mentioned below";
            for (Question q : s.getQuestionList()) {
                if (q.getQuestionType().equals(QuestionType.MULTIPLE_CHOICE_QUESTION)) {
                    prompt = prompt + "\nQuestion type= " +
                            q.getQuestionType() + " marks= " +
                            q.getMarks() + " difficulty= " +
                            q.getDifficulty();
                } else {
                    prompt = prompt + "\nQuestion type= " +
                            q.getQuestionType() + " marks= " +
                            q.getMarks() + " difficulty= " +
                            q.getDifficulty();
                }

            }
        }
        return prompt = promptPrefix + ttl + prompt + promptSuffix;
    }

    private String generatePrompt(ExaminerRequest request) {
        Double ttl = 0.0;
        String topics = "";
        for (String t : request.getTopic()) {
            topics = topics + ", " + t;
        }
        String prompt =
                "Subject = "
                        + request.getSubject()
                        + "\nTopics = "
                        + topics
                        + "\nThis question paper must have "
                        + request.getSectionsInRequest().size()
                        + " Sections with following details";
        for (SectionRequest s : request.getSectionsInRequest()) {
            ttl = ttl + s.getSectionMarks();
            prompt =
                    prompt
                            + "\nSection "
                            + s.getSectionName()
                            + " carrying "
                            + s.getSectionMarks()
                            + " marks having "
                            + s.getNumberOfQuestions()
                            + " questions of type "
                            + s.getQuestionType()
                            + " each carrying "
                            + s.getMarks()
                            + " marks ";
        }
        return prompt = promptPrefix + ttl + prompt + promptSuffix;
    }
}
