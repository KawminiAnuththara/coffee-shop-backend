package com.coffee.restImpl;

import com.coffee.rest.UserInterface;
import com.coffee.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserRestImpl implements UserInterface {

    @Autowired
    private UserServiceInterface userService; // Corrected declaration

    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        try {
            // Logic for the sign-up process
            return ResponseEntity.ok("Sign-up successful"); // Placeholder response
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(500).body("An error occurred during sign-up");
        }
    }
}
