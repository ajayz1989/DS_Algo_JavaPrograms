package com.ajay.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ajayk297 on 09/10/17.
 */
public class FindSumInArray {

    //Time complexity is O(n) , space complexity uses extra space for hashmap. Best to use this.
    public static void findSumofTwoNosInArrayUsingComplement(int[] arr, int sum) {
        Map<Integer, Integer> map = new HashMap();

        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int complement = sum - arr[i];

            if (map.containsKey(complement)) {
                System.out.println(arr[i] + " + " + complement);
            } else {
                map.put(arr[i], complement);
            }
        }
    }
    //Time complexity is O(n), works only on sorted arrays and it can only be use to find only one pair
    public static void findSumOfTwoNosInArrayUsingPointers(int[] arr, int sum){
        int i = 0, n = arr.length-1;
        while (i < n){

            if(arr[i] + arr[n] == sum){
                System.out.println(arr[i] +" + "+arr[n]);
                return;
            }else if (arr[i] + arr[n] > sum){
                n--;
            }else if (arr[i] + arr[n] < sum){
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6};

        findSumofTwoNosInArrayUsingComplement(arr, 8);
        System.out.println("----------------------------");
        findSumOfTwoNosInArrayUsingPointers(arr, 8);
    }
}
