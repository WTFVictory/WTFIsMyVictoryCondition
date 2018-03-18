package com.example.WTFIsMyVictoryCondition.model;

import lombok.Data;
import java.io.Serializable;

@Data
public class VictoryRequest implements Serializable{
    private PlayersRequest players;

}
