package com.cano.mingorance.enrique.squashrankingservice.core;

import com.cano.mingorance.enrique.squashrankingservice.persistence.entity.Match;
import com.cano.mingorance.enrique.squashrankingservice.persistence.repository.MatchRepository;
import com.cano.mingorance.enrique.squashrankingservice.rest.dto.MatchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Match manager.
 */
@Service
public class MatchManager {

    @Autowired
    private MatchRepository repository;

    /**
     * Find all list.
     *
     * @return the list
     */
    public List<Match> findAll() {
        return (List<Match>) repository.findAll();
    }

    /**
     * Find by id match.
     *
     * @param id the id
     * @return the match
     */
    public Match findById(Long id) {
        return repository.findById(id).get();
    }

    /**
     * Save match.
     *
     * @param match the match
     * @return the match
     */
    public Match save(Match match) {
        return repository.save(match);
    }
}
