package com.adote.me.repository;

import com.adote.me.model.User;
import com.adote.me.model.UserLogged;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<User, Long> {

    @Query("select new com.adote.me.model.UserLogged(u.id, u.name) from User u where email = :email and password = :password")
    UserLogged existsAccountByEmailAndId(@Param("email") String email, @Param("password") String password);

}
