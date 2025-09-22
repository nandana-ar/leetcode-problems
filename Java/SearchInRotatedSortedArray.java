//-----------------------------PROBLEM 33--------------------------------//
//                     SEARCH IN ROTATED SORTED ARRAY                    //


//Logic:
// -> Initialize start and end pointers to the beginning and end of the array
// -> While start is less than or equal to end:
//    - Calculate the middle index of the current search range
//    - If the middle element is the target, return the middle index
//    - If the left half (from start to middle) is sorted:
//      - If the target is within the left half, move the end pointer 
//        to middle - 1
//      - Otherwise, move the start pointer to middle + 1
//    - If the right half (from middle to end) is sorted:
//      - If the target is within the right half, move the start pointer to
//        middle + 1
//      - Otherwise, move the end pointer to middle - 1
// -> If the target is not found, return -1


import java.util.*;

class Solution {
    public int search(int[] nums, int target) {

        int start = 0; 
        int end = nums.length - 1; 
        int middle = start + (end - start) / 2; 

        while(start <= end) {
            middle = start + (end - start) / 2; 

            if(nums[middle] == target) {
                return middle; 
            } else if(nums[start] <= nums[middle]) {
                if(nums[start] <= target && target < nums[middle]) {
                    end = middle - 1; 
                } else {
                    start = middle + 1;
                }
            } else {
                if(nums[middle] < target && target <= nums[end]) {
                    start = middle + 1; 
                } else {
                    end = middle - 1; 
                }
            }
        }
       
        return -1;    

    }
}


//Time Complexity:
// -> Halving the search space in each iteration: O(log n)
// -> Finding the middle index and comparing with target: O(1)
// Overall, O(log n) * O(1)
// => O(log n)
