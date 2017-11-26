package com.ajay.designpattern.decorator;

import java.math.BigDecimal;

/**
 * Created by ajayk297 on 12/11/17.
 */
public class BrownBreadSandWich extends Sandwich {


    @Override
    public BigDecimal price() {
        System.out.println("In BrownBreadSandwich...");
        return new BigDecimal(100);
    }
}
