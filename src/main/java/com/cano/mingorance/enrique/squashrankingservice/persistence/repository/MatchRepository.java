package com.cano.mingorance.enrique.squashrankingservice.persistence.repository;

import com.cano.mingorance.enrique.squashrankingservice.persistence.entity.Match;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface MatchRepository extends CrudRepository<Match, Long> {

    List<Match> findByMatchDateBetween(Date date1, Date date2);
}
