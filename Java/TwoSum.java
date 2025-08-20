//------------------------------PROBLEM 1--------------------------------//
//                               TWO SUM                                 //


//Logic: 
// -> Create a HashMap to store the numbers and their indices
// -> Iterate through the array of numbers
// -> For each number, calculate its complement (target - current number)
// -> If the complement exists in the HashMap, return the indices
// -> If not, add the current number and its index to the HashMap
// -> If no solution is found, return an empty array


import java.util.HashMap;

class Solution {

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>(); 
        
        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];
            
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            
            map.put(nums[i], i);
        }
        
        return new int[] {};
    }
}


//Time Complexity:
// -> Iterating through the array: O(n)
// -> HashMap operations (put and get): O(1)
// Overall, O(1) * n
// => O(n)
