//------------------------------PROBLEM 287------------------------------//
//                       FIND THE DUPLICATE NUMBER                       //


//Logic:
// -> Initialise two pointers, slow and fast, both starting at the first 
//    element of the array
//    Floyd's Cycle-Finding Algorithm (Tortoise and Hare)
// -> Move the slow pointer one step at a time and the fast pointer two
//    steps at a time until they meet
// -> The point where they meet is inside the cycle
// -> To find the entrance to the cycle, reset one pointer to the start
//    of the array and move both pointers one step at a time until
//    they meet again
// -> The meeting point is the duplicate number
// -> Return the duplicate number


import java.util.*; 

class Solution {
    public int findDuplicate(int[] nums) {

        int slow = nums[0]; 
        int fast = nums[0]; 

        do { 
            slow = nums[slow];
            fast = nums[nums[fast]]; 
        } while(slow != fast); 

        slow = nums[0]; 

        while(slow != fast) { 
            slow = nums[slow];
            fast = nums[fast]; 
        }

        return slow; 
        
    }
}


//Time Complexity:
// -> Traversing the array with two pointers takes: O(n) 
// -> Assignment operations and pointer updates: O(1)
// Overall, O(n) * O(1) + O(n) * O(1)
// => O(n)
