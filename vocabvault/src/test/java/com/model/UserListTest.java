package com.model;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

public class UserListTest {
    UserList userList = UserList.getInstance();
    ArrayList<User> newList = userList.getUsers();

    @Test
public void testHaveUserValidFirstItem() {
		boolean hasAmy = userList.haveUser("asmith");
		assertTrue(hasAmy);
	}
}
