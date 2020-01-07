package com.gl.storedprocedure_springboot_jpa_oracle_demo.dao.impl;

import com.gl.storedprocedure_springboot_jpa_oracle_demo.dao.UserDao;
import com.gl.storedprocedure_springboot_jpa_oracle_demo.model.User;
import com.gl.storedprocedure_springboot_jpa_oracle_demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDaoImpl implements UserDao {

    @Autowired
    UserRepository userRepository;


    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public String getNameById(Integer userId) {
       return userRepository.getNameById(userId);
    }

    @Override
    public User getUserById(Integer userId) {
        return userRepository.getUserById(userId);
    }

    @Override
    public User saveUser(User user) {

        return userRepository.findById(userRepository.saveUser(user)).orElse(null);
       // return userRepository.saveUser(user);
    }


}
