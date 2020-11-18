package com.example.myorchestrationservice.controller;

import com.example.myorchestrationservice.dto.CompanyDTO;
import com.example.myorchestrationservice.dto.SeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping(value= "/feign")
@CrossOrigin(origins = "http://localhost:4200")
public class Feignclientcontroller {
    private CompanyDetails companyDetails;
    private SeDetails seDetails;
    private IpoDetails ipoDetails;

    public Feignclientcontroller(CompanyDetails companyDetails, SeDetails seDetails, IpoDetails ipoDetails) {
        this.companyDetails = companyDetails;
        this.seDetails = seDetails;
        this.ipoDetails = ipoDetails;
    }

    @GetMapping("/{compId}")
    @HystrixCommand(fallbackMethod= "defaultResponse")
    public ResponseEntity<String> getCompanyDetailsViaFeign(@PathVariable(name= "compId") String compId) {
        String company= companyDetails.getCompany(compId);

        System.out.println(company);
        return new ResponseEntity<>(company, HttpStatus.OK);
    }

    @GetMapping("/matching/{compName}")
    @HystrixCommand(fallbackMethod= "defaultResponse")
    public ResponseEntity<String> getCompanyDetailsFromPatternViaFeign(@PathVariable(name= "compName") String compName) {
        String company= companyDetails.getCompanyFromPattern(compName);

        System.out.println(company);
        return new ResponseEntity<>(company, HttpStatus.OK);
    }

    @GetMapping("/ipos/{compName}")
    @HystrixCommand(fallbackMethod= "defaultResponse")
    public ResponseEntity<String> getCompanyDetailsFromIpoViaFeign(@PathVariable(name= "compName") String compName) {
        String company= ipoDetails.getCompanyFromIpo(compName);

        System.out.println(company);
        return new ResponseEntity<>(company, HttpStatus.OK);
    }

    @GetMapping("/sector/{compName}")
    @HystrixCommand(fallbackMethod= "defaultResponse")
    public ResponseEntity<String> getCompanyDetailsFromSectorViaFeign(@PathVariable(name= "sector") String sector) {
        String company= companyDetails.getCompanyFromSector(sector);

        System.out.println(company);
        return new ResponseEntity<>(company, HttpStatus.OK);
    }

    @GetMapping("/se/{se}")
    @HystrixCommand(fallbackMethod= "defaultResponse")
    public ResponseEntity<String> getCompanyFromStockExchange(@PathVariable(name= "se") String se) {
        String company= companyDetails.getCompanyFromStockExchange(se);

        System.out.println(company);
        return new ResponseEntity<>(company, HttpStatus.OK);
    }

    @GetMapping("/se-service/{seId}")
    @HystrixCommand(fallbackMethod= "defaultResponse")
    public ResponseEntity<String> getSeViaSeId(@PathVariable(name= "seId") String seId) {
        String company= seDetails.getSeViaSeId(seId);

        System.out.println(company);
        return new ResponseEntity<>(company, HttpStatus.OK);
    }

    @GetMapping("/se-service")
    @HystrixCommand(fallbackMethod= "defaultResponse")
    public ResponseEntity<String> getAllSe() {
        String company= seDetails.getAllSe();

        System.out.println(company);
        return new ResponseEntity<>(company, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> createCompanyViaFeign(@RequestBody CompanyDTO compDetails)
    {
        String company= companyDetails.addCompany(compDetails);

        System.out.println(companyDetails);
        return new ResponseEntity<>(company, HttpStatus.OK);
    }

    @PostMapping("/se-service/")
    public ResponseEntity<String> createSeViaFeign(@RequestBody SeDTO seDetail)
    {
        String se= seDetails.createSe(seDetail);

        System.out.println(se);
        return new ResponseEntity<>(se, HttpStatus.OK);
    }

    // When we define a fallback-method, the fallback-method must match the same parameters of the method where you define the Hystrix Command using the hystrix-command annotation.
    public ResponseEntity<String> defaultResponse(String err) {
        System.out.println("You are seeing this fallback response because the underlying microservice is down.");
        err = "Fallback error as the microservice is down.";
        return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // When we define a fallback-method, the fallback-method must match the same parameters of the method where you define the Hystrix Command using the hystrix-command annotation.
    public ResponseEntity<String> defaultResponse() {
        System.out.println("You are seeing this fallback response because the underlying microservice is down.");
        String err = "Fallback error as the microservice is down.";
        return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}