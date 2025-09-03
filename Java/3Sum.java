//-----------------------------PROBLEM 15--------------------------------//
//                                3SUM                                   //


//Logic:
// -> Sort the input array
// -> Iterate through the array with index i
// -> For each nums[i], use two pointers (left and right) to find pairs
//    such that nums[i] + nums[left] + nums[right] == 0
// -> If the sum of is zero, add the triplet to the result list and move 
//    both pointers inward
// -> If the sum is less than zero, move the left pointer to the right
// -> If the sum is greater than zero, move the right pointer to the left
// -> Skip duplicate elements to avoid repeating triplets in the result


import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] <= 0) {

                if(i == 0 || nums[i] != nums[i - 1]) {

                    int left = i + 1; 
                    int right = nums.length - 1; 

                    while (left < right) {

                        int sum = nums[i] + nums[left] + nums[right];

                        if (sum > 0) {
                            right--; 
                        } else if (sum < 0) {
                            left++;
                        } else {
                            result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                            left++; 
                            right--; 

                            while (left < right && nums[left] == nums[left - 1]) {
                                left ++; 
                            }

                        }
                    }
                }
            }
        }

        return result; 

    }
}


//Time Complexity:
// -> Sorting the array: O(n log n)
// -> Iterating through the array once 
//    - Array is scanned from both ends without resetting
//    - Using two pointers to find pairs: O(n) 
//    => O(n) * O(n) = O(n^2)
// Overall, O(n log n) + O(n^2)
// => O(n^2)
