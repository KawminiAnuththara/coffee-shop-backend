package com.coffee.dao;

import com.coffee.POJO.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDoa extends JpaRepository<User,Integer> {
}
