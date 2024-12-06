package com.model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javafx.fxml.FXML;

import com.narraration.Narriator;

public class VocabVaultFACADE {
    private User user;
    private UserList userList;
    private User currentUser;
    private UserProgressTracker usrProg;
    private Level level;
    private static VocabVaultFACADE facade;

    public VocabVaultFACADE(){
        userList = UserList.getInstance();
    }

    public static VocabVaultFACADE getInstance() {
        if (facade == null) {
            facade = new VocabVaultFACADE();
        }
        return facade;
    }

    public boolean login(String userName, String password){
        if (!userList.haveUser(userName)) return false;
        currentUser = userList.getUser(userName);
        if (currentUser == null || !currentUser.checkPassword(password)) return false;
        
        // Initialize usrProg after successful login
        usrProg = new UserProgressTracker(currentUser);
        return true;
    }

    public boolean add(String userName, String email, String firstName, String lastName, String password){
        if(userList.haveUser(userName)){
            System.err.println("Error: This user already exists");
            return false;
        }
        else if(!email.contains("@") || !email.contains(".com")){
            System.err.println("Error: Email is not valid");
            return false;
        }
        else if(password.length() < 8){
            System.err.println("Error: Password must be at least 8 characters");
            return false;
        }
        else if(password.contains(userName)){
            System.err.println("Error: Password cannot include Username");
            return false;
        }
        boolean newUser = userList.addUser(userName, email, firstName, lastName, password);
        if(newUser){
            DataWriter.saveUsers();
            currentUser = userList.getUser(userName);
            usrProg = new UserProgressTracker(currentUser);
            return true;
        }
            return false;
        }

        public String getCurrentUser() {
            if (currentUser == null) {
                return "Empty";
            }
            return currentUser.getUsername();
        }
        

    public void logout(){
        System.out.println("Goodbye, " + getCurrentUser() + "!");
        currentUser = null;
        usrProg = null;
    }

    public void checkProg() {
        if (usrProg != null) {
            usrProg.displayProgress();
        } else {
            System.out.println("No progress data available.");
        }
    }

    public void checkQues() {
        if (usrProg != null) {
            usrProg.printMissedQuestions();
        } else {
            System.out.println("No progress data available.");
        }
    }

    public void checkWords() {
        if (usrProg != null) {
            usrProg.printMissedWords();
        } else {
            System.out.println("No progress data available.");
        }
    }

    public void createLevel(Book book) {
        level = new Level(1, book);
        for (int i = 0; i < 12; i++) {
            if (i == 3 || i == 7 || i == 11) {
                //true false
            } else if (i == 2 || i == 6 || i == 10) {
                //fitb
            } else if (i == 1 || i == 5|| i == 9) {
                //matching
            } else {
                Question currQ = level.getQuestion(1);
                getQuestion(level, 1);
            }
        }
    } 

    public Question getQuestion(Level level, int questionType) {
        return level.getQuestion(questionType);
    }

    public Level getLevel() {
        return this.level;
    }

    public void play() {
    if (currentUser == null) {
        System.out.println("You must log in to play!");
        return;
    }

    BookReader reader = new BookReader("VocabVault\\txt\\goldilocksESP.txt");
    Scanner scan = new Scanner(System.in);
    Level level = new Level(1, reader.getBook());
    int trackQuestions = 5; 
    int qComplete = 0; 
    Random rand = new Random(); 

    while (qComplete < trackQuestions) {
        int qType = rand.nextInt(4) + 1; 
        Question currQ = level.getQuestion(qType); 
        
        System.out.println(currQ.toString());
        Narriator.playSound(currQ.toString());
        String userInput = scan.nextLine();
        Boolean corr = currQ.checkAnswer(userInput); 
        level.score(corr); // Update score
        String questions = currQ.toString();
        usrProg.logQuestion(questions, corr); // Log the answer
        qComplete++; // Increment the completed question counter
    }

    // Display final score
    System.out.println("Your score: " + level.getScore() + " / " + trackQuestions);
}

    public void reviewTerms() {
        ArrayList<Word> words = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("VocabVault\\txt\\missedWords.txt"))) {
        String line = reader.readLine();
        if (line != null) {
            String[] terms = line.split(",");
            
            for (int i = 0; i < terms.length - 1; i += 2) {
                String spanish = terms[i].trim();
                String english = terms[i + 1].trim();
                words.add(new Word(spanish, english));
            }
        }
    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    }

    for (Word word : words) {
        System.out.println(word);
        String wordOut = word.toString();
        Narriator.playSound(wordOut);
    }

        for(int i = 0; i < words.size(); i++){
            MultipleChoice mC = new MultipleChoice(words.get(i));
            System.out.println(mC.toString());
            Scanner scan = new Scanner(System.in);
            String userInput = scan.nextLine();
            Boolean corr = mC.checkAnswer(userInput); 
            usrProg.logWord(words.get(i).getWordText().toString(), corr);
            if(corr){
                System.out.println("Correct");
            } else{
                System.out.println("Incorrect");
            }
        }
    }
}

    

    

    

