package com.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.UUID;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * DataLoader is responsible for loading user data from a JSON file and 
 * creating User objects.
 */
public class DataLoader extends DataConstants {

    /**
     * Reads user data from a JSON file and returns a list of User objects.
     * 
     * @return an ArrayList of User objects, or null if an error occurs
     */
    public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();

        try {
            InputStream inputStream = DataLoader.class.getResourceAsStream(DataConstants.USER_FILE_NAME);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(inputStreamReader);


            JSONParser parser = new JSONParser();
            JSONArray usersJSON = (JSONArray) parser.parse(reader);

            for (Object userObject : usersJSON) {
                JSONObject userJSON = (JSONObject) userObject;
            
                String userName = (String) userJSON.get(USERNAME);
                String email = (String) userJSON.get(EMAIL);
                String firstName = (String) userJSON.get(FIRST_NAME);
                String lastName = (String) userJSON.get(LAST_NAME);
                String password = (String) userJSON.get(PASSWORD);

                
                User user = new User(userName, email, firstName, lastName, password);

                
                JSONArray missedQuestionsArray = (JSONArray) userJSON.get(MISSED_QUESTIONS);
                ArrayList<String> missedQuestions = new ArrayList<>();
                if (missedQuestionsArray != null) {
                    for (Object word : missedQuestionsArray) {
                        missedQuestions.add((String) word);
                    }
                }
                user.setMissedQuestions(missedQuestions); 

                JSONArray missedWordsArray = (JSONArray) userJSON.get(MISSED_WORDS);
                ArrayList<String> missedWords = new ArrayList<>();
                if (missedWordsArray != null) {
                    for (Object word : missedWordsArray) {
                        missedWords.add((String) word);
                    }
                }
                user.setMissedWords(missedWords); 

                users.add(user);

           }

            return users;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Main method for testing the DataLoader functionality. Retrieves and prints 
     * each user's username and email.
     * 
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        ArrayList<User> users = getUsers();
        for (User user : users) {
            ArrayList<String> missedWords = user.getMissedW();
                for (String word : missedWords) {
                    System.out.println(word); 
            }
        }
    }
}


