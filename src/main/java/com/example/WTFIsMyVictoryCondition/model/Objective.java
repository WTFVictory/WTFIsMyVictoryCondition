package com.example.WTFIsMyVictoryCondition.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

import javax.xml.bind.annotation.*;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Objective")
public class Objective {


    @JacksonXmlProperty(localName = "title", isAttribute = true)
    private String title;
    @JacksonXmlProperty(localName = "description", isAttribute = true)
    private String description;

    public Objective() {
    }
    public Objective(String title, String description) {
        this.title = title;
        this.description = description;
    }

    @Override
    public String toString()
    {
        return  title + " - " + description + ".";
    }


}