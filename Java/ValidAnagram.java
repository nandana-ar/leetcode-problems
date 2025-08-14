//------------------------------PROBLEM 242------------------------------//
//                             VALID ANAGRAM                             //


//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Attempt #1~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
// Logic: 
// -> Convert both strings to character arrays
// -> If the lengths of the arrays are not equal, return false
// -> Sort both character arrays
// -> Compare the sorted arrays character by character
// -> If not all characters match, return false

import java.util.*;

class Solution {
    public boolean isAnagram(String s, String t) 
    {

        char [] charArrayS = s.toCharArray();
        char [] charArrayT = t.toCharArray();

        if (charArrayS.length != charArrayT.length){
            return false;
        }

        Arrays.sort(charArrayS);
        Arrays.sort(charArrayT);

        for(int i = 0; i < charArrayS.length; i++) {
            if(charArrayS[i] != charArrayT[i]){
                return false; 
            }
        }
    
        return true;

    }

}


// Time Complexity: 
// -> Converting strings to character arrays: O(n)
// -> Sorting both arrays: O(n log n)
// -> Comparing both arrays: O(n)
// Overall, O(n) + O(n log n) + O(n)
// => O(n log n)


//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Attempt #2~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
// Logic: 
// -> If the lengths of the strings are not equal, return false
// -> Create an array to count occurrences of each character in the alphabet
// -> Iterate through both strings, incrementing the count for characters 
//    in the first string and decrementing for the second
// -> In a loop, check for each number in the array from index 0 up to 26:
//    - If any count number in the array is not zero, return false  
//    - If all counts are zero, return true


import java.util.*;

class Solution {
    public boolean isAnagram(String s, String t) 
    {

        if (s.length() != t.length()){
            return false;
        }

        int[] alphabetCount = new int[26];

        // Assuming both strings contain only lowercase letters
        for (int i = 0; i < s.length(); i++) {
            alphabetCount[s.charAt(i) - 'a']++;
            alphabetCount[t.charAt(i) - 'a']--;
        }

        for (int count : alphabetCount) {
            if (count != 0) {
                return false;
            }
        }
    
        return true;

    }

}


// Time Complexity: 
// -> Checking lengths: O(1)
// -> Counting characters in both strings: O(n)
// -> Checking counts: O(1) since the alphabet size is constant (26)
// Overall, O(1) + O(n) + O(1) 
// => O(n)
