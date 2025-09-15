//-----------------------------PROBLEM 84--------------------------------//
//                    LARGEST RECTANGLE IN HISTOGRAM                     //


// Logic:
// -> Iterate through each bar in the histogram
// -> For each bar, expand to the left and right to find the maximum width
//    where the height is at least as tall as the current bar
// -> Calculate the area for the current bar (height * width)
// -> Keep track of the maximum area found during the iterations
// -> Return the maximum area after checking all bars


import java.util.*;

class Solution {
    public int largestRectangleArea(int[] heights) {

        int n = heights.length; 
        int maxArea = 0; 

        for(int i = 0; i < n; i++){
            int height = heights[i];

            int rightMost = i + 1; 
            while(rightMost < n && heights[rightMost] >= height) {
                rightMost++; 
            }

            int leftMost = i; 
            while(leftMost >=0 && heights[leftMost] >= height) {
                leftMost--; 
            }

            rightMost--; 
            leftMost++; 

            maxArea = Math.max(maxArea, height * (rightMost - leftMost + 1)); 

        }
        
        return maxArea; 
    }
}


// Time Complexity: 
// -> Iterating through each bar: O(n)
// -> Expanding to the left and right for each bar using while loop: O(n) 
// Overall, O(n) * O(n)
// => O(n^2)
