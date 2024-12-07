package com.model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/* CHange */
public class User {
    private UUID userID;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private ArrayList<String> missedQuestions;
    private ArrayList<String> missedWords;
    private int totalQuestionsAnswered; 
    private int correctAnswers;        

    public User(String username, String email, String firstName, String lastName, String password){
        this.userID = UUID.randomUUID();
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.missedQuestions = new ArrayList<>();
        this.missedWords = new ArrayList<>();
        this.totalQuestionsAnswered = 0; 
        this.correctAnswers = 0;         
    }

    public User(UUID userID, String username, String email, String firstName, String lastName, String password){
        this.userID = userID;
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.missedQuestions = new ArrayList<>();
        this.missedWords = new ArrayList<>();
    }

    /**
     * Gets the username of the user.
     *
     * @return The user's username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the email of the user.
     *
     * @return The user's email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets a new email for the user.
     *
     * @param email The new email to be set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the first name of the user.
     *
     * @return The user's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the user.
     *
     * @param firstName The user's first name to be set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the user.
     *
     * @return The user's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the user.
     *
     * @param lastName The user's last name to be set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password= password;
    }

    public boolean checkPassword(String password){
        return this.password.equals(password);
    }

    public UUID getUserId(){
        return userID;
    }

    public void setUserId(UUID userID){
        this.userID= userID;
    }

    public void addMissedQ(String question) {
        if (!missedQuestions.contains(question)) {
            missedQuestions.add(question);
        }
    }

    public ArrayList<String> getMissedQ() {
        return missedQuestions;
        }

        public void addMissedW(String word) {
            if (!missedWords.contains(word)) {
                missedWords.add(word);
            }
        }
    
        public ArrayList<String> getMissedW() {
            return missedWords;
            }

        public void setMissedWords(ArrayList<String> missedWords) {
            this.missedWords = missedWords;
        }
        
        public void setMissedQuestions(ArrayList<String> missedQuestions) {
            this.missedQuestions = missedQuestions;
        }

    public int getTotalQuestionsAnswered() {
        return totalQuestionsAnswered;
    }

    public void setTotalQuestionsAnswered(int totalQuestionsAnswered) {
        this.totalQuestionsAnswered = totalQuestionsAnswered;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
    }
    

    


}
