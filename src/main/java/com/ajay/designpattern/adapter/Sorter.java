package com.ajay.designpattern.adapter;

/**
 * Adapter interface required for the client to sort arrays.
 */
public interface Sorter {

    public <T> T[] sort(T[] array);
}
