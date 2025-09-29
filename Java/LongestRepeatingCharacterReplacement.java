//------------------------------PROBLEM 424------------------------------//
//                 LONGEST REPEATING CHARACTER REPLACEMENT               //


// Logic:
// -> Intialise a frequency array to count occurrences of each character
// -> Use two pointers (left and right) to represent the current substring
//    window end indices
// -> Expand the right pointer to include more characters
// -> Update the frequency array and the count of the most frequent character
//    by converting the character to an index (0-25 for A-Z)
// -> If the number of characters that need to be replaced to make all
//    characters in the current window (right - left + 1) the same exceeds k, 
//    shrink the window from the left by moving the left pointer to the right
// -> Update the maximum length of the substring found so far
// -> Continue until the right pointer reaches the end of the string
// -> Return the maximum length found


import java.util.*;

class Solution { 
    public int characterReplacement(String s, int k) {

        int[] freq = new int[26];
        int left = 0, maxCount = 0, maxLength = 0;

        for(int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            freq[c - 'A']++;

            maxCount = Math.max(maxCount, frequency[c - 'A']);

            while((right - left + 1) - maxCount > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
