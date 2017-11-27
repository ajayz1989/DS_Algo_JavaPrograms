package com.ajay.array;

/**
 * Created by ajayk297 on 26/11/17.
 */
public class AllPathIn2DArray {
    static int array[][] = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
    };

    //need to find all path from (0,0) to end(m,n) in a 2D array
    int row = array.length;
    int column = array[0].length;

    public void findAllPath(int[][] arr, int currentrow, int currentcolumn, String path) {

        if (currentrow == row - 1) {
            for (int i = currentcolumn; i < column; i++) {
                path = path + "-" + arr[currentrow][i];
            }
            System.out.println(path);
            return;
        }
        if (currentcolumn == column - 1) {
            for (int i = currentrow; i < row; i++) {
                path = path + "-" + arr[i][currentcolumn];
            }
            System.out.println(path);
            return;
        }

        path = path + "-" + arr[currentrow][currentcolumn];
        //move one step in right direction
        findAllPath(arr, currentrow + 1, currentcolumn, path);
        //move one step in down direction
        findAllPath(arr, currentrow, currentcolumn + 1, path);
        //move one step in diagonal direction
        findAllPath(arr, currentrow+1, currentcolumn+1, path);
    }

    public static void main(String[] args) {
        new AllPathIn2DArray().findAllPath(array, 0, 0, "");
    }
}
