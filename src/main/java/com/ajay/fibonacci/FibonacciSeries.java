package com.ajay.fibonacci;

/**
 * Created by ajayk297 on 08/10/17.
 */
public class FibonacciSeries {
    // 0 1 1 2 3 5 8 13 .......

    //simple logic for finding fibonacci series
    private static void fibonacciSimple(int count){
        int n1 = 0, n2 = 1;
        System.out.print(n1 + " " + n2 + " ");
        for (int i = 2; i < count; i++) {

            int n3 = n1 + n2;
            System.out.print(n3 + " ");
            n1 = n2;
            n2 = n3;
        }
    }

    //recursively find fibonacci series
    private static void fibonacciRecursion(int count){
        int n1 = 0, n2 = 1;
        System.out.print(n1 + " " + n2 + " ");
        callRecursively(count - 2, n1, n2);

    }

    private static void callRecursively(int count, int n1, int n2) {
        if (count > 0){
            int n3 = n1 + n2;
            n1 = n2 ;
            n2 = n3;
            System.out.print(n3 + " ");
            callRecursively(count - 1, n1, n2);
        }
    }

    public static void main(String[] args) {

        System.out.println("Find fibonacci series without recursion");
        int count = 20;
        fibonacciSimple(count);
        System.out.println();
        System.out.println("Find fibonacci series with recursion");
        fibonacciRecursion(count);
    }
}
