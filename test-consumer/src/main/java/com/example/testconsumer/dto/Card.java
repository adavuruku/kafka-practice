package com.example.testconsumer.dto;

import java.util.Map;

public class Card {
    private int id;
    private int amount;
    private String status;
    private String channel;
    private String bankCode;
    private String cardType;
    private String currency;
    private String valueRef;
    private String accountNo;

    public String getCardExpiryDate() {
        return cardExpiryDate;
    }

    public String getToken() {
        return token;
    }

    private String cardToken;
    private String maskedPan;
    private String pan;
    private String narration;
    private int surcharge;
    private String customerId;
    private String paymentRef;
    private String accountType;
    private String initiatedBy;
    private String customerName;
    private String paymentMethod;
    private String transactionRef;
    private String initiatedByName; private String transactionDate; private String transactionType;
    private String customerMobileNo; private String cardTokenExpiryDate; private String destinationInstitution;
    private String Quickteller;
    private String destinationInstitutionCode;
    private String metadata;

    public void setCardExpiryDate(String cardExpiryDate) {
        this.cardExpiryDate = cardExpiryDate;
    }

    public void setToken(String token) {
        this.token = token;
    }

    private String cardExpiryDate;
    private String token;
    // Constructor 1
    public Card() {}

    public Card(int id, int amount, String status, String channel, String bankCode,
                String cardType, String currency, String valueRef, String accountNo,
                String cardToken, String maskedPan, String narration, int surcharge, String customerId,
                String paymentRef, String accountType, String initiatedBy, String customerName,
                String paymentMethod, String transactionRef, String initiatedByName, String transactionDate,
                String transactionType, String customerMobileNo, String cardTokenExpiryDate,
                String destinationInstitution, String quickteller,
                String destinationInstitutionCode, String metadata,
                String pan, String cardExpiryDate, String token) {
        this.id = id;
        this.amount = amount;
        this.status = status;
        this.channel = channel;
        this.bankCode = bankCode;
        this.cardType = cardType;
        this.currency = currency;
        this.valueRef = valueRef;
        this.accountNo = accountNo;
        this.cardToken = cardToken;
        this.maskedPan = maskedPan;
        this.narration = narration;
        this.surcharge = surcharge;
        this.customerId = customerId;
        this.paymentRef = paymentRef;
        this.accountType = accountType;
        this.initiatedBy = initiatedBy;
        this.customerName = customerName;
        this.paymentMethod = paymentMethod;
        this.transactionRef = transactionRef;
        this.initiatedByName = initiatedByName;
        this.transactionDate = transactionDate;
        this.transactionType = transactionType;
        this.customerMobileNo = customerMobileNo;
        this.cardTokenExpiryDate = cardTokenExpiryDate;
        this.destinationInstitution = destinationInstitution;
        Quickteller = quickteller;
        this.destinationInstitutionCode = destinationInstitutionCode;
        this.metadata = metadata;
        this.pan = pan;
        this.cardExpiryDate=cardExpiryDate;
        this.token=token;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getValueRef() {
        return valueRef;
    }

    public void setValueRef(String valueRef) {
        this.valueRef = valueRef;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getCardToken() {
        return cardToken;
    }

    public void setCardToken(String cardToken) {
        this.cardToken = cardToken;
    }

    public String getMaskedPan() {
        return maskedPan;
    }

    public void setMaskedPan(String maskedPan) {
        this.maskedPan = maskedPan;
    }

    public String getNarration() {
        return narration;
    }

    public void setNarration(String narration) {
        this.narration = narration;
    }

    public int getSurcharge() {
        return surcharge;
    }

    public void setSurcharge(int surcharge) {
        this.surcharge = surcharge;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getPaymentRef() {
        return paymentRef;
    }

    public void setPaymentRef(String paymentRef) {
        this.paymentRef = paymentRef;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getInitiatedBy() {
        return initiatedBy;
    }

    public void setInitiatedBy(String initiatedBy) {
        this.initiatedBy = initiatedBy;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getTransactionRef() {
        return transactionRef;
    }

    public void setTransactionRef(String transactionRef) {
        this.transactionRef = transactionRef;
    }

    public String getInitiatedByName() {
        return initiatedByName;
    }

    public void setInitiatedByName(String initiatedByName) {
        this.initiatedByName = initiatedByName;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getCustomerMobileNo() {
        return customerMobileNo;
    }

    public void setCustomerMobileNo(String customerMobileNo) {
        this.customerMobileNo = customerMobileNo;
    }

    public String getCardTokenExpiryDate() {
        return cardTokenExpiryDate;
    }

    public void setCardTokenExpiryDate(String cardTokenExpiryDate) {
        this.cardTokenExpiryDate = cardTokenExpiryDate;
    }

    public String getDestinationInstitution() {
        return destinationInstitution;
    }

    public void setDestinationInstitution(String destinationInstitution) {
        this.destinationInstitution = destinationInstitution;
    }

    public String getQuickteller() {
        return Quickteller;
    }

    public void setQuickteller(String quickteller) {
        Quickteller = quickteller;
    }

    public String getDestinationInstitutionCode() {
        return destinationInstitutionCode;
    }

    public void setDestinationInstitutionCode(String destinationInstitutionCode) {
        this.destinationInstitutionCode = destinationInstitutionCode;
    }
}