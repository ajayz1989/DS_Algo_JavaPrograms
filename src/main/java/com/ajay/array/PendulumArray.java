package com.ajay.array;

/**
 * Created by ajayk297 on 15/09/17.
 */
public class PendulumArray {

    private void swap(int array[], int position1, int position2) {
        int temp = array[position1];
        array[position1] = array[position2];
        array[position2] = temp;

    }

    private void quickSort(int arr[] ,int lowerIndex, int higherIndex) {
        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = arr[lowerIndex + (higherIndex - lowerIndex) / 2];
        // Divide into two arrays
        while (i <= j) {
             /*
              * In each iteration, we will identify a number from left side which
              * is greater then the pivot value, and also we will identify a number
              * from right side which is less then the pivot value. Once the search
              * is done, then we exchange both numbers.
              */
            while (arr[i] > pivot) {
                i++;
            }
            while (arr[j] < pivot) {
                j--;
            }
            if (i <= j) {
                swap(arr,i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(arr,lowerIndex, j);
        if (i < higherIndex)
            quickSort(arr, i, higherIndex);
    }

    private void pendulumSort(int array[]) {
        int n = array.length;
        if (n < 2) {
            return;
        }
        quickSort(array,0,n-1); //5 4 3 2 1 =>   5 3 1 2 4
        int e = 0;
        int o = 1;
        while (e<n){
            while (e < (n+1)/2) {
                e += 2;
            }
            swap(array, e, o);
            e+=2;
            o+=2;
        }
        quickSort(array, 0, (n+1)/2 - 1);
        quickSort(array, (n+1)/2, n-1);
        reverseArr(array, (n+1)/2, n-1);

    }

    private void reverseArr(int[] array, int start, int end) {
        while (start< end){
            swap(array, start, end);
            start++;
            end--;
        }
    }

    public static void main(String args[]) {
        PendulumArray pa = new PendulumArray();
   //     int arr[] = {1, 2, 3, 4, 5};
//        int arr[] = {1, 8, 4, 2,7,5,9};
        int arr[] = {3,5,9,11,13,15};

//        pa.quickSort(arr ,0, arr.length-1);

        pa.pendulumSort(arr);
        for(int i: arr){
            System.out.println(i);
            System.out.println(" ");
        }
    }
}
