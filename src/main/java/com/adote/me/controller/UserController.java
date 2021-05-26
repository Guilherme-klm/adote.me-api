package com.adote.me.controller;

import com.adote.me.dtl.user.UserInputDTO;
import com.adote.me.exception.ErrorResponse;
import com.adote.me.bl.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Tag(name = "user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/user", produces = "application/json")
    public ResponseEntity<?> postUser (@Valid @RequestBody UserInputDTO userInputDTO, BindingResult result) {

        if (result.hasErrors())
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ErrorResponse(result.getFieldError().getDefaultMessage()).createErrorMessage());

        userService.save(userInputDTO.dtoToUser());
        return ResponseEntity.status(HttpStatus.CREATED).body("coe");
    }
}
