//-----------------------------PROBLEM 42--------------------------------//
//                        TRAPPING RAIN WATER                            //


//Logic:
// -> Use two pointers, one at the start (left) and one at the end (right)
//    of the array
// -> Keep track of the maximum height encountered from the left (maxOnLeft)
//    and from the right (maxOnRight)
// -> Move the pointer with the smaller maximum height inward
// -> For each position, calculate the water that can be trapped by
//    subtracting the current height from the maximum height on that side
// -> Accumulate the trapped water in the result variable
// -> Repeat the process until the two pointers meet
// -> Return the total trapped water


import java.util.*;

class Solution {
    public int trap(int[] height) {

        if(height == null || height.length == 0){
            return 0; 
        }

        int left = 0; 
        int right = height.length - 1;
        int maxOnLeft = height[left];
        int maxOnRight = height[right];
        int result = 0;  

        while (left < right) {
            if(maxOnLeft < maxOnRight) {
                left++; 
                maxOnLeft = Math.max(maxOnLeft, height[left]);
                result += maxOnLeft - height[left];
            } else {
                right--; 
                maxOnRight = Math.max(maxOnRight, height[right]);
                result += maxOnRight - height[right];
            }
        }

        return result;
        
    }
}


//Time Complexity:
// -> Iterating through the array once
//    - Array is scanned from both ends without resetting
//    - Updating maximum heights and calculating trapped water: O(1)
//    => O(n) * O(1) = O(n)
// Overall, O(n)
// => O(n)