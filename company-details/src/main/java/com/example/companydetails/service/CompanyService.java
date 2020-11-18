package com.example.companydetails.service;


import com.example.companydetails.dto.CompanyDTO;

import java.util.List;

public interface CompanyService {

    CompanyDTO getCompany(Integer compId) throws Exception;
    List<CompanyDTO> getCompanyFromPattern(String compName) throws Exception;
    List<CompanyDTO> getCompanyFromSector(String sector) throws Exception;
    List<CompanyDTO> getCompanyFromStockExchange(String sector) throws Exception;
    public CompanyDTO createCompany(CompanyDTO compDto);
}
