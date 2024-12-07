package com.model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserProgressTracker {
    private User user;
    private String language;
    private int totalQuestionsAnswered;
    private int correctAnswers;
    private ArrayList<String> missedQuestions;
    private ArrayList<String> missedWords;

    public UserProgressTracker(User user) {
        this.user = user;
        this.totalQuestionsAnswered = user.getTotalQuestionsAnswered();
        this.correctAnswers = user.getCorrectAnswers();
        this.missedQuestions = user.getMissedQ();
        this.missedWords = user.getMissedW();
        this.language = "Spanish";
    }

    /**
     * Logs an answered question and updates performance stats.
     *
     * @param question The question answered.
     * @param isCorrect Whether the user answered correctly.
     */
    public void logQuestion(String question, boolean isCorrect) {
        totalQuestionsAnswered++;
        user.setTotalQuestionsAnswered(totalQuestionsAnswered);
        if (isCorrect) {
            correctAnswers++;
            user.setCorrectAnswers(correctAnswers);
        } else {
            if (!missedQuestions.contains(question)) {
                missedQuestions.add(question); 
                DataWriter.saveUsers(); 
            }
        }
    }

    public void logWord(String word, boolean isCorrect) {
        if (isCorrect) {
            if(missedWords.contains(word)){
                missedWords.remove(word);
                DataWriter.saveUsers();
            }
        } else {
            if (!missedWords.contains(word)) {
                missedWords.add(word); 
                DataWriter.saveUsers();
            }
        } 
    }

    /**
     * Gets the user's overall accuracy as a percentage.
     *
     * @return The accuracy percentage.
     */
    public double getAccuracy() {
        if (totalQuestionsAnswered == 0) return 0;
        return (double) correctAnswers / totalQuestionsAnswered * 100;
    }

    /**
     * Returns a list of questions the user commonly misses.
     *
     * @return ArrayList of commonly missed questions.
     */
    public ArrayList<String> getMissedQuestions() {
        return this.missedQuestions;
    }

    public void printMissedQuestions() {
        if (missedQuestions.isEmpty()) {
            System.out.println("None");
        } else {
            for (String question : missedQuestions) {
                System.out.println(question); // Display each missed question
            }
        }
    }

    public ArrayList<String> getMissedWords() {
        return this.missedWords;
    }

    public void printMissedWords() {
        if (missedWords.isEmpty()) {
            System.out.println("None");
        } else {
            for (String word : missedWords) {
                System.out.println(word); // Display each missed word
            }
        }
    }

    /**
     * Displays a summary of the user's progress.
     */
    public void displayProgress() {
        System.out.println("User: " + user.getUsername());
        System.out.println("Total Questions Answered: " + totalQuestionsAnswered);
        System.out.println("Correct Answers: " + correctAnswers);
        System.out.println("Accuracy: " + getAccuracy() + "%");
        System.out.println("Current Language: Spanish");
    }
}
