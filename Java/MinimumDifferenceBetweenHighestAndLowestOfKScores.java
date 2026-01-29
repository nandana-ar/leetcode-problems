//------------------------------PROBLEM 1984-------------------------------//  
//        MINIMUM DIFFERENCE BETWEEN HIGHEST AND LOWEST OF K SCORES        //


// Logic:
// -> If k is 1, return 0 as the minimum difference
// -> Sort the input array nums in non-decreasing order
// -> Initialize a variable minDiff to keep track of the minimum difference 
//    and set it to Integer.MAX_VALUE
// -> Iterate through the sorted array from index 0 to length - k:
//    - For each index i, calculate the difference between the element at
//      index i + k - 1 and the element at index i
//    - Update minDiff if the current difference is less than minDiff
// -> Return minDiff as the result


class Solution {
    public int minimumDifference(int[] nums, int k) {
        if(k == 1) {
            return 0;
        }
        
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE; 
        int length = nums.length; 

        for(int i = 0; i + k - 1 < length; i++) {
            int diff = nums[i + k - 1] - nums[i];
            if(minDiff > diff ) {
                minDiff = diff;
            }
        }

        return minDiff; 

    }
}


// Time Complexity:
// -> Sorting the array: O(n log n)
// -> Single pass to find minimum difference: O(n)
// Overall, O(n log n) + O(n)
// => O(n log n)