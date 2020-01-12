package com.ted.thunderbluff.repository;

import com.ted.thunderbluff.model.ItemModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ItemModelRepository extends JpaRepository<ItemModel, Long> {
}