package com.ajay.designpattern.decorator;

/**
 * Created by ajayk297 on 15/11/17.
 */
public class TestDecorator {

    public static void main(String[] args) {
        Sandwich sandwich = new BrownBreadSandWich();
        System.out.println(sandwich.price());

        Sandwich cheeseSandwich = new CheeseDecorator(new BrownBreadSandWich());
        System.out.println(cheeseSandwich.price());

        Sandwich nonVegCheeseSandwich = new NonVegDecorator(new CheeseDecorator(new BrownBreadSandWich()));
        System.out.println(nonVegCheeseSandwich.price());

        Sandwich multiGrainSandWich = new NonVegDecorator(new CheeseDecorator(new CheeseDecorator(new MultiGrainSandWich())));
        System.out.println(multiGrainSandWich.price());
    }



}
