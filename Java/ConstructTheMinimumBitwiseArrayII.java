//------------------------------PROBLEM 3315-------------------------------//
//                 CONSTRUCT THE MINIMUM BITWISE ARRAY II                  //


// Logic:
// NOTE: Same problem as Construct The Minimum Bitwise Array I with optimized 
//       approach
// -> Intialize an integer array ans of the same size as the input list nums
// -> Iterate through each element num in nums:
//    - Set result to -1 initially
//    - Initialize a variable d to 1 (to represent the current bit position)
//    - While the bitwise AND of num and d is not 0:
//      - Update result to num - d (clearing the current least significant set bit)
//      - Left shift d by 1 to move to the next bit position
//    - Set ans[i] to result
// -> Return the ans array


class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int size = nums.size();
        int[] ans = new int[size]; 

        for (int i = 0; i < size; i++) {
            int num = nums.get(i);

            int res = -1;
            int d = 1;
            while ((num & d) != 0) {
                res = num - d;
                d <<= 1;
            }

            ans[i] = res;
        }

        return ans; 
        
    }
}


// Time Complexity:
// - Iterating through each element in nums: O(n)
// - Checking bits up to the highest set bit in num: O(log m)
// Overall, O(n) * O(log m) where n = size of nums and m = maximum value in nums
// => O(n log m)