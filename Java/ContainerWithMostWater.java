//-----------------------------PROBLEM 11--------------------------------//
//                      CONTAINER WITH MOST WATER                        //


//Logic:
// -> Use two pointers, one at the start (left) and one at the end (right)
//    of the array
// -> Find the maximum height between the two pointers
// -> Calculate the area formed between the two pointers using the formula:
//    area = min(height[left], height[right]) * (right - left)
// -> Update the maximum area if the calculated area is greater
//    than the current maximum
// -> Move the left pointer to the right if the left height is less
//    than the right height, otherwise move the right pointer to the left
// -> Repeat the process until the two pointers meet


import java.util.*;

class Solution {
    public int maxArea(int[] height) {
        
        int maxAmount = 0; 
        int left = 0;
        int right = height.length - 1; 
        
        while(left < right) {
            
            int maxHeight = Math.min(height[left], height[right]);
            int product = maxHeight * (right - left);
                if(product > maxAmount){
                    maxAmount = product;
                }
            
            if(maxHeight == height[left]){
                left++; 
            } else if (maxHeight == height[right]){
                right--; 
            }

        }

        return maxAmount; 
    }
}


//Time Complexity:
// -> Iterating through the array once 
//    - Array is scanned from both ends without resetting
//    - Finding the maximum height and calculating the area: O(1)
//    => O(n) * O(1) = O(n)
// Overall, O(n)
// => O(n)
