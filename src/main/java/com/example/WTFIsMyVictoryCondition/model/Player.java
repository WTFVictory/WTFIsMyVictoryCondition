package com.example.WTFIsMyVictoryCondition.model;

import lombok.Data;

@Data
public class Player {

    private String playerName;
    private Objective majorObjective;
    private Objective minorObjectiveOne;
    private Objective minorObjectiveTwo;
    private String emailAddress;


    public Player(String playerName,Objective majorObjective, Objective minorObjectiveOne, Objective minorObjectiveTwo, String emailAddress) {
        this.playerName = playerName;
        this.majorObjective = majorObjective;
        this.minorObjectiveOne = minorObjectiveOne;
        this.minorObjectiveTwo = minorObjectiveTwo;
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Player Name: " + playerName + "\n");
        builder.append("Major Objective: \n" + majorObjective.toString() + "\n");
        builder.append("Minor Objective: \n" + minorObjectiveOne.toString() + "\n");
        builder.append("Minor Objective: \n" + minorObjectiveTwo.toString() + "\n");
        return builder.toString();
    }
}
