//------------------------------PROBLEM 448------------------------------//
//              FIND ALL NUMBERS DISAPPEARED IN AN ARRAY                 //


//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Attempt #1~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
// Logic: 
// -> Create a result list to store missing numbers
// -> Sort the input array
// -> For each number from 1 to n, check if it exists in the sorted array
// -> If it does not exist, add it to the result list
// -> Return the result list


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



//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Attempt #2~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
// Logic: 
// -> Create a result list to store missing numbers
// -> Iterate through the input array
// -> For each number, mark its corresponding index as negative
// -> After marking, iterate through the array again
// -> If an index is still positive, it means the number i.e. index + 1 is missing
// -> Add that number to the result list
// -> Return the result list


import java.util.*;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> result = new ArrayList<>(); 

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1; 
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if(nums[j] > 0) {
                result.add(j + 1);
            }
        }
        
        return result; 
        
    }
}


// Time Complexity: 
// -> For each number in the array:
//     - Marking the index as negative: O(1)
//     => O(n) * O(1) = O(n)
// -> After marking, iterating through the array again:
//     - Checking if the index is positive: O(1)
//     => O(n) * O(1) = O(n)
// Overall, O(n) + O(n) 
// => O(n)
