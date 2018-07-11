package com.cano.mingorance.enrique.squashrankingservice.rest.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * The type Match dto.
 */
@Getter
@Setter
public class MatchDTO {

    private Long id;

    private PlayerDTO player1;
    private PlayerDTO player2;
    private PlayerDTO winner;
    private PlayerDTO loser;
    private String court;
    private List<MatchSetDTO> matchSets;
    private Date matchDate;
}
