//------------------------------PROBLEM 3640-------------------------------//  
//                            TRIONIC ARRAY II                             //

// Logic:
// -> Initialize a variable ans to store the maximum sum of a trionic array, 
//    starting with Long.MIN_VALUE
// -> Iterate through the array using an index i
// -> For each index i, 
//    - Initialize an index j to i + 1 and a variable res to store the sum of 
//      the current trionic array
//    - Iterate through the array while the current element is greater than the
//      previous element, incrementing j
//    - Store the index p as j - 1
//      - This marks the end of the first increasing sequence
//    - If p is equal to i, it means there is no increasing sequence, so continue
//      to the next iteration
//    - Add the elements at indices p and p - 1 to res
//    - Iterate through the array while the current element is less than the
//      previous element, adding the current element to res and incrementing j
//    - Store the index q as j - 1
//      - This marks the end of the decreasing sequence
//    - If q is equal to p, q is equal to length - 1, or the next element is not
//      greater than the element at index q, it means there is no valid second
//      increasing sequence, so set i to q and continue to the next iteration
//    - Add the element at index q + 1 to res
//    - Initialize variables maxSum and sum to store the maximum sum of the second
//      increasing sequence and the current sum of the second increasing sequence
//    - Iterate through the array starting from index q + 2 while the current
//      element is greater than the previous element, adding the current element
//      to sum and updating maxSum to the maximum of maxSum and sum
//    - Add maxSum to res
//    - Reset maxSum and sum to store the maximum sum of the first increasing 
//      sequence and the current sum of the first increasing sequence
//    - Iterate through the array starting from index p - 2 down to i while the
//      current element is greater than the previous element, adding the current
//      element to sum and updating maxSum to the maximum of maxSum and sum
//    - Add maxSum to res
//    - Update ans to the maximum of ans and res
//    - Set i to q - 1 to skip the elements of the current trionic array and continue 
//      to the next iteration
// -> Return ans as the maximum sum of a trionic array


class Solution {
    public long maxSumTrionic(int[] nums) {
        int length = nums.length;
        long ans = Long.MIN_VALUE;

        for (int i = 0; i < length; i++) {
            int j = i + 1;
            long res = 0;

            while (j < length && nums[j - 1] < nums[j]) {
                j++;
            }

            int p = j - 1;

            if (p == i) {
                continue;
            }

            res += nums[p] + nums[p - 1];

            while (j < length && nums[j - 1] > nums[j]) {
                res += nums[j];
                j++;
            }

            int q = j - 1;

            if (q == p || q == length - 1 || (j < length && nums[j] <= nums[q])) {
                i = q;
                continue;
            }

            res += nums[q + 1];

            long maxSum = 0;
            long sum = 0;
            for (int k = q + 2; k < length && nums[k] > nums[k - 1]; k++) {
                sum += nums[k];
                maxSum = Math.max(maxSum, sum);
            }
            res += maxSum;

            maxSum = 0;
            sum = 0;
            for (int k = p - 2; k >= i; k--) {
                sum += nums[k];
                maxSum = Math.max(maxSum, sum);
            }
            res += maxSum;

            ans = Math.max(ans, res);
            i = q - 1;
        }

        return ans;
    }
}


// Time Complexity:
// -> The outer loop iterates through the array: O(n)
// -> The inner loops iterate through the array : O(n)
// -> Other operations (assignments, comparisons, etc.): O(1)
// Overall, O(n) * O(n) + O(1)
// => O(n^2)