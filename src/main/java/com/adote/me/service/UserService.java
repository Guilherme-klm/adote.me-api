package com.adote.me.service;

import com.adote.me.model.User;
import com.adote.me.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User save (User user) {
        return repository.save(user);
    }

    public Optional<User> getById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public List<User> getAll() {
        return repository.findAll();
    }
}
