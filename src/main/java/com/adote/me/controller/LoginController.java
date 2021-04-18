package com.adote.me.controller;

import com.adote.me.dtl.login.LoginInputDTO;
import com.adote.me.dtl.login.LoginOutputDTO;
import com.adote.me.service.LoginService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "login")
public class LoginController {

    @Autowired
    private LoginService service;

    @PostMapping(value = "/login")
    public ResponseEntity<LoginOutputDTO> getIdAccountByEmailAndPassword(@RequestBody LoginInputDTO loginInputDTO) {
        var outputDTO = service.getAccountIdAndName(loginInputDTO);

        if (outputDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(outputDTO);
    }
}
