//-----------------------------PROBLEM 961-------------------------------//
//                 N-REPEATED ELEMENT IN SIZE 2N ARRAY                   //


//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Attempt #1~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
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


//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Attempt #2~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
// Logic:
// -> Use a hash set to keep track of seen elements
// -> Iterate through the array
// -> For each element, try to add it to the hash set
//  - If the add operation returns false, it means the element is already
//    in the set, so return that element as it is the repeated one
//  - If the add operation returns true, continue to the next element
// -> If no repeated element is found (theoretically shouldn't happen given
//    the problem constraints), return -1


import java.util.HashSet;

class Solution {
    public int repeatedNTimes(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (!seen.add(num)) {
                return num;
            }
        }
        return -1;
    }
}


// Time Complexity:
// -> Each element is processed once: O(n)
// -> Hash set operations (add and lookup): O(1) on average
// Overall, O(n) * O(1)
// => O(n)
//    Better than Hashtable approach due to simpler operations