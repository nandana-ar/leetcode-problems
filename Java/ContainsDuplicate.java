//------------------------------PROBLEM 217------------------------------//
//                           CONTAINS DUPLICATE                          //


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
// Overall, O(n log n) * O (n) 
// => O(n log n) 
