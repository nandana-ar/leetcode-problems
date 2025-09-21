//------------------------------PROBLEM 153------------------------------//
//                 FIND MINIMUM IN ROTATED SORTED ARRAY                  //


// Logic: 
// -> Initialise start and end pointers to the beginning and end of the array
// -> Check if the array is already sorted 
//                    (i.e. the first element is less than the last element)
//    - If it is sorted, return the first element as the minimum
// -> Calculate the middle index of the current search range
// -> Compare the middle element with the end element
//    - If the middle element is greater than the end element, the minimum is
//      in the right half so move the start pointer to middle + 1
//    - If the middle element is less than or equal to the end element, the
//      minimum is in the left half or at middle so move the end pointer to 
//      middle
// -> Continue the process until start meets end
// -> Return the element at the start pointer (the minimum element)


import java.util.*;

class Solution {
    public int findMin(int[] nums) {
        int start = 0; 
        int end = nums.length - 1; 

        if(nums[start] < nums[end]) {
            return nums[start]; 
        }
        
        while(start < end) {
            int middle = (int) (start + end)/2; 
       
            if(nums[end] < nums[middle]) { 
                start = middle + 1; 
            } else { 
                end = middle; 
            }
        }

        return nums[start];  
    }
}


// Time Complexity:
// -> Halving the search space in each iteration: O(log n)
// -> Finding the middle index and comparing with end element: O(1)
// Overall, O(log n) * O(1)
// => O(log n)
