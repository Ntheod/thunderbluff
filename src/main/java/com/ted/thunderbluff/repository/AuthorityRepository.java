package com.ted.thunderbluff.repository;

import com.ted.thunderbluff.model.Authority;
import com.ted.thunderbluff.model.AuthorityName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Authority findByName(AuthorityName name);
}
