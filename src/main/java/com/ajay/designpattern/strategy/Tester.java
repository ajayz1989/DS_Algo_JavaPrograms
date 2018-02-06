package com.ajay.designpattern.strategy;

public class Tester {
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();


        shoppingCart.addItem(new Item("Umbrella", 42));
        shoppingCart.addItem(new Item("Bottle", 92));

        shoppingCart.pay(new PayByOnlineWalletImpl("ajay", "ajay@gmail.com", "1234"));
        shoppingCart.pay(new PayByCreditCardImpl("ajay", "4356755", "1234", "12/2018"));

    }

}
