package com.example.WTFIsMyVictoryCondition.controller;


import com.example.WTFIsMyVictoryCondition.VictoryProcessor;
import com.example.WTFIsMyVictoryCondition.model.Players;
import com.example.WTFIsMyVictoryCondition.model.PlayersRequest;
import com.example.WTFIsMyVictoryCondition.model.VictoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class VictoryController {
    @Autowired
    private VictoryProcessor victoryProcessor;

    @RequestMapping(path = "/getObjectives", method = RequestMethod.POST, produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE, headers = {
            "content-type=application/json" },
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String getObjectives(@RequestBody PlayersRequest victoryRequest) throws Exception {
        //PlayersRequest players = victoryRequest.getPlayers();
        //PlayersRequest players = victoryRequest.getPlayers();
        //victoryProcessor.processWeb(players);
        victoryProcessor.processWeb(victoryRequest);
        return "Check email(s) for your objectives!";
    }
    @RequestMapping(path = "/test")
    public String index() {
        return "Greetings from WTFIsMyVictoryCondition!";
    }
}
