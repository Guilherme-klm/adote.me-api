package com.adote.me.dtl.user;

import com.adote.me.dtl.address.AddressOutputDTO;
import com.adote.me.model.Address;

public class UserOutputDTO {

    private Long id;

    private String name;

    private String birthDate;

    private String email;

    private String password;

    private AddressOutputDTO addressOutputDTO;

    public UserOutputDTO(Long id, String name, String birthDate, String email, String password, Address address) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
        this.addressOutputDTO = new AddressOutputDTO(address.getId(), address.getCountry(), address.getState(), address.getCity(), address.getNeighborhood(), address.getStreet(), address.getNumber());
    }

    public Long getId() {
        return id;
    }

    public UserOutputDTO() {}

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public AddressOutputDTO getAddressOutputDTO() {
        return addressOutputDTO;
    }
}
