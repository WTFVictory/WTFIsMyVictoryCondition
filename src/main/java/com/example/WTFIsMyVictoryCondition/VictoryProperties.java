package com.example.WTFIsMyVictoryCondition;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("victory")
public class VictoryProperties {

    private String mailAddress;

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }
}
