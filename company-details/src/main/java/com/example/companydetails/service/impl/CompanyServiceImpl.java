package com.example.companydetails.service.impl;

import com.example.companydetails.dao.CompanyRepository;
import com.example.companydetails.dao.entities.CompanyEntity;
import com.example.companydetails.dto.CompanyDTO;
import com.example.companydetails.dto.CompanyMapper;
import com.example.companydetails.service.CompanyService;
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

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyServiceImpl.class);

    @Override
    public CompanyDTO getCompany(Integer compId) throws Exception {
        LOGGER.info("Fetching Company details for CompanyId: {}", compId);
        Optional<CompanyEntity> companyEntity = companyRepository.findById(compId);
        CompanyDTO companyDTO = null;

        if (companyEntity.isPresent()) {
            companyDTO = CompanyMapper.INSTANCE.companyEntityToDTO(companyEntity.get());
        }

        return companyDTO;
    }

    @Override
    public List<CompanyDTO> getCompanyFromPattern(String compName) throws Exception {
        LOGGER.info("Fetching Company details for CompanyPattern: {}", compName);
        List<CompanyEntity> listCompanyEntity = companyRepository.findByCompNameContaining(compName);
        List<CompanyDTO> listCompanyDTO = new ArrayList<>();

        for (int i=0;i<listCompanyEntity.size();i++) {
            listCompanyDTO.add(CompanyMapper.INSTANCE.companyEntityToDTO(listCompanyEntity.get(i)));
        }

        return listCompanyDTO;
    }

    @Override
    public List<CompanyDTO> getCompanyFromSector(String sector) throws Exception {
        LOGGER.info("Fetching Company details for sector: {}", sector);
        List<CompanyEntity> listCompanyEntity = companyRepository.findBySectorContaining(sector);
        List<CompanyDTO> listCompanyDTO = new ArrayList<>();

        for (int i=0;i<listCompanyEntity.size();i++) {
            listCompanyDTO.add(CompanyMapper.INSTANCE.companyEntityToDTO(listCompanyEntity.get(i)));
        }

        return listCompanyDTO;
    }

    @Override
    public List<CompanyDTO> getCompanyFromStockExchange(String se) throws Exception {
        LOGGER.info("Fetching Company details for Stock Exchange: {}", se);
        List<CompanyEntity> listCompanyEntity = companyRepository.findByStockExchangeContaining(se);
        List<CompanyDTO> listCompanyDTO = new ArrayList<>();

        for (int i=0;i<listCompanyEntity.size();i++) {
            listCompanyDTO.add(CompanyMapper.INSTANCE.companyEntityToDTO(listCompanyEntity.get(i)));
        }

        return listCompanyDTO;
    }

    @Override
    @Transactional
    public CompanyDTO createCompany(CompanyDTO compDTO) {
//        seDTO.setUserId(UUID.randomUUID().toString());
        ModelMapper mapper=new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        CompanyEntity companyEntity=mapper.map(compDTO, CompanyEntity.class);
        companyRepository.save(companyEntity);
        return mapper.map(companyEntity,CompanyDTO.class);
    }
}
