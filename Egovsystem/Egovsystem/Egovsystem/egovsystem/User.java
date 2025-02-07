package com.mycompany.egovsystem;
abstract class User {
    private String userName;
    private int password;
    private int userId;

    // Constructor
    public User(String userName, int password, int userId) {
        setUserName(userName);
        setPassword(password);
        setUserId(userId);
    }

    // Input validation for userName
    public void setUserName(String userName) {
        if (userName != null && !userName.trim().isEmpty()) {
            this.userName = userName;
        } else {
            throw new IllegalArgumentException("Username must be a non-empty string.");
        }
    }

    public String getUserName() {
        return userName;
    }

    // Input validation for password (positive integers only)
    public void setPassword(int password) {
        if (password > 0) {
            this.password = password;
        } else {
            throw new IllegalArgumentException("Password must be a positive integer.");
        }
    }

    public int getPassword() {
        return password;
    }

    // Input validation for userId (positive integers only)
    public void setUserId(int userId) {
        if (userId > 0) {
            this.userId = userId;
        } else {
            throw new IllegalArgumentException("User ID must be a positive integer.");
        }
    }

    public int getUserId() {
        return userId;
    }

    public User(String userName, int password) {
        this.userName = userName;
        this.password = password;
    }

    public User(String userName) {
        this.userName = userName;
    }
}


