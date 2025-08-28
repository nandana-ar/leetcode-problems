//-----------------------------PROBLEM 36--------------------------------//
//                            VALID SUDOKU                               //


//Logic:
// -> Create a HashSet to track seen numbers
// -> Check each row for duplicates
//    - Iterate board[row][i] where row is fixed and i moves across columns
// -> If a the char is '.', skip and move on to the next char
// -> If a duplicate is found, return false
// -> Check each column for duplicates (same as above)
//    - Iterate board[j][column] where column is fixed and j moves across rows
// -> Check each 3x3 sub-box for duplicates
//    - Formula for row inside sub-box: (square number / 3) * 3 + i
//    - Eg for square number 4 (middle box), row = (4 / 3) * 3 + i  
//                                               =  1(remainder 1) *3 + i
//                                               =  3 + i
//                                               =  3, 4, 5 (as i goes from 0 to 2)
//    - Formula for col inside sub-box: (square number % 3) * 3 + j
//    - Eg for square number 4 (middle box), col = (4 % 3) * 3 + j
//                                               =  1 * 3 + j
//                                               =  3 + j
//                                               =  3, 4, 5 (as j goes from 0 to 2)
//      (where square number goes from 0 to 8, i and j go from 0 to 2)
// -> If no duplicates are found in rows, columns, and sub-boxes, return true


import java.util.*;

class Solution {
    public boolean isValidSudoku(char[][] board) {

        for (int row = 0; row < 9; row++) {
            Set<Character> seen = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                if (board[row][i] == '.') 
                    continue;
                if (seen.contains(board[row][i])) 
                    return false;
                seen.add(board[row][i]);
            }
        }

        for (int column = 0; column < 9; column++) {
            Set<Character> seen = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[j][column] == '.') 
                    continue;
                if (seen.contains(board[j][column])) 
                    return false;
                seen.add(board[j][column]);
            }
        }

        for (int square = 0; square < 9; square++){
            Set<Character> seen = new HashSet<>();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int row = (square / 3) * 3 + i;
                    int col = (square % 3) * 3 + j;
                    if (board[row][col] == '.') 
                        continue;
                    if (seen.contains(board[row][col])) 
                        return false;
                    seen.add(board[row][col]);
                }
            }
        }

        return true; 

    }
}

//Time Complexity:
// -> Iterating and checking each row: 
//    O(9) * O(9) = O(81)
// -> Iterating and checking each column:
//    O(9) * O(9) = O(81)
// -> Iterating and checking each 3x3 sub-box:
//    O(9) * O(3) * O(3) = O(81)
// Overall, O(81) + O(81) + O(81)
// => O(1) (since the board size is fixed at 9x9)
