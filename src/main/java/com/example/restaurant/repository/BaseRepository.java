package com.example.restaurant.repository;

import com.example.restaurant.entity.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepository<T extends AbstractEntity> extends JpaRepository<T, Long> {
}
