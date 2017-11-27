package com.ajay.array;

import java.util.Scanner;

/**
 * Created by ajayk297 on 14/10/17.
 */
public class MaxSumHourGlass {

    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int arr_i=0; arr_i < 6; arr_i++){
            for(int arr_j=0; arr_j < 6; arr_j++){
                arr[arr_i][arr_j] = in.nextInt();
            }
        }*/

        int arr[][] = {{1, 1, 1, 0, 0, 0},
                       {0, 1, 0, 0, 0, 0},
                       {1, 1, 1, 0, 0, 0},
                       {0, 9, 2, -4, -4, 0},
                       {0, 0, 0, -2, 0, 0},
                       {0, 0, -1, -2, -4, 0}};

        calculateMaxSumOfHourGlass(arr);
    }

    private static void calculateMaxSumOfHourGlass(int arr[][]){
        int maxRow = arr.length-2;
        int maxColumn = arr[0].length-2;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0 ; i<maxRow; i++ ){
            for(int j=0; j<maxColumn; j++){
                int sum=0;
                int topRowSum = arr[i][j]+arr[i][j+1]+arr[i][j+2];
                int middleRowSum = arr[i+1][j+1];
                int bottomRowSum = arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2];
                sum = topRowSum + middleRowSum + bottomRowSum ;
                if(sum > maxSum){
                    maxSum = sum;
                }
            }

        }
        System.out.println("Max sum of hour glass is - " + maxSum);
    }
}
