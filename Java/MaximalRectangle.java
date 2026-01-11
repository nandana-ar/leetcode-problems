//------------------------------PROBLEM 85--------------------------------//
//                          MAXIMAL RECTANGLE                             //


// Logic: 
// -> Create a height matrix to store the height of consecutive '1's for
//    each cell in the original matrix
// -> Fill the height matrix by iterating through each cell of the original
//    matrix
//    - If the cell contains '1', set the height to 1 plus the height of the
//      cell directly above it (or 1 if it's in the first row)
//    - If the cell contains '0', set the height to 0
// -> Set the minHeight variable to track the minimum height of '1's
//    encountered so far in the current row
// -> For each cell in the current row, if the height is greater than 0,
//    iterate leftwards to calculate the maximum area of rectangles that
//    can be formed with the current cell as the right boundary
//    - Update minHeight to be the minimum of the current minHeight and
//      the height of the cell being considered
//    - Calculate the width as the distance from the current cell to the
//      left boundary
//    - Calculate the area as minHeight multiplied by width
//    - Update maxArea if the calculated area is greater than the current
//      maxArea
// -> Return the maximum area found


class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] height = new int[m][n];
        int maxArea = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    height[i][j] = (i == 0) ? 1 : height[i - 1][j] + 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (height[i][j] == 0) continue;

                int minHeight = height[i][j];

                for (int k = j; k >= 0; k--) {
                    minHeight = Math.min(minHeight, height[i][k]);
                    if (minHeight == 0) break;

                    int width = j - k + 1;
                    maxArea = Math.max(maxArea, minHeight * width);
                }
            }
        }

        return maxArea;
    }
}


//Time Complexity:
// -> Filling the height matrix: O(m * n) where m is the number
//    of rows and n is the number of columns in the original matrix
// -> For each cell in the height matrix, we may need to iterate leftwards
//    up to n times in the worst case, leading to an additional 
//    O(m * n * n) time complexity
// Overall, O(m * n) + O(m * n^2)
// => O(m * n^2)