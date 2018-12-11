package org.launchcode.boot.hellospring.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class User {

    @NotNull
    @Size(min = 5,max = 15)
    private String username;

    @NotNull
    @Size(min = 1,message = "Please enter the Email")
    private String email;

    @NotNull
    @Size(min = 3, message = "Enter the valid password")
    private String password;

    private static int userId;
    private static int nextId = 1;

    //private Date userJoined;



    public User(String username,String email,String password){
        this();
        this.username = username;
        this.email = email;
        this.password = password;

    }
    public User(){
        userId = nextId;
        nextId++;
    }
    //getters
    public String getUsername(){ return username;}
    public String getEmail(){ return email;}
    public String getPassword(){ return password;}
    public int getUserId() {
        return userId;
    }

    //setters
    public void setUsername(String username){
        this.username = username;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setUserId(int userId) {
        User.userId = userId;
    }

    //add methods
    public static void add(User user){

    }
    public static void verifyPassword(String varifyPassword){

    }

}
