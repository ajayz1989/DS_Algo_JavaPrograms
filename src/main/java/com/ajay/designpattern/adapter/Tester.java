package com.ajay.designpattern.adapter;

public class Tester {

    public static void main(String[] args) {

        Integer[] numbers = new Integer[]{34, 2, 4, 12, 1};
        Sorter socket = new SorterAdapter();
        printArray(numbers);
        System.out.println("---------------------------------------------");
        socket.sort(numbers);
        printArray(numbers);

        
    }

    private static <T> void printArray(T[] array){
        for (int i=0; i<array.length; i++){
            System.out.println(array[i]);
        }
    }
}
