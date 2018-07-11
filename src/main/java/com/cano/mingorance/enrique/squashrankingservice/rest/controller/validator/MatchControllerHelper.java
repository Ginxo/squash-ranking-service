package com.cano.mingorance.enrique.squashrankingservice.rest.controller.validator;

import com.cano.mingorance.enrique.squashrankingservice.rest.dto.MatchDTO;
import org.springframework.stereotype.Service;

/**
 * The type Match controller helper.
 */
@Service
public class MatchControllerHelper {

    /**
     * Is valid boolean.
     *
     * @param match the match
     * @return the boolean
     */
    public Boolean isValid(MatchDTO match) {
        return true;
    }
}
