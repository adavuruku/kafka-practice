package com.example.testconsumer.dto;


public class metadata {
    public boolean isSaveCard() {
        return saveCard;
    }

    public metadata(boolean saveCard, String config) {
        this.saveCard = saveCard;
        this.config = config;
    }
    public metadata() {
    }

    public void setSaveCard(boolean saveCard) {
        this.saveCard = saveCard;
    }

    boolean saveCard;
    String config;

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }
}
