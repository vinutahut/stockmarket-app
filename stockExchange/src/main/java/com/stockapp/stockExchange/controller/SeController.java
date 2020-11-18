package com.stockapp.stockExchange.controller;

import com.stockapp.stockExchange.dao.entities.SeEntity;
import com.stockapp.stockExchange.dto.SeDTO;
import com.stockapp.stockExchange.service.SeService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SeController {

    @Autowired
    private SeService seService;

    @Autowired
    public SeController(SeService seService) {
        this.seService = seService;
    }


    @RequestMapping(value = "/se/{seId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public SeDTO getSe(@PathVariable Integer seId) throws Exception {
        return seService.getSe(seId);
    }

    @RequestMapping(value = "/se/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SeDTO> getAllSe() throws Exception {
        return seService.getAllSe();
    }

    @PostMapping("/se")
    public ResponseEntity<SeDTO> createSe(@RequestBody SeDTO seDetails)
    {
        ModelMapper mapper=new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        SeDTO seDTO=mapper.map(seDetails,SeDTO.class);
        seService.createSe(seDTO);
        SeDTO userResponseModelEntity=mapper.map(seDTO,SeDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(seDTO);
    }
}