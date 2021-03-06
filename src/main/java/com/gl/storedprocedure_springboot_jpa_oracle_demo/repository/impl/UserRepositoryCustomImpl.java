package com.gl.storedprocedure_springboot_jpa_oracle_demo.repository.impl;

import com.gl.storedprocedure_springboot_jpa_oracle_demo.model.User;
import com.gl.storedprocedure_springboot_jpa_oracle_demo.repository.UserRepositoryCustom;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
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
                            .setParameter("user_id", userId);
            return (String) findNameById.getOutputParameterValue("user_name");

       /* StoredProcedureQuery query = entityManager
                .createStoredProcedureQuery("get_name_by_id")
                .registerStoredProcedureParameter(
                        1,
                        Integer.class,
                        ParameterMode.IN
                )
                .registerStoredProcedureParameter(
                        2,
                        String.class,
                        ParameterMode.OUT
                )
                .setParameter(1,userId);

        query.execute();

        return  (String) query.getOutputParameterValue(2);
        */


    }

    @Override
    public User getUserById(Integer userId) {


            StoredProcedureQuery findUserByName =
                    entityManager.createNamedStoredProcedureQuery("getUserById")
                            .setParameter("user_id",userId);
            return (User)findUserByName.getSingleResult();



    }

    @Override
    public Integer saveUser(User user) {

            StoredProcedureQuery addUser =
                    entityManager.createNamedStoredProcedureQuery("saveUser")
                            .setParameter("user_id", user.getId())
                            .setParameter("user_name", user.getName())
                            .setParameter("user_email", user.getEmail())
                            .setParameter("user_phone", user.getPhone());

            //System.out.println(addUser.getOutputParameterValue("user_id"));
            return (Integer) addUser.getOutputParameterValue("user_id");
            //return  addUser.getOutputParameterValue("user_id");



    }


}
