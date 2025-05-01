package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class AuthManagerTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private HashLibrary hashLibrary;

    @InjectMocks
    private AuthManager authManager;



    private final String email = "nandan@example.com";
    private final String wrongEmail = "nonexistent@email.com";
    private final String password = "password123";
    private final String hashedPassword = "hashed_password123";
    private final String wrongPassword = "password456";
    private final String hashedWrongPassword = "hashed_password456";
    private final User user = new User("Test User", email, hashedPassword);

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        when(userRepository.findByEmail(email)).thenReturn(user);
        when(userRepository.findByEmail(wrongEmail)).thenThrow(new Exception());
        when(hashLibrary.hash(password)).thenReturn(hashedPassword);
        when(hashLibrary.hash(wrongPassword)).thenReturn(hashedWrongPassword);
    }

    @Test
    public void testForSuccessfulLogin() throws Exception {
        assertTrue(authManager.login(email,password));
        verify(userRepository).findByEmail(email);
        verify(hashLibrary).hash(password);
    }

    @Test
    public void testForUnsuccessfulLoginForWrongEmail() throws Exception {
        assertFalse(authManager.login(wrongEmail,password));
        verify(userRepository).findByEmail(wrongEmail);
    }

    @Test
    public void testForUnsuccessfulLoginForWrongPassword() throws Exception {
        assertFalse(authManager.login(email,wrongPassword));
        verify(userRepository).findByEmail(email);
        verify(hashLibrary).hash(wrongPassword);
    }

}
