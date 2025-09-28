//------------------------------PROBLEM 3--------------------------------//
//              LONGEST SUBSTRING WITHOUT REPEATING CHARACTERS           //


//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Attempt #1~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
//Logic:
// -> Use a HashSet to track characters in the current substring
// -> Use two pointers (left and right) to represent the current substring
//    window end indices
// -> If the character at the right pointer is not in the HashSet, add it
//    to the HashSet and move the right pointer to the right
// -> If the character at the right pointer is already in the HashSet,
//    remove the character at the left pointer from the HashSet and move
//    the left pointer to the right (shriking the window from the left)
// -> Update the maximum length of the substring found so far
// -> Continue until the right pointer reaches the end of the string
// -> Return the maximum length found


import java.util.*; 

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;

        HashSet<Character> set = new HashSet<>();
        int left = 0, right = 0, maxLength = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            if (!set.contains(c)) {
                set.add(c);
                right++;
                maxLength = Math.max(maxLength, set.size());
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }

        return maxLength;
    }
}


//Time Complexity:
// -> Each character is processed at most twice (once by the right pointer
//    and once by the left pointer): O(2n) => O(n)
// -> HashSet operations (add, remove, contains): O(1)
// Overall, O(n) * O(1)
// => O(n)


//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Attempt #2~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
// Logic:
// -> Use a HashMap to track the last index of each character
// -> Use two pointers (left and right) to represent the current substring
//    window end indices
// -> If the character at the right pointer is already in the HashMap,
//    move the left pointer to the right of the last occurrence of that
//    character if it's greater than the current left pointer
// -> Update the last index of the character at the right pointer in the
//    HashMap
// -> Update the maximum length of the substring found so far
// -> Continue until the right pointer reaches the end of the string
// -> Return the maximum length found


import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        
        for (int right = 0, left = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            if (map.containsKey(currentChar)) {
                left = Math.max(left, map.get(currentChar) + 1);
            }

            map.put(currentChar, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}


//Time Complexity:
// -> Each character is processed once by the right pointer: O(n)
// -> HashMap operations (put, get, contains): O(1)
// Overall, O(n) * O(1)
// => O(n)
