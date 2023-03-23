package com.example.Trellobackend.repository;

import com.example.Trellobackend.model.Board;
import com.example.Trellobackend.model.TList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ListRepository extends JpaRepository<TList, Integer> {
    List<TList> findAllByBoard(Board board);
}