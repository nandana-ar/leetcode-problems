//----------------------------PROBLEM 3719--------------------------------//
//                    LONGEST BALANCED SUBARRAY I                         //


// Logic:
// -> Initialize a variable len to keep track of the longest balanced 
//    subarray length
// -> Iterate through the input array:
//    - Create two HashMaps, odd and even, to count the occurrences of odd
//      and even numbers in the current subarray
//    - For each element in the subarray:
//        - Determine if the element is odd or even using bitwise AND operation
//        - Update the corresponding HashMap with the count of the element
//        - If the sizes of the odd and even HashMaps are equal, then
//          the current subarray is balanced so update the len variable with 
//          the maximum length found
// -> Return the longest balanced subarray length found


class Solution {

    public int longestBalanced(int[] nums) {
        int len = 0;

        for (int i = 0; i < nums.length; i++) {
            HashMap<Integer, Integer> odd = new HashMap<>();
            HashMap<Integer, Integer> even = new HashMap<>();

            for (int j = i; j < nums.length; j++) {
                HashMap<Integer, Integer> map = (nums[j] & 1) == 1 ? odd : even;
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

                if (odd.size() == even.size()) {
                    len = Math.max(len, j - i + 1);
                }
            }
        }

        return len;
    }
}


// Time Complexity:
// -> Iterate through the array: O(n)
// -> Creating HashMaps for each subarray: O(n)
// -> For each element, we may iterate through the remaining elements: O(n)
// Overall, O(n) * O(n) 
//=> O(n^2)
