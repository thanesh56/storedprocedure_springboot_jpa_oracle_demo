package com.gl.storedprocedure_springboot_jpa_oracle_demo.repository;

import com.gl.storedprocedure_springboot_jpa_oracle_demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
/*public interface UserRepository extends JpaRepository<User,Integer> {
    @Procedure("getAllUsers")
    List<User> getAllUsers();

    @Procedure("getNameById")
    Object getNameById(@Param("user_id")Integer userId);*/
public interface UserRepository extends CrudRepository<User, Integer>, UserRepositoryCustom {


}
