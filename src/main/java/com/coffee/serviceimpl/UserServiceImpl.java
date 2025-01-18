package com.coffee.serviceimpl;

import com.coffee.POJO.User;
import com.coffee.constant.CafeConstant;
import com.coffee.dao.UserDoa;
import com.coffee.service.UserServiceInterface;
import com.coffee.utils.CafeUtilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserServiceInterface {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserDoa userDoa;

    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        log.info("Inside signup {}", requestMap);

        try {
            if (validateSignUpMap(requestMap)) {
                User user = userDoa.findByEmailId(requestMap.get("email"));

                if (Objects.isNull(user)) {
                    userDoa.save(getUserFormMap(requestMap));
                    return CafeUtilities.getResponseEntity("Successfully Registered.", HttpStatus.OK);
                } else {
                    return CafeUtilities.getResponseEntity("Email already exists.", HttpStatus.BAD_REQUEST);
                }
            } else {
                return CafeUtilities.getResponseEntity(CafeConstant.INVALID_DATA, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception ex) {
            log.error("Exception during signup: ", ex);
        }
        return CafeUtilities.getResponseEntity(CafeConstant.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private boolean validateSignUpMap(Map<String, String> requestMap) {
        return requestMap.containsKey("name") &&
                requestMap.containsKey("contactNumber") &&
                requestMap.containsKey("email") &&
                requestMap.containsKey("password");
    }

    private User getUserFormMap(Map<String, String> requestMap) {
        User user = new User();
        user.setName(requestMap.get("name"));
        user.setContactNumber(requestMap.get("contactNumber"));
        user.setEmail(requestMap.get("email"));
        user.setPassword(requestMap.get("password"));
        user.setStatus("false");
        user.setRole("user");
        return user;
    }
}
