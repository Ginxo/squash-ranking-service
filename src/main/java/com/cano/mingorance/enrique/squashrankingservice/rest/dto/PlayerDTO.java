package com.cano.mingorance.enrique.squashrankingservice.rest.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * The type Player dto.
 */
@Getter
@Setter
public class PlayerDTO {

    private Long id;
    private String name, surname, nationality;
    private Integer ranking;
    private Boolean isDeleted;
}
