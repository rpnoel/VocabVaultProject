package com.model;
public abstract class DataConstants {
    protected static final String USER_FILE_NAME = "/com/data/user.json";
    protected static final String USER_FILE_NAME_JSON = "/com/data/user.json";
    protected static final String USER_ID = "userID";
    protected static final String USERNAME = "username";
    protected static final String EMAIL = "email";
    protected static final String FIRST_NAME = "firstname";
    protected static final String LAST_NAME = "lastname";
    protected static final String PASSWORD = "password";
    protected static final String MISSED_QUESTIONS = "missedQuestions";
    protected static final String MISSED_WORDS = "missedWords";

    public static boolean isJUnitTest(){
        for(StackTraceElement element : Thread.currentThread().getStackTrace()){
            if(element.getClassName().startsWith("org.junit.")){
                return true;
            }
        } 
        return false;
        }
        
    }

