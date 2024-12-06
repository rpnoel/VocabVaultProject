package com.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/**
 * Represents a matching question, where the user must match a word to its correct translation.
 * 
 * Created by Connor Ilgenfritz.
 */
public class Matching extends Question {
    
    /**
     * The text of the matching question.
     */
    private String questionText;

    /**
     * The correct answer for the matching question.
     */
    private int correctAnswer;
    private ArrayList<String> choices;
    private String wordText;
    private final int qType = 2;

    /**
     * Constructs a Matching question with the specified word and correct answer.
     *
     * @param word the Word object containing the word to be matched
     * @param correctAnswer the correct answer (translation) for the matching question
     */
    public Matching(Word word) {
        this.wordText = word.getWordText();
        this.questionText = "Match the English word to its Spanish translation: " + word.getTranslation();
        this.correctAnswer = (int) (Math.random() * 3) + 1;
        this.choices = this.generateChoices();
        choices.add(correctAnswer, word.getWordText()); 
    }

    public ArrayList<String> getChoices() {
        ArrayList<String> allChoices = this.generateChoices();
        allChoices.remove(this.getWordText());
        Random rand = new Random();
        this.choices = new ArrayList<String>();
        
        if (allChoices.size() < 3) {
            return allChoices; 
        }

        for (int i = 0; i < 3; i++) {
            int index = rand.nextInt(allChoices.size());
            choices.add(allChoices.get(index));
            allChoices.remove(index); // Ensure no duplicate choices
        }

        return choices;
    }
    //generates specific choices from answerChoicesESP.txt instead of answerChoices.txt
    private ArrayList<String> generateChoices() {
        HashSet<String> uniqueChoices = new HashSet<>(); 
        ArrayList<String> choices = new ArrayList<>(); 
        try (BufferedReader reader = new BufferedReader(new FileReader("VocabVault\\txt\\answerChoicesESP.txt"))) {
            String line;
            while ((line = reader.readLine()) != null && uniqueChoices.size() < 50) { 
                uniqueChoices.add(line); 
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    
        choices.addAll(uniqueChoices);
        
        return choices;
    }
    @Override
    public ArrayList<String> returnChoices() {
        return this.choices;
    }
    /**
     * Checks if the user's answer matches the correct answer, ignoring case.
     *
     * @param userAnswer the answer provided by the user
     * @return true if the user's answer matches the correct answer, false otherwise
     */
    public boolean checkAnswer(String userAnswer) {
        try {
            int userInt = Integer.parseInt(userAnswer);
            userInt = userInt - 1;
            if (userInt < 5 || userInt > 0) {
                if (userInt == this.correctAnswer) {
                    return true;
                }
            }
            return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Gets the correct answer for the matching question.
     *
     * @return the correct answer
     */
    public int getCorrectAnswer() {
        return this.correctAnswer;
    }

    /**
     * Gets the question text for the matching question.
     *
     * @return the question text
     */
    public String getQuestionText() {
        return this.questionText;
    }

    public String getWordText() {
        return this.wordText;
    }

    /**
     * Returns a string representation of the matching question.
     *
     * @return the question text as a string
     */
    @Override
    public String toString() {
        return questionText + "\n\t1. " + choices.get(0) + "\n\t2. " + choices.get(1) + "\n\t3. " + choices.get(2) + "\n\t4. " + choices.get(3) + "\n";
    }
}

