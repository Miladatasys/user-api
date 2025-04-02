package com.milacode.user_api.repositories;

import com.milacode.user_api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository  extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);
}
