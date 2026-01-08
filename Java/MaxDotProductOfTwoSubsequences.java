//------------------------------PROBLEM 1458------------------------------//
//                  MAX DOT PRODUCT OF TWO SUBSEQUENCES                   //


// Logic:
// -> Initialise a 2D dynamic programming array to store the maximum dot
//    product values for subsequences ending at different indices
// -> Iterate through each element of nums1 and nums2 using nested loops
//    - Calculate the product of the current elements from nums1 and nums2
//    - Initialize variables: 
//      - pair to store the maximum dot product including the
//        current pair
//      - skipNums1 to store the maximum dot product excluding the current 
//        element from nums1
//      - skipNums2 to store the maximum dot product excluding the current 
//        element from nums2
//   - If both indices are greater than 0, update pair to be the maximum of
//     the current product alone or the current product plus the value from
//     the DP array at the previous indices
//   - If the index of nums1 is greater than 0, set skipNums1 to the value
//     from the DP array at the previous index of nums1 and the current index
//     of nums2
//   - If the index of nums2 is greater than 0, set skipNums2 to the value
//     from the DP array at the current index of nums1 and the previous index
//     of nums2
//   - Update the DP array at the current indices with the maximum of pair,
//     skipNums1, and skipNums2
// -> After filling the DP array, return the value at the bottom-right corner
//    of the DP array, which contains the maximum dot product of two
//    subsequences


class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;

        int[][] dp = new int[length1][length2];

        for(int i = 0; i < length1; i++) {
            for(int j = 0; j < length2; j++) {
                int product = nums1[i] * nums2[j]; 
                int pair = 0; 
                int skipNums1 = 0; 
                int skipNums2 = 0; 

                if(i > 0 && j > 0) {
                    pair = Math.max(product, product + dp[i - 1][j - 1]);
                } else {
                    pair = product; 
                }

                if(i > 0) {
                    skipNums1 = dp[i - 1][j]; 
                } else {
                    skipNums1 = Integer.MIN_VALUE;
                }

                if(j > 0){
                   skipNums2 = dp[i][j - 1]; 
                } else {
                   skipNums2 = Integer.MIN_VALUE; 
                }

                int max1 = Math.max(skipNums1, skipNums2);
                dp[i][j] = Math.max(pair, max1);
            }
        }
        
        return dp[length1 - 1][length2 - 1]; 
    }
}


//Time Complexity:
// -> Iterating through each element of nums1 and nums2: O(n * m)
//    where n is the length of nums1 and m is the length of nums2
// -> Filling each cell in the DP array takes constant time: O(1)
// Overall, O(n * m) * O(1)
// => O(n * m)