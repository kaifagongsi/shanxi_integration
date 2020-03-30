package com.kfgs.firstweb.controller;


import com.kfgs.firstweb.service.CountryProShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/countrydbcpzs")
public class CountryProShowController {

    @Autowired
    CountryProShowService countryProShowService;

    @PostMapping("/search")
    public Map<String, Object> search(){
        return countryProShowService.search();
    }
}
