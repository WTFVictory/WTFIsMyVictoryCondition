package com.example.WTFIsMyVictoryCondition.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import java.util.List;
import javax.xml.bind.annotation.*;

@Data
@XmlAccessorType(XmlAccessType.FIELD)

@JacksonXmlRootElement(localName = "objectives") public final class Objectives {
    @JacksonXmlElementWrapper(localName = "objective", useWrapping = false)
    private List<Objective> objective;

    public Objectives() {
    }
    public Objectives(List<Objective> objective) {
        this.objective = objective;
    }
    public List<Objective> getObjective() {
        return objective;
    }
    public void setObjective(List<Objective> objective) {
        this.objective = objective;
    }

}