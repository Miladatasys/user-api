package com.milacode.user_api.services;

import com.milacode.user_api.models.User;
import com.milacode.user_api.repositories.UserRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UserService {
    
    private final UserRepository userRepository;

    public UserService (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Correo ya registrado");
        }

        // set timestamps
        user.setCreated(LocalDateTime.now());
        user.setModified(LocalDateTime.now());
        user.setLastLogin(LocalDateTime.now());

        // generate token (simple UUID for now)
        user.setToken(UUID.randomUUID().toString());
        user.setIsActive(true);

        // save user and phones
        User savedUser = userRepository.save(user);
        if (user.getPhones() !=null) {
            user.getPhones().forEach(phone -> phone.setUser(savedUser));
        }

        return savedUser;
    }

}
