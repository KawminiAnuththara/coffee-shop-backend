package com.coffee.service;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface UserServiceInterface {
    ResponseEntity<String> signUp(Map<String, String> requestMap);
}
