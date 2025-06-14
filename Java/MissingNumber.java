//------------------------------PROBLEM 268------------------------------//
//                             MISSING NUMBER                            //


// Logic: 
// -> Create a set
// -> Add elements from the array to the set using a single loop 
// -> In another loop, check for each number from 0 up to and
//    including the length of the array:
//    - If the number is not in the set, return it (that’s the missing 
//    number)
//    - If all numbers are present, return the last number


import java.util.*; 

class Solution {
    public int missingNumber(int[] nums) {

        Set<Integer> numsSet = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            numsSet.add(nums[i]);
        }

        for (int j = 0; j <= nums.length; j++){
            if(numsSet.contains(j) == false) {
                return j; 
            }
        }
        
        return nums.length; 
    }
}


// Time Complexity: 
// -> Building the set: O(n)
// -> Checking numbers from 0 to n: O(n)
// => O(n)
