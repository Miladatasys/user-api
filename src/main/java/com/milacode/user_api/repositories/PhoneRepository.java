package com.milacode.user_api.repositories;

import com.milacode.user_api.models.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
}
