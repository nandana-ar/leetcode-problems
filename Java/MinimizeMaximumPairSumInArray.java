//------------------------------PROBLEM 1877-------------------------------//
//                    MINIMIZE MAXIMUM PAIR SUM IN ARRAY                   //


// Logic:
// -> Sort the input array nums in non-decreasing order
// -> Initialize two pointers, left at the start of the array and right at
//    the end of the array
// -> Initialize a variable maxPairSum to keep track of the maximum pair sum
// -> While left pointer is less than right pointer:
//    - Calculate the sum of the elements at the left and right pointers
//    - Update maxPairSum if the current sum is greater than maxPairSum
//    - Move the left pointer one step to the right
//    - Move the right pointer one step to the left
// -> Return maxPairSum as the result


class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;
        int maxPairSum = 0;

        while (left < right) {
            int sum = nums[left] + nums[right];
            maxPairSum = Math.max(maxPairSum, sum);
            left++;
            right--;
        }

        return maxPairSum;
    }
}


// Time Complexity: 
// -> Sorting the array: O(n log n)
// -> Two-pointer traversal: O(n)
// Overall, O(n log n) * O (n) 
// => O(n log n)
