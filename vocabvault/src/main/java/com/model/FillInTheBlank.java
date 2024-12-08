package com.model;

import java.text.Normalizer;
import java.util.ArrayList;
/**
 * Represents a fill-in-the-blank question where the user provides an answer
 * based on a given word's translation.
 * This question requires translating a word into a target language (e.g., Spanish).
 * 
 * @autho Max Granger
 */
public class FillInTheBlank extends Question {
    
    /**
     * The text of the question prompting the user to translate a word.
     */
    public String questionText;

    /**
     * The correct answer for the question.
     */
    public String correctAnswer;

    /**
     * The answer provided by the user.
     */
    public String userAnswer;
    private final int qType = 3;
    /**
     * Constructs a FillInTheBlank question based on the provided word.
     * Sets the question text and the correct answer.
     *
     * @param word the Word object containing the word and its translation
     */
    public FillInTheBlank(Word word) {
        this.questionText = "Translate the following to Spanish: " + word.getTranslation();
        this.correctAnswer = word.getWordText();
    }

    public FillInTheBlank(Question q) {
        this.questionText = q.getQText();
        this.correctAnswer = q.getWord().getTranslation();
    }

    public ArrayList<String> returnChoices() {
        return null;
    }

    @Override
    public String getQText() {
        return this.questionText;
    }

    /**
     * Gets the correct answer for this question.
     *
     * @return the correct answer
     */
    public String getCorrAnswer() {
        return this.correctAnswer;
    }

    /**
     * Checks if the user's answer matches the correct answer.
     *
     * @param userAnswer the answer provided by the user
     * @return true if the user's answer is correct, false otherwise
     */
    public boolean checkAnswer(String userAnswer) {
        if (userAnswer != null) {
            if (userAnswer.equalsIgnoreCase(this.correctAnswer)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns a string representation of the question text.
     *
     * @return the question text as a string
     */
    @Override
    public String toString() {
        return "Question: " + questionText;
    }
}
