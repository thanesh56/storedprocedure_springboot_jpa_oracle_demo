package com.gl.storedprocedure_springboot_jpa_oracle_demo.repository.impl;

import com.gl.storedprocedure_springboot_jpa_oracle_demo.model.User;
import com.gl.storedprocedure_springboot_jpa_oracle_demo.repository.UserRepositoryCustom;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;


public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<User> getAllUsers() {
        StoredProcedureQuery findAllUsers =
                entityManager.createNamedStoredProcedureQuery("getAllUsers");

        return findAllUsers.getResultList();
    }



    @Override
    public String getNameById(Integer userId) {
        StoredProcedureQuery findNameById =
                entityManager.createNamedStoredProcedureQuery("getNameById")
                        .setParameter("user_id",userId);
        return (String)findNameById.getOutputParameterValue("user_name");
    }

    @Override
    public User getUserById(Integer userId) {
        StoredProcedureQuery findUserByName =
                entityManager.createNamedStoredProcedureQuery("getUserById")
                    .setParameter("user_id",userId);
        return (User)findUserByName.getSingleResult();


    }


}