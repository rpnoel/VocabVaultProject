package com.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import com.model.User;

public class DataWriterTest {
    private UserList users = UserList.getInstance();
	private ArrayList<User> newList = users.getUsers();

    @Test
	public void testWritingZeroUsers() {
		newList = DataLoader.getUsers();
		assertEquals(0, newList.size());
	}
}
