//----------------------------PROBLEM 3453-------------------------------//
//                         SEPARATE SQUARES I                            //


// Logic:
// -> Main function separateSquares:
//    - Initialise low and high bounds for binary search as the maximum and 
//      minimum double values
//    - Iterate through each square to update the low and high bounds
//       - If the bottom edge of the square is less than low, update low
//       - If the top edge of the square is greater than high, update high
//    - Perform binary search until the difference between high and low is
//       less than the given threshold (1e-6)
//       - Calculate mid as the average of low and high
//       - Calculate the area difference using the helper function areaDifference
//       - If the area difference is positive, it means the area above mid
//         is greater than the area below mid, so update low to mid
//       - Otherwise, update high to mid
//    - Return the average of low and high as the final result
// -> Helper function areaDifference:
//    - Initialise variables above and below to track areas above and below h
//    - Iterate through each square:
//       - Calculate the bottom and top edges of the square
//       - If h is less than or equal to the bottom edge (meaning the square is 
//         entirely above h), add the full area of the square to above
//       - If h is greater than or equal to the top edge (meaning the square is 
//         entirely below h), add the full area of the square to below
//       - If h is between the bottom and top edges (meaning the line cuts through
//         the square):
//          - Calculate the height below h by subtracting the bottom edge from h
//          - Calculate the height above h by subtracting h from the top edges
//          - Add the area below h to below and the area above h to above
//    - Return the difference between above and below




class Solution {
    public double separateSquares(int[][] squares) {

        double low = Double.MAX_VALUE;
        double high = Double.MIN_VALUE;

        for (int[] square : squares) {
            low = Math.min(low, square[1]);
            high = Math.max(high, square[1] + square[2]);
        }

        while (high - low > 1e-6) {
            double mid = (low + high) / 2.0;

            double diff = areaDifference(squares, mid);

            if (diff > 0) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return (low + high) / 2.0;
    }

    private double areaDifference(int[][] squares, double h) {

        double above = 0.0;
        double below = 0.0;

        for (int[] sq : squares) {
            double y = sq[1];
            double l = sq[2];

            double bottom = y;
            double top = y + l;

            if (h <= bottom) {
                above += l * l;

            } else if (h >= top) {
                below += l * l;

            } else {

                double heightBelow = h - bottom;
                double heightAbove = top - h;

                below += heightBelow * l;
                above += heightAbove * l;
            }
        }

        return above - below;
    }
}


//Time Complexity:
// -> Iterating through the squares to find bounds: O(n)
// -> Binary search iterations: O(log((maxY - minY) / 1e-6))
// -> Calling areaDifference in each iteration: O(n)
// Overall, O(n) + O(n log((maxY - minY) / 1e-6))
// => O(n log((maxY - minY) / 1e-6))
// Rounded to O(n log m) where m is the range of y-values