package com.model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * DataWriter is responsible for saving user data to a JSON file.
 */
public class DataWriter extends DataConstants {

    /**
     * Saves the current list of users to a JSON file. Retrieves the list from UserList,
     * converts each user to a JSONObject, and writes the data to the specified file.
     */
    public static void saveUsers() {
        UserList users = UserList.getInstance();
        ArrayList<User> userList = users.getUsers();
        JSONArray jsonUsers = new JSONArray();
        
        for (int i = 0; i < userList.size(); i++) {
            jsonUsers.add(getUserJSON(userList.get(i)));
        }
        
        try (FileWriter file = new FileWriter(USER_FILE_NAME)) {
            file.write(jsonUsers.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Converts a User object into a JSONObject containing the user's details.
     * 
     * @param user the User object to convert
     * @return a JSONObject representing the user's details
     */
    public static JSONObject getUserJSON(User user) {
        JSONObject userDetails = new JSONObject();
        userDetails.put(USER_ID, user.getUserId().toString());
        userDetails.put(USERNAME, user.getUsername());
        userDetails.put(EMAIL, user.getEmail());
        userDetails.put(FIRST_NAME, user.getFirstName());
        userDetails.put(LAST_NAME, user.getLastName());
        userDetails.put(PASSWORD, user.getPassword());
        JSONArray missedQuestionsArray = new JSONArray();
        missedQuestionsArray.addAll(user.getMissedQ());
        userDetails.put(MISSED_QUESTIONS, missedQuestionsArray);
        JSONArray missedWordsArray = new JSONArray();
        missedWordsArray.addAll(user.getMissedW());
        userDetails.put(MISSED_WORDS, missedWordsArray);
        userDetails.put(TOTAL_QUESTIONS_ANSWERED, user.getTotalQuestionsAnswered());
        userDetails.put(CORRECT_ANSWERS, user.getCorrectAnswers());
        return userDetails;
    }

    public static void main(String[] args) {
        UserList userList = UserList.getInstance();
        userList.addUser("john_doe",   "john.doe@example.com",
            "John",
            "Doe",
            "password123");
        DataWriter.saveUsers();
    }
}

