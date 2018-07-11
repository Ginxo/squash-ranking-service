package com.cano.mingorance.enrique.squashrankingservice.persistence.repository;

import com.cano.mingorance.enrique.squashrankingservice.persistence.entity.Match;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

/**
 * The interface Match repository.
 */
public interface MatchRepository extends CrudRepository<Match, Long> {

    /**
     * Find by match date between list.
     *
     * @param date1 the date 1
     * @param date2 the date 2
     * @return the list
     */
    List<Match> findByMatchDateBetween(Date date1, Date date2);
}
