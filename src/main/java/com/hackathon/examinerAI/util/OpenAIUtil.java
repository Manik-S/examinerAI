package com.hackathon.examinerAI.util;

import com.hackathon.examinerAI.model.OpenAIRequest;
import com.hackathon.examinerAI.model.OpenAIResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import static com.hackathon.examinerAI.util.TokenTracker.updateNumbersInFile;

@Component
@Slf4j
public class OpenAIUtil {
    @Qualifier("openaiRestTemplate")
    @Autowired
    private RestTemplate restTemplate;

    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.url}")
    private String apiUrl;

    public String generateMessage(String prompt){
        // create a request
        OpenAIRequest request = new OpenAIRequest(model, prompt);

        // call the API
        log.info("Sending response to open AI .." + request);
        OpenAIResponse response = null;
        try {
            response = restTemplate.postForObject(apiUrl, request, OpenAIResponse.class);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        if (response == null || response.getChoices() == null || response.getChoices().isEmpty()) {
            return "No response";
        }

       /* try {
            updateNumbersInFile(response.getUsage().get(0).getCompletion_tokens(), response.getUsage().get(0).getPrompt_tokens(), response.getUsage().get(0).getTotal_tokens());
        }
        catch (Exception e){
            log.error(e.getMessage());
        }*/
        //log.info("Token data: " + response.getUsage());
        log.info(
                "The generated response is:\n" + response.getChoices().get(0).getMessage().getContent());
        // return the first response
        return response.getChoices().get(0).getMessage().getContent();
    }
}
