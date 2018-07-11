package com.cano.mingorance.enrique.squashrankingservice.rest.controller;

import com.cano.mingorance.enrique.squashrankingservice.core.MatchManager;
import com.cano.mingorance.enrique.squashrankingservice.persistence.entity.Match;
import com.cano.mingorance.enrique.squashrankingservice.rest.controller.validator.MatchControllerHelper;
import com.cano.mingorance.enrique.squashrankingservice.rest.dto.MatchDTO;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Player controller.
 */
@RestController
@RequestMapping("/player")
public class MatchController {

    @Autowired
    private MatchManager manager;

    @Autowired
    private DozerBeanMapper mapper;

    @Autowired
    private MatchControllerHelper helper;

    /**
     * Find all list.
     *
     * @return the list
     */
    @GetMapping("/")
    public List<MatchDTO> findAll() {
        return (List<MatchDTO>) mapper.map(manager.findAll(), MatchDTO.class);
    }

    /**
     * Find by id player dto.
     *
     * @param id the id
     * @return the player dto
     */
    @GetMapping("/{id}")
    public MatchDTO findById(@PathVariable("id") Long id) {
        return mapper.map(manager.findById(id), MatchDTO.class);
    }

    /**
     * Save player dto.
     *
     * @param dto the player dto
     * @return the player dto
     */
    @PostMapping("/")
    public MatchDTO save(@RequestBody MatchDTO dto) {
        if (!this.helper.isValid(dto)) {
            throw new IllegalArgumentException("The dto is not valid");
        }
        return mapper.map(manager.save(mapper.map(dto, Match.class)), MatchDTO.class);
    }
}
