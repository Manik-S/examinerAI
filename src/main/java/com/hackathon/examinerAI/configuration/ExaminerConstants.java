package com.hackathon.examinerAI.configuration;

public class ExaminerConstants {
    public static String promptPrefix =
            "Create a random question paper having the following details\nDisplay topics and total marks next to the subject ,total marks = ";
    public static String promptSuffix =
            "\nOther details to consider:"
                    + "\nDont display question type and difficulty anywhere in the paper"
                    + "\nGenerate and display the options for MULTIPLE_CHOICE_QUESTION "
                    + "\nDisplay marks of each section next to section name, and marks for each question to the right of each questions";
    public static int varN = 1;
    public static double varTemperature = 0.3;
}
