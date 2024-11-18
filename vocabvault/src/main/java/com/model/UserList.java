package com.model;
import java.util.ArrayList;

public class UserList {
    private static UserList users;
	private static ArrayList<User> userList;

    private UserList(){
        userList = DataLoader.getUsers();
    }

    public static UserList getInstance(){
        if (userList == null) {
            users = new UserList();
        }
        return users;
    }

public boolean addUser(String username, String email, String firstName, String lastName, String password){
    if(haveUser(username)) return false;

    userList.add(new User(username, email, firstName, lastName, password));
    return true;
}

    public ArrayList<User>getUsers(){
        return userList;
    }

    public boolean haveUser(String userName) {
		for(User user : userList) {
			if(user.getUsername().equals(userName)) {
				return true;
			}
		}
		
		return false;
	}

    public User getUser(String userName) {
		for(User user : userList) {
			if(user.getUsername().equals(userName)) {
				return user;
			}
		}
		
		return null;
	}
    
    public void saveUser(){
        DataWriter.saveUsers();
    }
}
