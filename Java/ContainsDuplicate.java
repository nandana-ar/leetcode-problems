//------------------------------PROBLEM 217------------------------------//
//                           CONTAINS DUPLICATE                          //


//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Attempt #1~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
// Logic: 
// -> Sort the array first to avoid nested loops 
// -> Compare each element to its neighbour using a single loop 
// -> Return true if two adjacent elements are the same 


class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums); 
        for (int i = 0; i < nums.length - 1; i++)
        {
            if(nums[i] == nums[i + 1])
            {
                return true; 
            }
        }

        return false; 
    }
}


// Time Complexity: 
// ->  Sorting the array: O(n log n)
// ->  Scanning the array once: O(n)
// Overall, O(n log n) + O (n) 
// => O(n log n) 
//
// Space Complexity:
// -> Variables: O(1)
// -> Sorting using Quick Sort requires recursion stack: O(log n)
// -> No additional data structures
// Overall, O(1) + O(log n)
// -> O(log n) 


//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Attempt #2~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
// Logic:
// -> Create a HashSet to store elements we have already seen
// -> Loop through each element in the array
// -> Check if the current element is already in the HashSet
// -> If it is, a duplicate exists, so return true
// -> If it is not, add it to the HashSet


class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
                if (set.contains(nums[i])) {
                    return true;
                }
                set.add(nums[i]);
        }
        return false;
    }
}


// Time Complexity:
// -> Loop through the array once: O(n)
// -> HashSet.contains(): O(1) average
// -> HashSet.add(): O(1) average
// Overall, O(n) * O(1)
// => O(n)
//
// Space Complexity:
// -> HashSet can store up to n elements: O(n)
// -> Variables: O(1)
// Overall, O(n) + O(1)
// => O(n)
