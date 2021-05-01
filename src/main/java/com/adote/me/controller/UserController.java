package com.adote.me.controller;

import com.adote.me.dtl.user.UserInputDTO;
import com.adote.me.dtl.user.UserOutputDTO;
import com.adote.me.model.User;
import com.adote.me.service.UserService;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.util.JSONPObject;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static java.lang.String.*;

@RestController
@Tag(name = "user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/user")
    public List<User> allUsers () {
        return userService.getAll();
    }

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<Optional<User>> getUserById (@PathVariable(value = "id") Long id) {
        var user = userService.getById(id);

        if(user.isEmpty())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);

        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PostMapping(value = "/user")
    public ResponseEntity<?> postUser (@Valid @RequestBody UserInputDTO userInputDTO, BindingResult result) {

        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(format("{'code': 406, 'message': '%s'}",result.getFieldError().getDefaultMessage()));
        }

        var user = userService.save(userInputDTO.dtoToUser());
        var userOutputDTO = new UserOutputDTO(user.getId(), user.getName(), user.getBirthDate(), user.getEmail(), user.getPassword(), user.getAddress());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @DeleteMapping(value = "/user/{id}")
    public ResponseEntity<?> deleteUser (@PathVariable(value = "id") Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok().body("Usuário deletado com sucesso!");
    }
}
