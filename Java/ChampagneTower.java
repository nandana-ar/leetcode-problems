//-----------------------------PROBLEM 799--------------------------------//
//                           CHAMPAGNE TOWER                              //


// Logic:
// -> Create a 2D array tower to represent the champagne tower, where 
//    tower[r][c] represents the amount of champagne in the glass at row r 
//    and column c
// -> Initialize the top glass (tower[0][0]) with the poured amount of
//    champagne poured
// -> Iterate through the rows of the tower up to query_row:
//   - Iterate through the columns of the current row:
//     - If the amount of champagne in the current glass (tower[r][c]) is
//       greater than 1.0, it means there is excess champagne that will flow
//       to the glasses below:
//       - Calculate the excess champagne as (tower[r][c] - 1.0) / 2.0
//       - Set the current glass to 1.0 (since it can only hold 1 cup of
//         champagne)
//       - Add the excess champagne to the two glasses directly below the
//         current glass (tower[r + 1][c] and tower[r + 1][c + 1])
// -> After iterating through the rows, return the amount of champagne in
//    the glass at query_row and query_glass (tower[query_row][query_glass])


class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] tower = new double[102][102];
        tower[0][0] = (double) poured;

        for (int r = 0; r <= query_row; r++) {
            for (int c = 0; c <= r; c++) {
                if (tower[r][c] > 1.0) {
                    double excess = (tower[r][c] - 1.0) / 2.0;
                    tower[r][c] = 1.0;
                    tower[r + 1][c] += excess;
                    tower[r + 1][c + 1] += excess;
                }
            }
        }
        return tower[query_row][query_glass];
    }
}


// Time Complexity:
// -> Iterate through the rows up to query_row: O(query_row)
// -> Iterate through the columns of each row: O(query_row)
// Overall, O(query_row) * O(query_row) 
// => O(query_row^2)