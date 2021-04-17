package com.adote.me.repository;

import com.adote.me.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<User, Long> {

    @Query("select id from User where email = :email and password = :password")
    Long existsAccountByEmailAndId( @Param("email") String email, @Param("password") String password);

}
