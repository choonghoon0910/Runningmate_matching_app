package com.example.runapp.repository;

import com.example.runapp.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Integer> {
}
