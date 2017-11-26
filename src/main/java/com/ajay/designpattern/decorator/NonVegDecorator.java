package com.ajay.designpattern.decorator;

import java.math.BigDecimal;

/**
 * Created by ajayk297 on 17/11/17.
 */
public class NonVegDecorator extends SandWichDecorator {

    public NonVegDecorator(Sandwich sandwich) {
        super(sandwich);
    }

    private BigDecimal nonVegPrice() {
        System.out.println("In non-veg decorator....");
        return new BigDecimal(50);
    }

    @Override
    BigDecimal price() {
        return sandwich.price().add(nonVegPrice());
    }
}
