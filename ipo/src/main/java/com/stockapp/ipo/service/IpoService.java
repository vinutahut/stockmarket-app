package com.stockapp.ipo.service;


import com.stockapp.ipo.dto.IpoDTO;

public interface IpoService {

    IpoDTO getIpo(Integer compId) throws Exception;
}
