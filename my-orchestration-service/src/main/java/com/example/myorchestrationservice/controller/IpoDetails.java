package com.example.myorchestrationservice.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("ipo-service")
public interface IpoDetails {

    @GetMapping(value= "/ipos/{compId}")
    public String getCompanyFromIpo(@PathVariable(name= "compId") String compId);
}
