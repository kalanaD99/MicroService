package com.example.itemservice.repo;

import com.example.itemservice.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<ItemEntity,String> {
}
