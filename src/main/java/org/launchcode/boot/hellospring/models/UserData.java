package org.launchcode.boot.hellospring.models;

import java.util.ArrayList;

public class UserData {
    static ArrayList<User> users = new ArrayList<>();

    //getAll
    public static ArrayList<User> getUsers(){
        return users;
    }
    //add
    public static void add(User newUser){
        users.add(newUser);
    }
    //remove
    public static void remove(int id){
        User userToRemove = getById(id);
        users.remove(userToRemove);
    }

    //getById
    public static User getById(int id){
        User theUser = null;

        for(User singleUser :users){
            if(singleUser.getUserId() == id){
                theUser = singleUser;
            }
        }
        return theUser;
    }

    //validate password
}
