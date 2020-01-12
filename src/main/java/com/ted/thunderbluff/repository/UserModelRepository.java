package com.ted.thunderbluff.repository;

import com.ted.thunderbluff.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserModelRepository extends JpaRepository<UserModel, Long> {
    UserModel findByUsername(String username);
    UserModel findByEmail(String email);
}
