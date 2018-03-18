package com.example.WTFIsMyVictoryCondition.model;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Data
public class Player implements Serializable {

    private String playerName;
    private Objective majorObjective;
    private Objective minorObjectiveOne;
    private Objective minorObjectiveTwo;
    private String emailAddress;
    private String nemesis;


    public Player(String playerName,Objective majorObjective, Objective minorObjectiveOne, Objective minorObjectiveTwo, String emailAddress, String nemesis) {
        this.playerName = playerName;
        this.majorObjective = majorObjective;
        this.minorObjectiveOne = minorObjectiveOne;
        this.minorObjectiveTwo = minorObjectiveTwo;
        this.emailAddress = emailAddress;
        this.nemesis = nemesis;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Player Name: " + playerName + "\n");
        builder.append("Major Objective: \n" + majorObjective.toString() + "\n");
        builder.append("Minor Objective: \n" + minorObjectiveOne.toString() + "\n");
        builder.append("Minor Objective: \n" + minorObjectiveTwo.toString() + "\n");
        builder.append("Your nemesis is : \n" + nemesis + "\n");
        return builder.toString();
    }
}
