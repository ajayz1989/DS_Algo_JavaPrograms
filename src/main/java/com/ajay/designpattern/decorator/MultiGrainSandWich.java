package com.ajay.designpattern.decorator;

import java.math.BigDecimal;

/**
 * Created by ajayk297 on 26/11/17.
 */
public class MultiGrainSandWich extends Sandwich {

    @Override
    BigDecimal price() {
        System.out.println("In MultiGrainSandWich...");
        return new BigDecimal(150);
    }
}
