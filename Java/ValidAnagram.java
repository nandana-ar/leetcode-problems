//------------------------------PROBLEM 242------------------------------//
//                             VALID ANAGRAM                             //


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
