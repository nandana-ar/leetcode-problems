//----------------------------PROBLEM 1292-------------------------------//
//    MAXIMUM SIDE LENGTH OF A SQUARE WITH SUM LESS THAN OR EQUAL TO     //
//                             THRESHOLD                                 //    


// Logic:
// -> Initialise variables m and n to store the number of rows and columns 
//    in the matrix
// -> Create a 2D array prefixSum to store the prefix sums of the matrix
// -> Using nested loops, fill the prefixSum array such that each element 
//    at (i, j) contains the sum of all elements from (0, 0) to (i-1, j-1) 
//    in the original matrix 
// -> Set the left pointer to 1 and the right pointer to the minimum of 
//    m and n for binary search
// -> While left is less than or equal to right, calculate the mid value
// -> Using nested loops, check all possible squares of side length mid
//    in the matrix
// -> Calculate the sum of each square using the prefixSum array and 
//    add overlap to account for the overlap removed twice
// -> If the sum of the square is less than or equal to the threshold,
//    set a flag find to true and break out of the loops
// -> If such a square is found, update the result and move the left pointer
//    to mid + 1 to search for a larger square
// -> If not found, move the right pointer to mid - 1 to search for a smaller square
// -> Finally, return the result which contains the maximum side length of
//    the square with sum less than or equal to the threshold


class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length; 
        int n = mat[0].length; 
        int[][] prefixSum = new int[m + 1][n + 1]; 

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                prefixSum[i][j] = prefixSum[i - 1][j] +
                                  prefixSum[i][j - 1] - 
                                  prefixSum[i - 1][j - 1] +
                                  mat[i - 1][j - 1];
            }
        }

        int left = 1; 
        int right = Math.min(m, n);
        int result = 0; 


        while (left <= right) {
            int mid = (left + right) / 2;
            boolean find = false;

            for (int i = 1; i <= m - mid + 1; i++) {
                for (int j = 1; j <= n - mid + 1; j++) {
                    int sum =
                        prefixSum[i + mid - 1][j + mid - 1] -
                        prefixSum[i - 1][j + mid - 1] -
                        prefixSum[i + mid - 1][j - 1] +
                        prefixSum[i - 1][j - 1]; // add overlap to account for the overlap removed twice
                    if (sum <= threshold) {
                        find = true;
                        break;
                    }
                }
                if (find) break;
            }
            if (find) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
 
        return result; 

    }
}


// Time Complexity: 
