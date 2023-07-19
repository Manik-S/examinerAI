package com.hackathon.examinerAI.service;

import com.hackathon.examinerAI.model.*;
import com.hackathon.examinerAI.util.OpenAIUtil;
import com.hackathon.examinerAI.util.PDFReaderUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.hackathon.examinerAI.configuration.ExaminerConstants.*;

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

    @Override
    public QuestionPaperResult generateResult(ExaminerRequestWithText examinerRequestWithText) {
        QuestionPaperResult questionPaperResult = new QuestionPaperResult();
        questionPaperResult.setId(examinerRequestWithText.getId());
        log.info("Generating prompt..");
        String prompt = generatePrompt(examinerRequestWithText);
        log.info("Prompt generated successfully\n" + prompt + "\n");
        questionPaperResult.setQuestionPaper(promptOpenAI(prompt));
        return questionPaperResult;
    }

    @Override
    public QuestionPaperResult generateResult(ExaminerRequestWithPDF request) {
        QuestionPaperResult questionPaperResult = new QuestionPaperResult();
        questionPaperResult.setId(request.getId());
        log.info("Generating prompt..");
        String text="";
        try {
             text = PDFReaderUtil.readPDF("/Users/masingh/Downloads/examinerAI/src/main/resources/"+request.getFilePath());
        }
        catch (Exception e){
            log.error(e.getMessage());
        }

        ExaminerRequestWithText examinerRequestWithText=new ExaminerRequestWithText();
        examinerRequestWithText.setId(request.getId());
        examinerRequestWithText.setDifficulty(request.getDifficulty());
        examinerRequestWithText.setSectionsInRequest(request.getSectionsInRequest());
        examinerRequestWithText.setText(text);

        String prompt = generatePrompt(examinerRequestWithText);
        log.info("Prompt generated successfully\n" + prompt + "\n");
        questionPaperResult.setQuestionPaper(promptOpenAI(prompt));
        return questionPaperResult;
    }

    private String promptOpenAI(String prompt) {

        return openAIUtil.generateMessage(prompt);
    }

    private String generatePrompt(ExaminerRequestWithText examinerRequestWithText) {
        Double ttl = 0.0;
        String prompt = "\n###TEXT### " + examinerRequestWithText.getText()
                +"###MANDATORY CONDITION### Like a comprehension the questions should be from the text"
                + "\n###CONTEXT### The question paper must have the following details"
                +"\nSubject based on the text provided "
                +"\nTopics which are provided in the text"
                + "\n###DIFFICULTY### " + examinerRequestWithText.getDifficulty()
                + "\nThis question paper must have "
                + examinerRequestWithText.getSectionsInRequest().size()
                + " sections with following details";

        for (SectionRequest s : examinerRequestWithText.getSectionsInRequest()) {
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
        return promptPrefixWithText + ttl + prompt + promptSuffix;
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
        log.info("Before Iterator id= " + request.getId() + " diff= " + request.getDifficulty() + " subject= " + request.getSubject() + " topic= " + request.getTopic());
        for (String t : request.getTopic()) {
            topics = topics + ", " + t;
        }
        String prompt =
                "Subject = "
                        + request.getSubject()
                        + "\nTopics = "
                        + topics
                        + " and the difficulty of the generated questions must be "
                        + request.getDifficulty()
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
