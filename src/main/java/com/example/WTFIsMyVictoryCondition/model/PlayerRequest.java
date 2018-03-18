package com.example.WTFIsMyVictoryCondition.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@Data

public class PlayerRequest {
    @JsonInclude
    private String playerName;
    @JsonInclude
    private String emailAddress;

    public PlayerRequest(String playerName, String emailAddress) {
        this.playerName = playerName;
        this.emailAddress = emailAddress;
    }

    public PlayerRequest()
    {

    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
