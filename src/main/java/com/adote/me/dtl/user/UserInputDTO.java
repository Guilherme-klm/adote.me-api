package com.adote.me.dtl.user;

import com.adote.me.dtl.address.AddressInputDTO;
import com.adote.me.model.Address;
import com.adote.me.model.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserInputDTO {

    @NotEmpty(message = "Nome não pode ser vazio!")
    @JsonProperty("name")
    private String name;

    @NotEmpty
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonProperty("birthDate")
    private String birthDate;

    @NotEmpty(message = "E-mail invalido")
    @Email(message = "E-mail inválido")
    @JsonProperty("email")
    private String email;

    @NotEmpty(message = "Senha não pode ser vazia!")
    @Size(min = 6, message = "A senha deve conter no minimo 6 caracteres!")
    @JsonProperty("password")
    private String password;

    @Valid
    @JsonProperty("address")
    private AddressInputDTO address;

    public UserInputDTO() {}

    public User dtoToUser () {
        return new User(name, birthDate, email, password,
               new Address(address.getCountry(),address.getState(), address.getCity(),
                           address.getNeighborhood(), address.getStreet(), address.getNumber()));
    }

    public AddressInputDTO getAddress() {
        return address;
    }

    public void setAddress(AddressInputDTO address) {
        this.address = address;
    }
}
