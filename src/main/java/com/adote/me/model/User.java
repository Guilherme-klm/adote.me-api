package com.adote.me.model;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "usuario_id")
    private Long id;

    @Column(name = "usuario_nome")
    private String name;

    @Column(name = "usuario_data_nascimento")
    private String birthDate;

    @Column(name = "usuario_email")
    private String email;

    @Column(name = "usuario_senha")
    private String password;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "endereco_id")
    private Address address;


    public User(String name, String birthDate, String email, String password, Address address) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
        this.address = address;
    }

    public User () {}

    public Long getId() {
        return id;
    }

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

    public Address getAddress() {
        return address;
    }
}
