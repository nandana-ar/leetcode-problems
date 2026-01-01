//-----------------------------PROBLEM 66--------------------------------//
//                              PLUS ONE                                 //

// Logic:
// -> Start from the last digit of the array
// -> If the digit is less than 9, increment it by 1 and return the array
// -> If the digit is 9, set it to 0 and move to the next digit
// -> If all digits are 9, create a new array with an additional digit set 
//    to 1 at the start and return it


class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            
            digits[i] = 0; 
        }
        
        int[] result = new int[n + 1];
        result[0] = 1;
        
        return result;
    }
}

// Time Complexity:
// -> Iterating through the array once: O(n)
// -> In the worst case, creating a new array: O(n)
// Overall, O(n) + O(n)
// => O(n)