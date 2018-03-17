package com.example.WTFIsMyVictoryCondition.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VictoryController {
    @RequestMapping("/getObjectives")
    public String index() {
        return "Greetings from WTFIsMyVictoryCondition!";
    }
}
