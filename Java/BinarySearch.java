//------------------------------PROBLEM 704------------------------------//
//                             BINARY SEARCH                             //


// Logic: 
// -> Initialize start and end pointers to the beginning and end of the 
//    original array 
// -> Calculate the middle index of the current search range
// -> Compare the middle element with the target
//    - If they are equal, return the middle index
//    - If the target is less than the middle element, adjust the end pointer to 
//      middle - 1 to search in the left half
//    - If the target is greater than the middle element, adjust the start pointer 
//      to middle + 1 to search in the right half
// -> Repeat the process until the target is found or the search range is invalid
// -> If the target is not found, return -1
// -> Else return the index of the target


class Solution {
    public int search(int[] nums, int target) {
        int start = 0; 
        int end = nums.length - 1; 
        int middle = (int) (start + end )/2; 

        while(nums[middle] != target && start <= end) {
            if(target < nums[middle]) {
                end = middle - 1; 
                middle = (int) (start + end)/2; 
            } else { 
                start = middle + 1; 
                middle = (int) (start + end)/2; 
            }
        }

        if(nums[middle] == target) {
            return middle;
        } else {
            return -1; 
        }
         
    }
}


// Time Complexity:
// -> Halving the search space in each iteration: O(log n)
// -> Finding the middle index and comparing with target: O(1)
// Overall, O(log n) * O(1)
// => O(log n)