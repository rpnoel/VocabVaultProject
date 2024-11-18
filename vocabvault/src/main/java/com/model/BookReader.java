package com.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.StringBuilder;
import java.util.ArrayList;

/**
 * Reads a book from a file and creates a Book object.
 * The file should contain vocabulary words and the book content.
 * 
 * @author Max Granger
 */
public class BookReader {
    /**
     * The Book object created from the file data.
     */
    public Book book;

    /**
     * Constructs a BookReader by reading data from the specified file.
     * 
     * @param fileName the name of the file to read
     */
    public BookReader(String fileName) {
        ArrayList<Word> vocabWords = new ArrayList<Word>();
        String title = "";
        StringBuilder bodyText = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            if (line != null) {
                String[] words = line.split(",");
                for (int i = 0; i < words.length - 1; i += 2) {
                    vocabWords.add(new Word(words[i], words[i + 1]));
                }
            }
            title = reader.readLine();
            String line2 = reader.readLine();
            while ((line2 = reader.readLine()) != null) {
                bodyText.append(line2).append("\n");
            }
            this.book = new Book(title, bodyText.toString(), vocabWords);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Returns the Book object created by this BookReader.
     * 
     * @return the Book object
     */
    public Book getBook() {
        return this.book;
    }

    /**
     * Returns a string representation of the BookReader, including the book's title, body text, and vocabulary words.
     * 
     * @return a string representation of the BookReader
     */
    @Override
    public String toString() {
        if (book != null) {
            return "Title: " + book.getTitle() + "\nBody:\n" + book.getText() + "\nVocabulary Words:\n" + book.getVocabWords();
        } else {
            return "No book data available.";
        }
    }

    /**
     * Main method for testing the BookReader functionality.
     * 
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

    }
}

