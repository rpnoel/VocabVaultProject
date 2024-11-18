package com.model;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.model.DataLoader;
import com.model.UserList;
import com.model.User;

public class DataLoaderTest {
    UserList userList = UserList.getInstance();
    ArrayList<User> newList = userList.getUsers();

    @Before
public void setup(){
        newList.add(new User("ryry", "ryry@gmail.com", "Ryan", "Noel", "rguy13324"));
        DataWriter.saveUsers();
    }

    @After
    public void tearDown() {
        UserList.getInstance().getUsers().clear();
        DataWriter.saveUsers();
    }

    @Test
    public void testGetUsersSize() {
        newList = DataLoader.getUsers();
        assertEquals(2, newList.size());
    }


}