package com.ajay.array;

/**
 * Created by ajayk297 on 23/10/17.
 * Here zig-zag positions are not allowed, find chars only in 8 directions.
 */
public class FindWordIn2DMatrix {

    //here we can use enum as well as array for storing 8 directions from a cell, enum has been used to make it readable
    //int rowNum[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
    //int colNum[] = { -1, 0, 1, -1, 1, -1, 0, 1 };
    enum Direction {
        UP_LEFT(-1, -1), UP(-1, 0), UP_RIGHT(-1, 1), LEFT(0, -1),
        DOWN_LEFT(1, -1), DOWN_RIGHT(1, 1), DOWN(1, 0), RIGHT(0, 1);

        private int rowMove, columnMove;

        Direction(int row, int column) {
            this.rowMove = row;
            this.columnMove = column;
        }
    }

    void findOccurenceOfWord(char[][] matrix, char[] word) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                searchWordInMatrix(matrix, word, i, j);
            }
        }
    }

    /*
        Main logic for searching characters of words to find in all the 8 directions given above.
     */
    private void searchWordInMatrix(char[][] matrix, char[] word, int row, int column) {
        if (!(matrix[row][column] == word[0])) {
            return;
        }
        for (Direction direction : Direction.values()) {
            int k;
            String path = word[0] + "(" + row + "," + column + ")";
            int newRow = row + direction.rowMove;
            int newColumn = column + direction.columnMove;
            int length = word.length;

            for (k = 1; k < length; k++) {

                if (!(isValidPosition(matrix, newRow, newColumn) && matrix[newRow][newColumn] == word[k])) {
                    break;
                }
                path = path.concat(word[k] + "(" + newRow + "," + newColumn + ")");
                newRow = newRow + direction.rowMove;
                newColumn = newColumn + direction.columnMove;
            }
            if (k == length) {
                System.out.println(path);
            }
        }
    }
    /*
        To verify the valid position in the matrix.
     */
    private boolean isValidPosition(char[][] matrix, int row, int column) {
        if (row >= 0 && row < (matrix.length) && column >= 0 && column < matrix[row].length) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        char matrix[][] = new char[][]{ {'D', 'N', 'E', 'Y', 'S'},
                                        {'E', 'E', 'D', 'E', 'S'},
                                        {'S', 'G', 'D', 'D', 'E'}
                                        };

        char word[] = "DES".toCharArray();

        new FindWordIn2DMatrix().findOccurenceOfWord(matrix, word);
    }

}
