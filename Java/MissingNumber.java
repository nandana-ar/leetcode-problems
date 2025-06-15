//------------------------------PROBLEM 268------------------------------//
//                             MISSING NUMBER                            //


//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Attempt #1~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
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


//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Attempt #2~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
// Logic: 
// -> Calculate the expected sum of numbers from 0 to n using formula n*(n+1)/2
// -> Calculate the actual sum of the numbers present in the array
// -> The missing number is the difference between the expected sum and actual sum
// -> Return that difference
// -> If the expected and actual sum are equal, return 0 


class Solution {
    public int missingNumber(int[] nums) {

        int n = nums.length; 

        int expectedSum = n * (n + 1)/2 ;
        int actualSum = 0; 

        for (int i = 0; i < n; i++){
            actualSum += nums[i]; 
        }

        if (actualSum == expectedSum){
            return 0; 
        } else { 
            return expectedSum - actualSum; 
        }
    
    }
}

// Time Complexity: 
// -> Calculating the expected sum: O(1)
// -> Calculating the actual sum using loop: O(n)
// Overall, O(1) + O(n) 
// => O(n)
