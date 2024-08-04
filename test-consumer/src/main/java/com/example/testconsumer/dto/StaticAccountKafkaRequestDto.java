package com.example.testconsumer.dto;


public class StaticAccountKafkaRequestDto {
    private String accountName;
    private String merchantCode;
    private Long customerId;

    public StaticAccountKafkaRequestDto(String accountName, String merchantCode, Long customerId) {
        this.accountName = accountName;
        this.merchantCode = merchantCode;
        this.customerId = customerId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}