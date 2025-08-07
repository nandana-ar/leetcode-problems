//------------------------------PROBLEM 448------------------------------//
//              FIND ALL NUMBERS DISAPPEARED IN AN ARRAY                 //


import java.util.*;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> result = new ArrayList<>(); 
        
        Arrays.sort(nums);
        
        for (int i = 1; i <= nums.length; i++) {

            int index = Arrays.binarySearch(nums, i);
            if (index < 0){

                result.add(i);
            }
        }
        
        return result; 
    }
}


// Time Complexity: 
// -> Sorting the array: O(n log n)
// -> For each number from 1 to n:
//     - Performing binary search: O(log n)
//     - Adding to result list if not found: O(1)
//     => O(n) * (O(log n) + O(1)) = O(n log n)
// Overall, O(n log n) + O (n log n)  
// => O(n log n)