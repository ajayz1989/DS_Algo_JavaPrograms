package com.ajay.designpattern.decorator;

/**
 * Created by ajayk297 on 13/11/17.
 */
abstract class SandWichDecorator extends Sandwich{

    protected Sandwich sandwich;

    public SandWichDecorator(Sandwich sandwich) {
        this.sandwich = sandwich;
    }
}
