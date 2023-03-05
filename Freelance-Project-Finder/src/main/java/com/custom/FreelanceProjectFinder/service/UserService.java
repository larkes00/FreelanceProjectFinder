package com.custom.FreelanceProjectFinder.service;

import com.custom.FreelanceProjectFinder.model.User;
import com.custom.FreelanceProjectFinder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(long id) {
        return userRepository.getById(id);
    }

    public User getByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            return user.get();
        }
        else {
            return null;
        }
    }

    public void create(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {

        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
        }
    }

    public User update(User user) {
//        return userRepository.save(user);
        return new User();
    }

    public void delete(User user) {
        userRepository.delete(user);
    }
}
