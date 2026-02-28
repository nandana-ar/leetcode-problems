//------------------------------PROBLEM 67--------------------------------//
//                              ADD BINARY                                //


// Logic:
// -> Initialize a StringBuilder to build the result string
// -> Initialize pointers i and j to the end of strings a and b respectively,
//    and a variable carry to 0
// -> Loop while there are still digits to process in either string or there
//    is a carry:
//    - Set sum to the current carry
//    - If i is still within the bounds of string a, add the integer value of
//      the current character to sum and decrement i
//    - If j is still within the bounds of string b, add the integer value of
//      the current character to sum and decrement j
//    - Append the least significant bit of sum (sum % 2) to the result
//    - Update carry to be the most significant bit of sum (sum / 2)
// -> After the loop, reverse the result string and return it


class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder(); 

        int i = a.length() - 1;
        int j = b.length() - 1; 
        int carry = 0; 

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry; 
            if (i >= 0) {
                sum += a.charAt(i--) - '0'; 
            }
            if (j >= 0) {
                sum += b.charAt(j--) - '0'; 
            }

            result.append(sum % 2); 
            carry = sum / 2; 
        }

        return result.reverse().toString(); 
        
    }
}


// Time Complexity:
// -> Iterate through the digits of both strings: O(max(m, n)), 
// where m and n are the lengths of strings a and b respectively
