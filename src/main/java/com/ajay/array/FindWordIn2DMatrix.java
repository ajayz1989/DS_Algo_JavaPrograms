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
        LEFT(0,-1), RIGHT(0,1), UP(-1,0), DOWN(1,0),
        UP_LEFT(-1,-1), UP_RIGHT(-1,1), DOWN_LEFT(1,-1), DOWN_RIGHT(1,1);

        private int rowMove, columnMove;

        Direction(int rowMove, int columnMove) {
            this.rowMove = rowMove;
            this.columnMove = columnMove;
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
        if (!(word[0] == matrix[row][column] ) ){
            return;
        }
        for (Direction direction : Direction.values()){
            String path = word[0] + "(" + row + "," + column + ")";
            int newRow = row + direction.rowMove;
            int newCol = column + direction.columnMove;
            int k;
            for ( k=1 ; k<word.length; k++){
                if ( !(isValidPosition(matrix, newRow, newCol) && word[k] == matrix[newRow][newCol]) ){
                    break;
                }
                path = path.concat(word[k] + "(" + newRow + "," + newCol + ")");
                newRow = newRow + direction.rowMove;
                newCol = newCol + direction.columnMove;
            }
            if(k == word.length){
                System.out.println(path);
            }

        }
    }

    /*
        To verify the valid position in the matrix.
     */
    private boolean isValidPosition(char[][] matrix, int row, int column) {
        if (row>=0 && row<matrix.length && column>=0 && column<matrix[row].length){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        char matrix[][] = new char[][]{{'D', 'N', 'E', 'Y', 'S'},
                                        {'E', 'E', 'D', 'E', 'S'},
                                         {'S', 'G', 'D', 'D', 'E'}
        };
        char word[] = "DES".toCharArray();

        new FindWordIn2DMatrix().findOccurenceOfWord(matrix, word);
    }
}