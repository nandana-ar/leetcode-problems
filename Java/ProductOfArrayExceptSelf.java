//------------------------------PROBLEM 238------------------------------//
//                       PRODUCT OF ARRAY EXCEPT SELF                    //


//Logic:
// -> Create an output array to store the products
// -> Set the first element of the output array to 1
// -> Iterate through the input array from left to right, calculating the 
//    prefix product for each position
// -> Store the prefix product in the output array
// -> Initialize a variable to keep track of the suffix product, starting at 1
// -> Iterate through the input array from right to left, updating the output
//    array by multiplying the current value (prefix product) with the suffix product
// -> Return the output array


import java.util.*;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length; 
        int[] resultArray = new int[length];
        
        resultArray[0] = 1; 

        for(int i = 1; i < length; i++){
            resultArray[i] = resultArray[i - 1] * nums[i - 1];
        }

        int suffix = 1; 
        for(int i = length - 1; i >= 0; i--){
            resultArray[i] = resultArray[i] * suffix; 
            suffix *= nums[i];
        }

        return resultArray; 
        
    }
}


//Time Complexity:
// -> First pass for prefix product (left to right): O(n)
// -> Second pass for suffix product (right to left): O(n)
// Overall, O(n) + O(n)
// => O(n)