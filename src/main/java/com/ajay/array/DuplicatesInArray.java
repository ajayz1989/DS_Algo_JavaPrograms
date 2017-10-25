package com.ajay.array;

/**
 * Created by ajayk297 on 25/10/17.
 */
public class DuplicatesInArray {

    //elements need to be between 0 to n-1, n is size of an array
    //this logic finds only 2 repetitive integers
    //Time & Space complexity are O(n) & O(1)
    public static void main(String[] args) {
        int array[] = {1,4,1,4,6,0,0};

        for (int i = 0; i < array.length; i++){
            if ( array[(Math.abs(array[i]))] >= 0){
                array[(Math.abs(array[i]))] = -array[(Math.abs(array[i]))] ;
            }else
                System.out.println(Math.abs(array[i]) );
        }

    }
}
