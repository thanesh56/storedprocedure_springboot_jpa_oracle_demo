package com.gl.storedprocedure_springboot_jpa_oracle_demo.dao;

import com.gl.storedprocedure_springboot_jpa_oracle_demo.model.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();
    String getNameById(Integer userId);
    User getUserById(Integer userId);
}
