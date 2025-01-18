package com.coffee.restImpl;

import com.coffee.constant.CafeConstant;
import com.coffee.rest.UserInterface;
import com.coffee.service.UserServiceInterface;
import com.coffee.utils.CafeUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
            return userService.signUp(requestMap); // Placeholder response
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return CafeUtilities.getResponseEntity(CafeConstant.SOMETHING_WENT_WRONG,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
