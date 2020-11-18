package com.stockapp.ipo.controller;

import com.stockapp.ipo.dto.IpoDTO;
import com.stockapp.ipo.service.IpoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IpoController {

    @Autowired
    private IpoService ipoService;


    @RequestMapping(value = "/ipos/{compId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public IpoDTO getIpo(@PathVariable Integer compId) throws Exception {
        return ipoService.getIpo(compId);
    }
}
