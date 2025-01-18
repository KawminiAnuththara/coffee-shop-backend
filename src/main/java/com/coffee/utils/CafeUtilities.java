package com.coffee.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CafeUtilities {

    // Utility method to generate a ResponseEntity with a custom message and HTTP status
    public static ResponseEntity<String> getResponseEntity(String responseMessage, HttpStatus httpStatus) {
        return new ResponseEntity<>("{\"message\":\"" + responseMessage + "\"}", httpStatus);
    }
}
