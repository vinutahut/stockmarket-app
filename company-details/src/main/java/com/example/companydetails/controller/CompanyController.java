package com.example.companydetails.controller;

import com.example.companydetails.dto.CompanyDTO;
import com.example.companydetails.service.CompanyService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {

    @Autowired
    private CompanyService companyService;


    @RequestMapping(value = "/companies/{compId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public CompanyDTO getCompany(@PathVariable Integer compId) throws Exception {
        return companyService.getCompany(compId);
    }

    @RequestMapping(value = "/companies/matching/{compName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CompanyDTO> getCompanyFromPattern(@PathVariable String compName) throws Exception {
        return companyService.getCompanyFromPattern(compName);
    }

    @RequestMapping(value = "/companies/sector/{sector}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CompanyDTO> getCompanyFromSector(@PathVariable String sector) throws Exception {
        return companyService.getCompanyFromSector(sector);
    }

    @RequestMapping(value = "/companies/se/{se}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CompanyDTO> getCompanyFromStockExchange(@PathVariable String se) throws Exception {
        return companyService.getCompanyFromStockExchange(se);
    }

    @PostMapping("/companies/add")
    public ResponseEntity<CompanyDTO> createCompany(@RequestBody CompanyDTO compDetails)
    {
        ModelMapper mapper=new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        CompanyDTO companyDTO=mapper.map(compDetails,CompanyDTO.class);
        companyService.createCompany(companyDTO);
        CompanyDTO userResponseModelEntity=mapper.map(companyDTO,CompanyDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(companyDTO);
    }
}
