package com.example;

public class AuthManager {
    private UserRepository userRepository;
    private HashLibrary hashLibrary;

    public AuthManager(UserRepository userRepository, HashLibrary hashLibrary) {
        this.userRepository = userRepository;
        this.hashLibrary = hashLibrary;
    }

    public boolean login(String email, String password) throws Exception {
        try{
            User user = userRepository.findByEmail(email);
            String hashedPassword = hashLibrary.hash(password);
            return hashedPassword.equals(user.getPassword());
        }catch(Exception exception){
            return false;
        }
    }
}
