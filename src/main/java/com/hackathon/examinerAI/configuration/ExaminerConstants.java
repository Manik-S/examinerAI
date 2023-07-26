package com.hackathon.examinerAI.configuration;

public class ExaminerConstants {
    public static String promptPrefix =
            "Create a random question paper having the following details\nDisplay topics and total marks next to the subject ,total marks = ";
    public static String promptSuffix =
            "\nOther details to consider:"
                    + "\nDisplay all marks in integers, and mention subject name as \"{subject} question paper\" dont mention the text\"Subject\""
                    + "\nThe heading should be in this order Subject then topics then total marks"
                    + "\nDont display question type and difficulty anywhere in the paper"
                    + "\nGenerate and display the options for MULTIPLE_CHOICE_QUESTION "
                    + "\nDisplay marks of each section next to section name, and marks for each question to the right of each questions";
    public static String promptPrefixWithText = "Using the following text as source, generate a question paper having total marks= ";
    public static int varN = 1;
    public static double varTemperature = 0.3;
}
