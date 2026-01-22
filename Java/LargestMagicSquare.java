//----------------------------PROBLEM 1895-------------------------------//
//                        LARGEST MAGIC SQUARE                           //


// Logic:
// -> largestMagicSquare function:
//    - Initialize variables to store the number of rows and columns in 
//      the grid
//    - Initialize a prefix sum array for rows to store cumulative sums 
//      for each row
//    - Populate the array by iterating through each cell in the grid and 
//      updating the cumulative sum
//    - Initialize a prefix sum array for columns to store cumulative sums 
//      for each column
//    - Populate the array similarly by iterating through each cell in the 
//      grid and updating the cumulative sum
//    - Determine the maximum possible size of a magic square based on the 
//      minimum between rows and columns
//    - Use an integer k to represent the size of the square, starting from 
//      the maximum size and decrementing down to 2
//    - For each size k, iterate through all possible starting positions (r, c) 
//      in the grid where a k x k square can fit
//    - For each position, call a helper function isMagic to check if the 
//      k x k square starting at (r, c) is a magic square
//    - If a magic square is found, return the size k immediately 
//    - If no magic square larger than size 1 is found after checking all 
//      possibilities, return 1
//
// -> isMagic function:
//    - Calculate the target sum using the formula:
//      target = prefixSumRow[row][column + sideLength] - 
//               prefixSumRow[row][column]
//     { This calculates the sum of the first row of the square, which serves
//      as the reference sum that all other rows, columns, and diagonals must
//      match to qualify as a magic square }
//    - Check each row in the square to see if its sum matches the target sum
//    - Check each column in the square similarly to see if its sum matches 
//      the target sum
//    - Calculate the sum of the main diagonal (top-left to bottom-right) and
//      check if it matches the target sum
//    - Calculate the sum of the anti-diagonal (top-right to bottom-left) and
//      check if it matches the target sum
//    - If all checks pass, return true
//    - Otherwise, return false



class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length; 
        int n = grid[0].length; 

        int[][] prefixSumRow = new int[m][n + 1]; 
        for(int r = 0; r < m; r++) {
            for(int c = 0; c < n; c++) {
                prefixSumRow[r][c+1] = prefixSumRow[r][c] + grid[r][c];
            }
        }

        
        int[][] prefixSumColumn = new int[m + 1][n];
        for(int c = 0; c < n; c++) {
            for(int r = 0; r < m; r++) {
                prefixSumColumn[r+1][c] = prefixSumColumn[r][c] + grid[r][c];
            }
        } 

        int maxSize = Math.min(m, n);

        for (int k = maxSize; k >= 2; k--) {
            for (int r = 0; r + k <= m; r++) {
                for (int c = 0; c + k <= n; c++) {
                    if(isMagic(r, c, k, prefixSumRow, prefixSumColumn, grid)) {
                        return k; 
                    }
                }
            }
        }

        return 1; 
        
    }



    public boolean isMagic(int row, int column, int sideLength, 
        int[][] prefixSumRow, int[][] prefixSumColumn, int[][] grid) {

        int target = prefixSumRow[row][column + sideLength] - 
                    prefixSumRow[row][column]; 

        for(int i = row; i < row + sideLength; i++) {
            if(prefixSumRow[i][column + sideLength] - 
               prefixSumRow[i][column] != target) {
                return false; 
            }
        }

        for(int j = column; j < column + sideLength; j++) {
            if(prefixSumColumn[row + sideLength][j] - 
               prefixSumColumn[row][j] != target) {
                return false; 
            }
        }


        int diagonalFromLeft = 0; 

        for(int i = 0; i < sideLength; i++){
            diagonalFromLeft += grid[row + i][column + i];
        }

        if(diagonalFromLeft != target) {
            return false; 
        }


        int diagonalFromRight = 0; 

        for(int i = 0; i < sideLength; i++) {
            diagonalFromRight += grid[row + i][column + sideLength - 1 - i];
        }

        if(diagonalFromRight != target) {
            return false; 
        }

        return true;
    
    }

}


// Time Complexity:
// - Prefix sum calculation for rows: O(m * n)
// - Prefix sum calculation for columns: O(m * n)
// - For each possible square of size k (up to min(m, n)):
//     - Iterate over all starting positions in the grid: O(m * n)
//     - For each square, check rows, columns, and diagonals: O(k)
// Overall, O(m * n * k) for each k
//    Considering the largest k is min(m, n), the overall time complexity is:
// => O(m * n * min(m, n)^2)
