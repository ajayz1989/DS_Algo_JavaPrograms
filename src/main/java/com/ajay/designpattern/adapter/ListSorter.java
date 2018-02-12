package com.ajay.designpattern.adapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A third party class that sorts a list.
 */
public class ListSorter<T> {

    private List<T> list;

    public ListSorter() {
        this.list = new ArrayList<>();
    }

    public List<T> getSortedList(List list){
        Collections.sort(list);
        return list;
    }
}
