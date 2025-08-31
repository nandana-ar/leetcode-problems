//------------------------------PROBLEM 125------------------------------//
//                           VALID PALINDROME                            //


// Logic:
// -> Remove all non-alphanumeric characters from the string using a 
//    regex (regular expression)
// -> Convert the string to lowercase
// -> Use StringBuilder to create a reversed version of this string
// -> Compare the string with the reversed string
// -> If they are the same, return true (it is a palindrome)
// -> Otherwise, return false


import java.util.*;

class Solution {
    public boolean isPalindrome(String s) {
        String modifiedString = s.replaceAll("[^a-zA-Z0-9]", "");
        modifiedString = modifiedString.toLowerCase();
        StringBuilder sb = new StringBuilder(modifiedString);
        String reversedString = sb.reverse().toString();

        if(modifiedString.equals(reversedString)){
            return true;
        }

        return false; 
    }

}


// Time Complexity:
// -> Removing non-alphanumeric characters: O(n)
// -> Converting to lowercase: O(n)
// -> Reversing the string: O(n)
// -> Comparing the original and reversed strings: O(n)
// Overall, O(n) + O(n) + O(n) + O(n)
// => O(n)