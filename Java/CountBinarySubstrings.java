//-----------------------------PROBLEM 696--------------------------------//
//                       COUNT BINARY SUBSTRINGS                          //


// Logic:
// -> Create an array groups to store the count of consecutive characters 
//   (0s or 1s) in the string s
// -> Initialize a variable t to keep track of the current group index
// -> Set the first element of groups to 1 since the first character is 
//    the start of the first group (a single 0 or 1 counted once)
// -> Iterate through the string s starting from the second character:
//    - If the current character is different from the previous character,
//      increment t and set groups[t] to 1 to start counting a new group
//    - If the current character is the same as the previous character,
//      increment groups[t] to count the current group
// -> Initialize a variable ans to store the count of valid binary substrings
// -> Iterate through the groups array from index 1 to t:
//    - For each group, add the minimum of the current group count and the 
//      previous group count to ans, since a valid binary substring can only 
//      be formed by pairs of consecutive groups of 0s and 1s
// -> Return ans as the final count of valid binary substrings


class Solution {
    public int countBinarySubstrings(String s) {
        int[] groups = new int[s.length()];
        int t = 0;
        groups[0] = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i-1) != s.charAt(i)) {
                groups[++t] = 1;
            } else {
                groups[t]++;
            }
        }

        int ans = 0;

        for (int i = 1; i <= t; i++) {
            ans += Math.min(groups[i-1], groups[i]);
        }
        
        return ans;
    }
}


// Time Complexity:
// -> Iterating through the string s: O(n)
// -> Iterating through the groups array: O(n)
// Overall, O(n) + O(n) 
// => O(n) 