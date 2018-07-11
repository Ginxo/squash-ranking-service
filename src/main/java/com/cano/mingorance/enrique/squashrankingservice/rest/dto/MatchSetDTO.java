package com.cano.mingorance.enrique.squashrankingservice.rest.dto;

import com.cano.mingorance.enrique.squashrankingservice.persistence.entity.Match;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * The type Match set dto.
 */
@Getter
@Setter
public class MatchSetDTO {

    private Long id;

    private Integer player1Points, player2Points;
}
