package com.adote.me.service;

import com.adote.me.dtl.login.LoginInputDTO;
import com.adote.me.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginRepository repository;

    public Long getIdUser(LoginInputDTO loginInputDTO) {
        return repository.existsAccountByEmailAndId(loginInputDTO.getEmail(), loginInputDTO.getPassword());
    }
}
