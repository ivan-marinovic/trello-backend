package com.example.Trellobackend.repository;

import com.example.Trellobackend.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Integer> {
}
