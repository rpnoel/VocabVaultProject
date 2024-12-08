package com.model;
import java.util.Random;
import java.util.ArrayList;

/**
 * Represents a true-or-false question where the user must determine the truthfulness of a statement.
 * 
 * Created by Connor Ilgenfritz.
 */
public class TrueFalse extends Question {

    /**
     * The text of the true-or-false question.
     */
    private String questionText;

    /**
     * The correct answer for the question (true or false).
     */
    private boolean correctAnswer;
    private final int qType = 4;
    /**
     * Constructs a TrueFalse question with the specified correct answer.
     *
     * @param correctAnswer the correct answer for the question
     */
    public TrueFalse(Word word) {
        Random random = new Random();
        int rand = random.nextInt(2);
        if (rand == 0) {
            this.questionText = "True or False: " + word.getWordText() + " means " + word.getTranslation() + ". ";
            this.correctAnswer = true;
            } else {
            ArrayList<String> choices = this.getChoices();
            this.questionText = "True or False: " + word.getWordText() + " means " + choices.get(random.nextInt(3));
            this.correctAnswer = false;
        }
    }
    
    public ArrayList<String> returnChoices() {
        return null;
    }

    public boolean checkAnswer(String userAnswer) {
        if (userAnswer != null) {
            boolean userBool;
            if (userAnswer.equalsIgnoreCase("true") || userAnswer.equalsIgnoreCase("t")) {
                userBool = true;
            } else if (userAnswer.equalsIgnoreCase("false") || userAnswer.equalsIgnoreCase("f")) {
                userBool = false;
            } else {
                System.out.println("Incorrect answer format. Wrong!");
                return false;
            }
            if (userBool == this.correctAnswer) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean getCorrectAnswer() {
        return this.correctAnswer;
    }

    /**
     * Gets the text of the true-or-false question.
     *
     * @return the question text
     */
    @Override
    public String getQText() {
        return this.questionText;
    }

    /**
     * Checks if the user's answer matches the correct answer.
     *
     * @param userAnswer the answer provided by the user
     * @return true if the user's answer matches the correct answer, false otherwise
     */
    

    /**
     * Returns a string representation of the true-or-false question.
     *
     * @return the question text as a string
     */
    @Override
    public String toString() {
        return "Question: " + questionText;
    }
}
