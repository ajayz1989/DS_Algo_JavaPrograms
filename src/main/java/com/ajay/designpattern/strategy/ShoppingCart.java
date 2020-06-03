package com.ajay.designpattern.strategy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Item> itemList;

    public ShoppingCart() {
        this.itemList = new ArrayList();
    }

    public void addItem(Item item){
        this.itemList.add(item);
    }

    public void removeItem(Item item){
        this.itemList.remove(item);
    }

    private int calculateTotalAmount(){
        int sum = 0;
        for (Item item : itemList) {
            sum += item.getCost();
        }
        return sum;
    }

    public void pay(Payment paymentStrategy){
        int totalAmount = calculateTotalAmount();
        paymentStrategy.pay(totalAmount);
    }
}
