//------------------------------PROBLEM 3314-------------------------------//
//                  CONSTRUCT THE MINIMUM BITWISE ARRAY I                  //


// Logic:
// -> Initialize an integer array ans of the same size as the input list nums
// -> Iterate through each element num in nums:
//    - Set ans[i] to -1 initially
//    - For each integer x from 0 to num (inclusive):
//      - If the least significant bit (num & 1) is 0, break the inner loop
//      - If the bitwise OR of x and (x + 1) equals num, set ans[i] to x and 
//        break
// -> Return the ans array


class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int size = nums.size();
        int[] ans = new int[size]; 

        for(int i = 0; i < size; i++) {
            ans[i] = -1; 
            int num = nums.get(i);

            for(int x = 0; x <= num; x++) {   
                if((num & 1) == 0) {
                    break; 
                }
                if((x | (x + 1)) == num) {
                    ans[i] = x; 
                    break; 
                }
            }
        }

        return ans; 
        
    }
}


// Time Complexity: 
// - Iterating through each element in nums: O(n)
// - For each element, iterating up to its value in the worst case: O(m)
// Overall, O(n) * O(m) where n = size of nums and m = maximum value in nums
// => O(n * m)