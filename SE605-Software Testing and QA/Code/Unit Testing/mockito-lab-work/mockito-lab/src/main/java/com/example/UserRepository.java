package com.example;

public class UserRepository {
    public User findByEmail(String email) throws Exception {
        throw new Exception("User not found");
    }
}
