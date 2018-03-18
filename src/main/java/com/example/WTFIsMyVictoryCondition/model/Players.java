package com.example.WTFIsMyVictoryCondition.model;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@Data
public class Players {
    private List<Player> players;
}
