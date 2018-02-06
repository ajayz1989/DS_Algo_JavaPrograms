package com.ajay.designpattern.strategy;

public class PayByOnlineWalletImpl implements Payment{

    private String userName;
    private String emailId;
    private String password;

    public PayByOnlineWalletImpl(String userName, String emailId, String password) {
        this.userName = userName;
        this.emailId = emailId;
        this.password = password;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + "- Amount Paid by online wallet");
    }
}
