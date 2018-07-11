package com.cano.mingorance.enrique.squashrankingservice.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The type Match.
 */
@Entity
@Getter
@Setter
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="player1")
    private Player player1;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="player2")
    private Player player2;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="winner")
    private Player winner;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="loser")
    private Player loser;

    private String court;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "match")
    private List<MatchSet> matchSets;

    private Date matchDate;
}
