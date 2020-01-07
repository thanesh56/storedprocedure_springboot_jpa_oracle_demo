package com.gl.storedprocedure_springboot_jpa_oracle_demo.controller;



import com.gl.storedprocedure_springboot_jpa_oracle_demo.dao.UserDao;
import com.gl.storedprocedure_springboot_jpa_oracle_demo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@RestController
public class UserController {

    @Autowired
    UserDao userDao;

    @GetMapping(path = "/users")
    public ResponseEntity<List<User>> getAllUsers() {

        log.info("getAllUsers called");
        Iterable<User> users = userDao.getAllUsers();
        log.info("userDao called");
        List<User> target = new ArrayList<>();
        users.forEach(target::add);
        return ResponseEntity.ok(target);

    }

    @GetMapping(path = "/users/{id}")
    public ResponseEntity<?> getNameById(@PathVariable(required = true) Integer id){
        return ResponseEntity.ok(userDao.getNameById(id));
    }

    /*@GetMapping(path = "/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(required = true) Integer id){
        return ResponseEntity.ok(userDao.getUserById(id));
    }*/




}
