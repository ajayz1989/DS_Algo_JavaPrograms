package com.ajay.designpattern.strategy;

import java.util.Date;

public class PayByCreditCardImpl implements Payment{

    private String cardHolderName;
    private String creditCardNo;
    private String cvvNo;
    private String expiryDate;

    public PayByCreditCardImpl(String cardHolderName, String creditCardNo, String cvvNo, String expiryDate) {
        this.cardHolderName = cardHolderName;
        this.creditCardNo = creditCardNo;
        this.cvvNo = cvvNo;
        this.expiryDate = expiryDate;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + "- Amount Paid by credit card");
    }
}
