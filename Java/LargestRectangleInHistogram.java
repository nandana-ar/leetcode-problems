//-----------------------------PROBLEM 84--------------------------------//
//                    LARGEST RECTANGLE IN HISTOGRAM                     //

//~~~~~~~~~~~~~~~~~~~~Attempt #1 [Time Limit Exceeded]~~~~~~~~~~~~~~~~~~~//
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


//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Attempt #2~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
// Logic:
// -> Create a leftMost array to store the index of the nearest smaller bar to 
//   the left for each bar
// -> Create a rightMost array to store the index of the nearest smaller bar to
//   the right for each bar
// -> Use a stack to efficiently find the nearest smaller bars
// -> Iterate through the heights array to fill the leftMost array
//    - For each bar, pop from the stack until the top of the stack is smaller
//      than the current bar or the stack is empty
//    - If the stack is not empty, the top of the stack is the index of the
//      nearest smaller bar to the left
//    - Push the current index onto the stack
// -> Clear the stack and repeat the process in reverse to fill the rightMost
//   array
//    - For each bar, pop from the stack until the top of the stack is smaller
//      than the current bar or the stack is empty
//    - If the stack is not empty, the top of the stack is the index of the
//      nearest smaller bar to the right
//    - Push the current index onto the stack
// -> Iterate through the heights array to calculate the maximum area
//    - For each bar, calculate the width using the leftMost and rightMost
//      arrays
//    - Calculate the area and update the maximum area if needed
// -> Return the maximum area found

class Solution {
    public int largestRectangleArea(int[] heights) {

        int n = heights.length; 
        int[] leftMost = new int[n]; 
        int[] rightMost = new int[n]; 
        Stack<Integer> stack = new Stack<>(); 

        for (int i = 0; i < n; i++){
            leftMost[i] = -1; 

            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();    
            }

            if (!stack.isEmpty()) {
                leftMost[i] = stack.peek(); 
            }

            stack.push(i); 
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--){
            rightMost[i] = n; 

            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();    
            }

            if (!stack.isEmpty()) {
                rightMost[i] = stack.peek(); 
            }

            stack.push(i); 
        }

        int maxArea = 0; 
        
        for (int i = 0; i < n; i++) {
            leftMost[i] += 1; 
            rightMost[i] -= 1;
            maxArea = Math.max(maxArea, heights[i] * (rightMost[i] - leftMost[i] + 1));
        }

        return maxArea; 
    }
}

// Time Complexity:
// -> Pushing and popping each index onto/from the stack: O(n)
// -> Filling the leftMost array: O(n)
// -> Filling the rightMost array: O(n)
// -> Calculating the maximum area: O(n)
// Overall, O(n) + O(n) + O(n)
// => O(n)