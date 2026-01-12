//------------------------------PROBLEM 1266------------------------------//
//                     MINIMUM TIME VISITING ALL POINTS                   //


// Logic:
// -> Create a variable to keep track of total seconds needed to visit all 
//    points
// -> Loop through each point and calculate the differences in x and y 
//    coordinates of the current point and the next point
// -> Take the absolute values of the differences
// -> The time taken to move from one point to another is the maximum of the 
//    two differences
// -> Add the time taken to the total seconds
// -> Return the total seconds after visiting all points


class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {

        int totalSeconds = 0; 
        int length = points.length; 
      
        for(int n = 0; n < length - 1; n++) {
            int currX = points[n][0];
            int currY = points[n][1];

            int nextX = points[n + 1][0];
            int nextY = points[n + 1][1];

            int xDifference = Math.abs(nextX - currX); 
            int yDifference = Math.abs(nextY - currY);

            int timeBetweenPoints = Math.max(xDifference, yDifference);
            totalSeconds = totalSeconds + timeBetweenPoints;
        }

        return totalSeconds;
    }
}


// Time Complexity:
// -> Iterating through each point: O(n)
// -> Assignment and arithmetic operations: O(1)
// Overall, O(n) * O(1)
// => O(n)
