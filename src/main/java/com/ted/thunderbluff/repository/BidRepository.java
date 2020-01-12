package com.ted.thunderbluff.repository;

import com.ted.thunderbluff.model.Bid;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BidRepository extends JpaRepository<Bid, Long> {
}