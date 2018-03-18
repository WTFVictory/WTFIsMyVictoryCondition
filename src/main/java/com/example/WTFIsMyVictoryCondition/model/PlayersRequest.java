package com.example.WTFIsMyVictoryCondition.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class PlayersRequest {
    @JsonInclude
    private List<PlayerRequest> players;
    public PlayersRequest()
    {

    }
}
