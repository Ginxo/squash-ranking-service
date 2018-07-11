package com.cano.mingorance.enrique.squashrankingservice.rest.controller;

import com.cano.mingorance.enrique.squashrankingservice.core.PlayerManager;
import com.cano.mingorance.enrique.squashrankingservice.persistence.entity.Player;
import com.cano.mingorance.enrique.squashrankingservice.rest.dto.PlayerDTO;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Player controller.
 */
@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerManager manager;

    @Autowired
    private DozerBeanMapper mapper;

    /**
     * Find all list.
     *
     * @return the list
     */
    @GetMapping("/")
    public List<PlayerDTO> findAll() {
        return (List<PlayerDTO>) mapper.map(manager.findAll(), PlayerDTO.class);
    }

    /**
     * Find by id player dto.
     *
     * @param id the id
     * @return the player dto
     */
    @GetMapping("/{id}")
    public PlayerDTO findById(@PathVariable("id") Long id) {
        return mapper.map(manager.findById(id), PlayerDTO.class);
    }

    /**
     * Save player dto.
     *
     * @param playerDTO the player dto
     * @return the player dto
     */
    @PostMapping("/")
    public PlayerDTO save(@RequestBody PlayerDTO playerDTO) {
        return mapper.map(manager.save(mapper.map(playerDTO, Player.class)), PlayerDTO.class);
    }
}
