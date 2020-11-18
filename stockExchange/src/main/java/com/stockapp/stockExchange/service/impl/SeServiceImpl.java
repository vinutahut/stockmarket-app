package com.stockapp.stockExchange.service.impl;

import com.stockapp.stockExchange.dao.SeRepository;
import com.stockapp.stockExchange.dao.entities.SeEntity;
import com.stockapp.stockExchange.dto.SeDTO;
import com.stockapp.stockExchange.dto.SeMapper;
import com.stockapp.stockExchange.service.SeService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SeServiceImpl implements SeService {
    @Autowired
    private SeRepository seRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(SeServiceImpl.class);

    @Override
    public SeDTO getSe(Integer seId) throws Exception {
        LOGGER.info("Fetching SE details for SeId: {}", seId);
        Optional<SeEntity> seEntity = seRepository.findById(seId);
        SeDTO seDTO = null;

        if (seEntity.isPresent()) {
            seDTO = SeMapper.INSTANCE.seEntityToDTO(seEntity.get());
        }
        return seDTO;
    }

    @Override
    public List<SeDTO> getAllSe() throws Exception {
        LOGGER.info("Fetching ALL SE details...");
        Iterable<SeEntity> seEntity = seRepository.findAll();
        SeDTO seDTO = null;
        List<SeDTO> listSeDTO = new ArrayList<>();

        for( SeEntity element : seEntity ){
            listSeDTO.add(SeMapper.INSTANCE.seEntityToDTO(element));
        }
        return listSeDTO;
    }

    @Override
    @Transactional
    public SeDTO createSe(SeDTO seDTO) {
//        seDTO.setUserId(UUID.randomUUID().toString());
        ModelMapper mapper=new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        SeEntity seEntity=mapper.map(seDTO, SeEntity.class);
        seRepository.save(seEntity);
        return mapper.map(seEntity,SeDTO.class);
    }
}