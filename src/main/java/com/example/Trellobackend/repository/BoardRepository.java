package com.example.Trellobackend.repository;

import com.example.Trellobackend.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Integer> {
}
