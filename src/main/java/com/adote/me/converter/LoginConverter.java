package com.adote.me.converter;

import com.adote.me.dtl.login.LoginInputDTO;
import com.adote.me.dtl.login.LoginOutputDTO;
import com.adote.me.model.Login;
import com.adote.me.model.UserLogged;

public class LoginConverter implements BaseConverter {

    private LoginInputDTO inputDTO;

    private UserLogged userLogged;

    public LoginConverter(LoginInputDTO inputDTO) {
        this.inputDTO = inputDTO;
    }

    public LoginConverter(UserLogged userLogged) {
        this.userLogged = userLogged;
    }

    @Override
    public Object dtoToEntity() {
        return new Login(inputDTO.getEmail(), inputDTO.getPassword());
    }

    @Override
    public Object entityToDto() {
        return new LoginOutputDTO(userLogged.getId(), userLogged.getName());
    }
}
