package com.example.myorchestrationservice.controller;

import com.example.myorchestrationservice.dto.CompanyDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("company-details")
public interface CompanyDetails {
    @GetMapping(value= "/companies/{compId}")
    public String getCompany(@PathVariable(name= "compId") String compId);

    @GetMapping(value= "/companies/matching/{compName}")
    public String getCompanyFromPattern(@PathVariable(name= "compName") String compName);

    @GetMapping(value= "/companies/sector/{sector}")
    public String getCompanyFromSector(@PathVariable(name= "sector") String sector);

    @GetMapping(value= "/companies/se/{se}")
    public String getCompanyFromStockExchange(@PathVariable(name= "se") String se);

    @PostMapping(value= "/companies/add")
    public String addCompany(@RequestBody CompanyDTO compDetails);
}