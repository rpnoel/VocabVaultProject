package com.model;

import java.util.ArrayList;

/**
 * Represents a book with a title, text content, and a list of vocabulary words.
 * 
 * TEST TEST
 */
public class Book {
    /**
     * The title of the book.
     */
    private String title;

    /**
     * The text content of the book.
     */
    private String bookText;

    /**
     * The list of vocabulary words contained in the book.
     */
    private ArrayList<Word> vocabWords;

    /**
     * Constructs a new Book with the specified title, text content, and vocabulary words.
     *
     * @param title      the title of the book
     * @param bookText   the text content of the book
     * @param vocabWords the list of vocabulary words in the book
     */
    public Book(String title, String bookText, ArrayList<Word> vocabWords) {
        this.title = title;
        this.bookText = bookText;
        this.vocabWords = vocabWords;
    }

    /**
     * Gets the title of the book.
     *
     * @return the title of the book
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Gets the text content of the book.
     *
     * @return the text content of the book
     */
    public String getText() {
        return this.bookText;
    }

    /**
     * Gets the list of vocabulary words in the book.
     *
     * @return the list of vocabulary words
     */
    public ArrayList<Word> getVocabWords() {
        return this.vocabWords;
    }
}

