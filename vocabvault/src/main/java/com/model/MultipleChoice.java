package com.model;

import java.util.ArrayList;

/**
 * Represents a multiple-choice question where the user selects the correct translation
 * of a given word from four options.
 * 
 * Created by Max Granger.
 */
public class MultipleChoice extends Question {
    
    /**
     * The text of the multiple-choice question.
     */
    private String questionText;

    /**
     * The list of answer choices for the question.
     */
    private ArrayList<String> choices;

    /**
     * The index of the correct answer in the choices list (1-4).
     */
    private int correctAnswer;

    /**
     * Constructs a MultipleChoice question for the specified word. Sets the question text,
     * generates a random correct answer index, and adds the correct translation to the choices.
     * 
     * @param word the Word object containing the word to be translated
     */
    public MultipleChoice(Word word) {
        this.questionText = "Choose the correct translation of " + word.getWordText() + ".";
        this.correctAnswer = (int) (Math.random() * 3) + 1;
        this.choices = getChoices();
        choices.add(correctAnswer, word.getTranslation());
    }

    /**
     * Gets the index of the correct answer in the choices list.
     * 
     * @return the index of the correct answer (1-4)
     */
    public int getCorrAnswer() {
        return this.correctAnswer;
    }

    /**
     * Gets the text of the correct answer choice.
     * 
     * @return the correct answer text
     */
    public String getCorrectAnswerText() {
        return choices.get(correctAnswer); 
    }

    /**
     * Checks if the user's answer index matches the correct answer.
     * 
     * @param userAnswer the index of the answer chosen by the user
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
     * Returns a string representation of the multiple-choice question and its answer choices.
     * 
     * @return the question text and choices formatted as a string
     */
    @Override
    public String toString() {
        return questionText + "\n\t1. " + choices.get(0) + "\n\t2. " + choices.get(1) + "\n\t3. " + choices.get(2) + "\n\t4. " + choices.get(3) + "\n";
    }
}
