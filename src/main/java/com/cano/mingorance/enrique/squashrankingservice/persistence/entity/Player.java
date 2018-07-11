package com.cano.mingorance.enrique.squashrankingservice.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name, surname, nationality;
    private Integer ranking;
    private Boolean isDeleted;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "player1")
    private Match matchPlayer1;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "player2")
    private Match matchPlayer2;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "winner")
    private Match matchWinner;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "loser")
    private Match matchLoser;

}
