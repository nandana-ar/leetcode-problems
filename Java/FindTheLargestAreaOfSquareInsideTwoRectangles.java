//----------------------------PROBLEM 3047-------------------------------//
//         FIND THE LARGEST AREA OF SQUARE INSIDE TWO RECTANGLES         //


// Logic:
// -> Initialize a variable to store the number of rectangles 
// -> Initialize a variable to track the largest square area found
// -> Use a nested loop to iterate through all unique pairs of rectangles
// -> For each pair, calculate the overlapping region:
//    - Determine the left boundary as the maximum of the left x-coordinates
//      of the two rectangles
//    - Determine the right boundary as the minimum of the right x-coordinates
//      of the two rectangles
//    - Determine the bottom boundary as the maximum of the bottom y-coordinates
//      of the two rectangles
//    - Determine the top boundary as the minimum of the top y-coordinates
//      of the two rectangles
// -> Check if there is an overlap by ensuring the left boundary is less than
//    the right boundary and the bottom boundary is less than the top boundary
// -> If there is an overlap, calculate the width and height of the overlapping
//    region by subtracting the boundaries
// -> Take the minimum of the width and height to determine the side length
//    of the largest square that can fit in the overlapping region
// -> Calculate the area of this square by squaring the side length
// -> Update the largest area if this area is greater than the current largest
//    area
// -> After checking all pairs, return the largest square area found


class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n = bottomLeft.length; 
        long largestArea = 0; 

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {

                long left = Math.max(bottomLeft[i][0], bottomLeft[j][0]);
                long right = Math.min(topRight[i][0], topRight[j][0]);
                long bottom = Math.max(bottomLeft[i][1], bottomLeft[j][1]);
                long top = Math.min(topRight[i][1], topRight[j][1]);

                if(left < right && bottom < top) {
                    long width = right - left; 
                    long height = top - bottom; 

                    long side = Math.min(width, height);

                    largestArea = Math.max(largestArea, side * side);
                }
            }
        }

        return largestArea; 
        
    }
}


// Time Complexity:
// - Iterating through all unique pairs of rectangles: O(n^2)
// - Calculating the overlapping region and area for each pair: O(1)
// Overall, O(n^2) + O(1) 
// => O(n^2)