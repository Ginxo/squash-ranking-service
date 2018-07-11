package com.cano.mingorance.enrique.squashrankingservice.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class MatchSet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer player1Points, player2Points;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "match")
    private Match match;
}
