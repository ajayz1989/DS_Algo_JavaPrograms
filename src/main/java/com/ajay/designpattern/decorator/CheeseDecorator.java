package com.ajay.designpattern.decorator;

import java.math.BigDecimal;

/**
 * Created by ajayk297 on 13/11/17.
 */
public class CheeseDecorator extends SandWichDecorator {


    public CheeseDecorator(Sandwich sandwich) {
        super(sandwich);
    }

    private BigDecimal cheesePrice() {
        System.out.println("In cheese decorator....");
        return new BigDecimal(20);
    }


    @Override
    BigDecimal price() {
        return sandwich.price().add(cheesePrice());
    }
}
