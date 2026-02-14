//------------------------------PROBLEM 3637-------------------------------//  
//                             TRIONIC ARRAY I                             //

// Logic:
// -> Set the initial index i to 1
// -> Iterate through the array while the current element is greater than
//    the previous element, incrementing i
// -> Store the index p as i - 1 
//    - This marks the end of the first increasing sequence
// -> Continue iterating through the array while the current element is less than
//    the previous element, incrementing i
// -> Store the index q as i - 1
//    - This marks the end of the decreasing sequence
// -> Continue iterating through the array while the current element is greater than
//    the previous element, incrementing i
// -> Store the index flag as i - 1
//    - This marks the end of the second increasing sequence
// -> Check the following conditions to determine if the array is trionic:
//    - p should not be 0 (there should be an increasing sequence at the start)
//    - q should not be equal to p (there should be a decreasing sequence after the
//      first increasing sequence)
//    - flag should be equal to length - 1 (the second increasing sequence should
//      end at the last element of the array)
// -> If all conditions are satisfied, return true
// -> Otherwise, return false


class Solution {
    public boolean isTrionic(int[] nums) {
        int length = nums.length; 
        int i = 1; 

        while(i < length && nums[i - 1] < nums[i]) {
            i += 1; 
        }

        int p = i - 1;

        while (i < length && nums[i - 1] > nums[i]) {
            i += 1; 
        }

        int q = i - 1; 

        while (i < length && nums[i - 1] < nums [i]) {
            i += 1;
        }

        int flag = i - 1; 

        return (p != 0) && (q != p ) && (flag == length - 1 && flag != q); 
        
    }
}


// Time Complexity:
// -> Iterating through the array: O(n)
// -> Assignment and comparison operations: O(1)
// Overall, O(n) + O(1) 
// => O(n)