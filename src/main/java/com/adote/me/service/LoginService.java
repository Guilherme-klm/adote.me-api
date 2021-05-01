package com.adote.me.service;

import com.adote.me.converter.LoginConverter;
import com.adote.me.dtl.login.LoginInputDTO;
import com.adote.me.dtl.login.LoginOutputDTO;
import com.adote.me.model.Login;
import com.adote.me.model.UserLogged;
import com.adote.me.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginRepository repository;

    private LoginConverter converter;

    public LoginOutputDTO getAccountIdAndName(LoginInputDTO inputDTO) {
        var login = converterDtoToClass(inputDTO);
        var userLogged = getIdUser(login);
        return converterClassToDto(userLogged);
    }

    private UserLogged getIdUser(Login login) {
        return repository.existsAccountByEmailAndId(login.getEmail(), login.getPassword());
    }

    private Login converterDtoToClass(LoginInputDTO loginInputDTO) {
        converter = new LoginConverter(loginInputDTO);
        return (Login) converter.dtoToEntity();
    }

    private LoginOutputDTO converterClassToDto(UserLogged userLogged) {
        if(userLogged != null) {
            converter = new LoginConverter(userLogged);
            return (LoginOutputDTO) converter.entityToDto();
        }
        return null;
    }
}
