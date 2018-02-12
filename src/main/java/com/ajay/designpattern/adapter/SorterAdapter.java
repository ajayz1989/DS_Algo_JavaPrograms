package com.ajay.designpattern.adapter;

import java.util.Arrays;
import java.util.List;

/**
 * Adapter implementation class to use the 3rd party ListSorter and provide the required functionality to
 * the client to sort arrays.
 */
public class SorterAdapter implements  Sorter {

    private ListSorter listSorter = new ListSorter();

    @Override
    public <T> T[] sort(T[] array) {
        List<T> sortedList = listSorter.getSortedList(Arrays.asList(array));
        return (T[]) sortedList.toArray();
    }

}
