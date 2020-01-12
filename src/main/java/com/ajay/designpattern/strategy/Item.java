package com.ajay.designpattern.strategy;

public class Item{

    private String itemName;
    private int cost;

    public Item(String itemName, int cost) {
        this.itemName = itemName;
        this.cost = cost;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
