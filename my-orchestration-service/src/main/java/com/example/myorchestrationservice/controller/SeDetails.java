package com.example.myorchestrationservice.controller;

import com.example.myorchestrationservice.dto.CompanyDTO;
import com.example.myorchestrationservice.dto.SeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("se-service")
public interface SeDetails {

    @GetMapping(value= "/se/{seId}")
    public String getSeViaSeId(@PathVariable(name= "seId") String seId);

    @GetMapping(value= "/se/")
    public String getAllSe();

    @PostMapping(value= "/se")
    public String createSe(@RequestBody SeDTO seDetails);
}