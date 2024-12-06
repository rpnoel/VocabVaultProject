package com.model;

import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Random;

/**
 * Represents an abstract question with a question text and a set of answer choices.
 * This class provides methods for retrieving the question text and generating random choices.
 */
public abstract class Question {
    
    /**
     * The text of the question.
     */
    private String questionText;
    private Word word;
    private ArrayList<String> choices;
    private int qType;

    /**
     * Gets the text of the question.
     * 
     * @return the question text
     */
    public String getQText() {
        return this.questionText;
    }

    public Word getWord() {
        return this.word;
    }
    
    public ArrayList<String> returnChoices() {
        return this.choices;
    }

    public ArrayList<String> getChoices() {
        ArrayList<String> allChoices = generateChoices();
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

    public int getQType() {
        return this.qType;
    }

    /**
     * Generates a list of potential answer choices by reading from a file.
     * Reads up to 50 lines from the specified file and adds them to the choices list.
     * 
     * @return a list of answer choices, or null if an error occurs
     */
    private ArrayList<String> generateChoices() {
        ArrayList<String> choices = new ArrayList<String>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("VocabVault\\txt\\answerChoices.txt"));
            String line = reader.readLine();
            while (line != null && choices.size() < 50) {
                choices.add(line);
                line = reader.readLine();
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return choices;
    }

    @Override
public String toString() {
    return questionText; 
}


    public abstract boolean checkAnswer(String userAnswer);
}

