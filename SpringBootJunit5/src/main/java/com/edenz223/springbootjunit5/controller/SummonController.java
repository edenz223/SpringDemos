package com.edenz223.springbootjunit5.controller;


import com.edenz223.springbootjunit5.service.SummonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SummonController {

    private final SummonService summonService;

    public SummonController(SummonService service) {
        this.summonService = service;
    }

    @GetMapping("/summon")
    public String summon(){
        return summonService.summonDragon();
    }

}
