//------------------------------PROBLEM 3634-------------------------------//  
//                  MINIMUM REMOVALS TO BALANCE ARRAY                      //


// Logic:
// -> Sort the input array nums
// -> Initialize a variable result to store the minimum number of removals to 
//    the length of the array (worst case, we remove all elements)
// -> Initialize a variable right to keep track of the right pointer in the 
//    two-pointer
// -> Iterate through the array using a left pointer from 0 to n-1
// -> For each left pointer:
//    - Move the right pointer to the right as long as the condition
//      nums[right] <= nums[left] * k is satisfied
//      - This condition is given in the problem statement 
//        "An array is considered balanced if the value of its maximum element is
//         at most k times the minimum element"
//    - Update the result by calculating the number of elements that would
//      need to be removed, which is n - (right - left)
//    - Update only if the calculated removals is less than the current result
// -> Return the result as the minimum number of removals needed to balance
//    the array


class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length; 
        Arrays.sort(nums); 

        int result = n; 
        int right = 0; 

        for(int left = 0; left < n; left++) {
            while(right < n && nums[right] <= (long) nums[left] * k) {
                right++; 
            }
            result = Math.min(result, n - (right - left));
        }

        return result; 
        
    }
}


// Time Complexity:
// -> Sorting the array: O(n log n)
// -> Two-pointer traversal: O(n)
// Overall, O(n log n) + O(n)
//=> O(n log n)