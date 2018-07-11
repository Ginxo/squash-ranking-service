package com.cano.mingorance.enrique.squashrankingservice.core;

import com.cano.mingorance.enrique.squashrankingservice.persistence.entity.Match;
import com.cano.mingorance.enrique.squashrankingservice.persistence.entity.Player;
import com.cano.mingorance.enrique.squashrankingservice.persistence.repository.MatchRepository;
import com.cano.mingorance.enrique.squashrankingservice.persistence.repository.PlayerRepository;
import com.cano.mingorance.enrique.squashrankingservice.rest.dto.MatchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * The type Match manager.
 */
@Service
public class MatchManager {

    @Autowired
    private MatchRepository repository;

    @Autowired
    private PlayerRepository playerRepository;

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
        final Match savedMatch = repository.save(match);
        savedMatch.setWinner(this.getWinner(savedMatch));
        savedMatch.setLoser(this.getLoser(savedMatch));

        final Player winner = savedMatch.getWinner();
        final Player loser = savedMatch.getLoser();
        winner.setRanking(winner.getRanking() + this.getNewRankingWinner(winner, loser));
        loser.setRanking(loser.getRanking() + this.getNewRankingLoser(loser, winner));

        this.playerRepository.saveAll(Arrays.asList(winner, loser));
        return savedMatch;
    }

    private Integer getNewRankingWinner(Player winner, Player loser) {
        //TODO
        playerRepository.count();
        return 1;
    }


    private Integer getNewRankingLoser(Player loser, Player winner) {
        //TODO
        return 1;
    }

    private Player getWinner(Match match) {
        //TODO
        return null;
    }

    private Player getLoser(Match match) {
        //TODO
        return null;
    }

}
