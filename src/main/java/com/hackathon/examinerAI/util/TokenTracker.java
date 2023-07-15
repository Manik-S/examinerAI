package com.hackathon.examinerAI.util;

import org.springframework.stereotype.Component;

import java.io.*;

public class TokenTracker {

    public static void updateNumbersInFile(int arg1, int arg2, int arg3) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("/token.txt"));
        String numbers = reader.readLine();
        reader.close();

        String[] tokens = numbers.split("-");
        int num1 = Integer.parseInt(tokens[0]);
        int num2 = Integer.parseInt(tokens[1]);
        int num3 = Integer.parseInt(tokens[2]);

        int updatedNum1 = num1 + arg1;
        int updatedNum2 = num2 + arg2;
        int updatedNum3 = num3 + arg3;

        String updatedNumbers = updatedNum1 + "-" + updatedNum2 + "-" + updatedNum3;
        BufferedWriter writer = new BufferedWriter(new FileWriter("/token.txt"));
        writer.write(updatedNumbers);
        writer.close();
    }
}
