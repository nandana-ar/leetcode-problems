//----------------------------PROBLEM 3713--------------------------------//
//                   LONGEST BALANCED SUBSTRING I                         //


// Logic:
// -> Initialize a variable result to keep track of the longest balanced
//    substring length
// -> Create an array count of size 26 to count the occurrences of each 
//    character
// -> Iterate through the input string:
//   - Fill the count array with zeros for each new starting index i
//   - For each character at index j:
//     - Set a flag variable to true to check if the current substring is 
//       balanced
//     - Set c to the index of the current character in the count array 
//       (s.charAt(j) - 'a')
//     - Increment the count of the current character in the count array
//     - Iterate through the count array:
//       - If any character has a count greater than 0 and is not equal to 
//         the count of the current character, set the flag to false and 
//         break the loop
//     - If the flag is still true after checking all characters, it means
//       the current substring is balanced, so update the result variable with
//       the maximum length found (j - i + 1)
// -> Return the longest balanced substring length found


class Solution {

    public int longestBalanced(String s) {
        int n = s.length();
        int result = 0;
        int[] count = new int[26];

        for (int i = 0; i < n; i++) {
            Arrays.fill(count, 0);
            for (int j = i; j < n; j++) {
                boolean flag = true;
                int c = s.charAt(j) - 'a';
                count[c]++;

                for (int x : count) {
                    if (x > 0 && x != count[c]) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    result = Math.max(result, j - i + 1);
                }
            }
        }
        return result;
    }
}


// Time Complexity:
// -> Iterate through the string: O(n)
// -> For each character, iterate through the remaining characters: O(n)
// -> For each character, check the count array: O(26) => O(K) 
//    where K is the number of characters in the alphabet
// Overall, O(n) * O(n) * O(K)
// => O(n^2 * K)
