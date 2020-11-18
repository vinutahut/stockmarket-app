package com.stockapp.stockExchange.service;


import com.stockapp.stockExchange.dao.entities.SeEntity;
import com.stockapp.stockExchange.dto.SeDTO;

import java.util.List;

public interface SeService {

    SeDTO getSe(Integer seId) throws Exception;
    List<SeDTO> getAllSe() throws Exception;
    public SeDTO createSe(SeDTO seDto);
}
