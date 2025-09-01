//------------------------------PROBLEM 125------------------------------//
//                           VALID PALINDROME                            //

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Attempt #1~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
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


//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Attempt #2~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
// Logic:
// -> Use two pointers, one starting at left and the other at right of the string
// -> Move the left pointer to the right until it points to an alphanumeric character
// -> Move the right pointer to the left until it points to an alphanumeric character
// -> Compare the characters at the left and right pointers ignoring the case 
// -> If they are not the same, return false (not a palindrome)
// -> If they are the same, repeat the process for the rest of the characters
// -> If the pointers cross each other, return true (it is a palindrome)


import java.util.*;

class Solution {
    public boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true; 
    }

}


// Time Complexity:
// -> Moving left pointer across non-alphanumeric characters: O(n)
// -> Moving right pointer across non-alphanumeric characters: O(n)
// -> Comparing characters while moving inward: O(n)
// Overall, O(n) + O(n) + O(n)
// => O(n)
