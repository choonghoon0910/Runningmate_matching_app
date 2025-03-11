package com.example.runapp.controller;

import com.example.runapp.entity.Match;
import com.example.runapp.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
public class MatchController {

    @Autowired
    private MatchRepository matchRepository;

    @GetMapping
    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    @GetMapping("/{id}")
    public Match getMatchById(@PathVariable Integer id) {
        return matchRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Match createMatch(@RequestBody Match match) {
        return matchRepository.save(match);
    }

    @PutMapping("/{id}")
    public Match updateMatch(@PathVariable Integer id, @RequestBody Match updatedMatch) {
        Match match = matchRepository.findById(id).orElse(null);
        if (match != null) {
            match.setUserId1(updatedMatch.getUserId1());
            match.setUserId2(updatedMatch.getUserId2());
            match.setStatus(updatedMatch.getStatus());
            match.setCreatedAt(updatedMatch.getCreatedAt());
            match.setMatchedAt(updatedMatch.getMatchedAt());
            return matchRepository.save(match);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteMatch(@PathVariable Integer id) {
        matchRepository.deleteById(id);
    }
}
