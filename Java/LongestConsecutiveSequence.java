//------------------------------PROBLEM 128------------------------------//
//                      LONGEST CONSECUTIVE SEQUENCE                     //


// Logic: 
// -> Use a HashSet to store all numbers (for easier lookup of numbers)
// -> For each number in the array:
//    - Check if it is  the start of a sequence 
//                                           (i.e. num - 1 is not in the set)
//    - If it is the start, keep checking for consecutive numbers 
//                                                (num + 1, num + 2, ...)
//    - Count the length of this sequence
//    - Update the maximum length found so far
// -> Return the maximum length after processing all number sequences


import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxLength = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int current = num;
                int length = 1;

                while (set.contains(current + 1)) {
                    current++;
                    length++;
                }

                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }
}


// Time Complexity:
// -> Inserting all numbers into the set: O(n)
// -> For each number,
//     - Checking for the start of a sequence: O(1)
//     - Counting the length of a sequence: O(k) (where k is the length of the sequence)
//     - In the worst case, k = n 
//     => O(1) + O(n) = O(n) 
// Overall, O(n) + O(n) 
// => O(n)
