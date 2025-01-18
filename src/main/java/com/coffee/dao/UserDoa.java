package com.coffee.dao;

import com.coffee.POJO.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UserDoa extends JpaRepository<User,Integer> {

    User findByEmailId(@Param("email") String email);
}
