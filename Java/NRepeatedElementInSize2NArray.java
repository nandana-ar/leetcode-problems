//-----------------------------PROBLEM 961-------------------------------//
//                 N-REPEATED ELEMENT IN SIZE 2N ARRAY                   //

// Logic:
// -> Use a hash table to keep track of seen elements
// -> Iterate through the array
// -> For each element, check if it is already in the hash table
//   - If it is, return that element as it is the repeated one
//   - If it is not, add it to the hash table
// -> If no repeated element is found (theoretically shouldn't happen given
//    the problem constraints), return -1


import java.util.Hashtable;

class Solution {
    public int repeatedNTimes(int[] nums) {
        Hashtable<Integer, Boolean> seen = new Hashtable<>();

        for(int num : nums) {
            if (seen.containsKey(num)) {
                return num;
            }
            seen.put(num, true);
        }

        return -1;
    }
}


// Time Complexity:
// -> Each element is processed once: O(n)
// -> Hash table operations (insert and lookup): O(1) on average
// Overall, O(n) * O(1)
// => O(n)