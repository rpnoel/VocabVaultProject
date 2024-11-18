package com.model;
public class Word {
    private String wordText;
    private char[] wordSpelling;
    private String wordPronunciation;
    private String translation;

    public Word(String wordText, String translation) {
        this.wordText = wordText;
        wordSpelling = new char[wordText.length()];
        for (int i = 0; i < wordText.length(); i++) {
            this.wordSpelling[i] = wordText.charAt(i);
        }
        this.translation = translation;
        this.wordPronunciation = null;//pronunciation to be implelemted later

    }

    public String getWordText(){
        return wordText;
    }

    public char[] getWordSpelling(){
        return wordSpelling;
    }

    public String getWordPronunciation(){
        return wordPronunciation;
    }

    public String getTranslation() {
        return this.translation;
    }
    @Override
    public String toString() {
        return this.getWordText() + " - " + this.getTranslation();
    }
}
