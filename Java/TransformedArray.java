//------------------------------PROBLEM 3379-------------------------------//  
//                           TRANSFORMED ARRAY                             //

// Logic:
// -> Initialize an array result of the same length as nums to store the 
//    transformed values
// -> Iterate through the array nums using an index i
// -> For each index i:
//    - Calculate the new index as (i + nums[i]) % n
//     (This ensures that the new index wraps around the array if it exceeds
//      the length)
//    - If the new index is negative, add n to it to ensure it falls within
//      the bounds of the array
//    - Assign the value at the new index in nums to the corresponding index 
//      in result
// -> Return the result array as the transformed array


class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int newIndex = (i + nums[i]) % n;

            if (newIndex < 0) {
                newIndex += n;
            }

            result[i] = nums[newIndex];
        }

        return result;
        
    }
}


// Time Complexity:
// -> Iterating through the array: O(n)
// -> Assignment and modulus operations: O(1)
// Overall, O(n) + O(1)
//=> O(n)