package com.stockapp.ipo.service.impl;

import com.stockapp.ipo.dao.IpoRepository;
import com.stockapp.ipo.dao.entities.IpoEntity;
import com.stockapp.ipo.dto.IpoDTO;
import com.stockapp.ipo.dto.IpoMapper;
import com.stockapp.ipo.service.IpoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IpoServiceImpl implements IpoService {
    @Autowired
    private IpoRepository ipoRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(IpoServiceImpl.class);

    @Override
    public IpoDTO getIpo(Integer compId) throws Exception {
        LOGGER.info("Fetching IPO details for CompId: {}", compId);
        Optional<IpoEntity> ipoEntity = ipoRepository.findById(compId);
        IpoDTO ipoDTO = null;

        if (ipoEntity.isPresent()) {
            ipoDTO = IpoMapper.INSTANCE.ipoEntityToDTO(ipoEntity.get());
        }

        return ipoDTO;
    }
}
