package com.gl.storedprocedure_springboot_jpa_oracle_demo.repository;

import com.gl.storedprocedure_springboot_jpa_oracle_demo.model.User;

import java.util.List;

public interface UserRepositoryCustom {

    List<User> getAllUsers();
    String getNameById(Integer userId);
    User getUserById(Integer userId);
    Integer saveUser(User user);
}
