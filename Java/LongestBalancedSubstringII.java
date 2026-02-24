//----------------------------PROBLEM 3714--------------------------------//
//                   LONGEST BALANCED SUBSTRING II                        //


// Logic:
// Note: This is the modified version of the previous problem, where we need 
// to find the longest balanced substring that can contain at most 3 distinct 
// characters
// -> cal1 - find the longest balanced substring that contains only one 
//    distinct character
//    - Set a variable res to keep track of the longest balanced substring length
//    - Iterate through the input string using a while loop:
//      - Set a variable j to the next index after i
//      - While j is within the bounds of the string and the character at index j
//        is the same as the character at index i, increment j
//      - Update the res variable with the maximum length found between current 
//        res and the length of the balanced substring (j - i)
//      - Move the index i to j to continue searching for the next balanced
//        substring
//    - Return res as the longest balanced substring length found that contains 
//      only one distinct character
// -> cal2 - find the longest balanced substring that contains exactly two
//    distinct characters
//    - Set a variable res to keep track of the longest balanced substring length
//    - Iterate through the input string using a while loop:
//      - While the current character at index i is not equal to either of the
//        two distinct characters (a and b), increment i to skip non-relevant
//        characters
//      - Create a HashMap pos to store the positions of the differences in counts
//      - Initialize the pos HashMap with a key of 0 and a value of i - 1 to
//        represent the starting position before the current substring
//      - Set a variable d to keep track of the difference in counts between the
//        two distinct characters
//      - While the current character at index i is either a or b, update the
//        difference d based on whether the character is a or b (increment for a,
//        decrement for b)
//        - Check if the current difference d has been seen before in the pos
//          HashMap:
//          - If it has been seen, update the res variable with the maximum length
//            found between current res and the length of the balanced substring
//            (i - prev), where prev is the previous index stored in pos for the
//            current difference d
//          - If it has not been seen, store the current index i in the pos Hash
//            Map with the current difference d as the key
//        - Increment i to continue searching for the next character in the substring
//    - Return res as the longest balanced substring length found that contains
//      exactly two distinct characters
// -> cal3 - find the longest balanced substring that contains exactly three 
//    distinct characters
//    - Create a HashMap pos to store the positions of the differences in counts of the
//      three distinct characters, where the key is a long value that encodes the
//      differences in counts and the value is the index of the last occurrence of
//      that difference
//    - Initialize the pos HashMap with a key of f(0, 0) and a value of -1 to
//      represent the starting position before the current substring
//    - Create an array cnt of size 3 to count the occurrences of the three
//      distinct characters
//    - Set a variable res to keep track of the longest balanced substring length
//    - Iterate through the input string:
//      - For each character at index i, increment the count of that character in
//        the cnt array
//      - Calculate the differences in counts between the three distinct characters:
//        - x is the difference between the count of the first character and the
//          second character (cnt[0] - cnt[1])
//        - y is the difference between the count of the second character and the
//          third character (cnt[1] - cnt[2])
//      - Encode the differences x and y into a single long value k using the
//        helper function f(x, y)
//      - Check if the encoded value k has been seen before in the pos HashMap:
//        - If it has been seen, update the res variable with the maximum length
//          found between current res and the length of the balanced substring (i - prev),
//          where prev is the previous index stored in pos for the current encoded
//          value k
//        - If it has not been seen, store the current index i in the pos HashMap
//          with the current encoded value k as the key
//    - Return res as the longest balanced substring length found that contains
//      exactly three distinct characters
// -> f - a helper function to encode the difference in counts of characters into a
//    single long value for use in a HashMap to track the positions of these
//    differences
//    - Return a long value that combines the differences in counts of characters 
//      x and y, where x is the difference between the count of the first character 
//      and the second character, and y is the difference between the count of 
//      the second character and the third character
//    - The encoding is done by shifting x to the left by 20 bits and combining it with 
//      y using a bitwise OR operation
//    - This allows us to store both differences in a single long value for 
//      efficient lookup in a HashMap
// -> longestBalanced: 
//     - Convert the input string s into a character array cs for easier access
//     - Call the calc1 function to find the longest balanced substring that contains
//       only one distinct character and store the result in variable x
//     - Call the calc2 function three times to find the longest balanced substring
//       that contains exactly two distinct characters (a and b, b and c, a and c)
//       and store the maximum result in variable y
//     - Call the calc3 function to find the longest balanced substring that contains
//       exactly three distinct characters and store the result in variable z
//     - Return the maximum value among x, y, and z as the final result for the
//       longest balanced substring length found in the input string s


class Solution {
    public int longestBalanced(String s) {
        char[] cs = s.toCharArray();
        int x = calc1(cs);
        int y = Math.max(calc2(cs, 'a', 'b'), 
                Math.max(calc2(cs, 'b', 'c'), 
                         calc2(cs, 'a', 'c')));
        int z = calc3(cs);
        return Math.max(x, Math.max(y, z));
    }

    private int calc1(char[] s) {
        int res = 0;
        int i = 0, n = s.length;
        while (i < n) {
            int j = i + 1;
            while (j < n && s[j] == s[i]) {
                j++;
            }
            res = Math.max(res, j - i);
            i = j;
        }
        return res;
    }

    private int calc2(char[] s, char a, char b) {
        int res = 0;
        int i = 0, n = s.length;
        while (i < n) {
            while (i < n && s[i] != a && s[i] != b) {
                i++;
            }
            Map<Integer, Integer> pos = new HashMap<>();
            pos.put(0, i - 1);
            int d = 0;
            while (i < n && (s[i] == a || s[i] == b)) {
                d += (s[i] == a) ? 1 : -1;
                Integer prev = pos.get(d);
                if (prev != null) {
                    res = Math.max(res, i - prev);
                } else {
                    pos.put(d, i);
                }
                i++;
            }
        }
        return res;
    }

    private int calc3(char[] s) {
        Map<Long, Integer> pos = new HashMap<>();
        pos.put(f(0, 0), -1);

        int[] cnt = new int[3];
        int res = 0;

        for (int i = 0; i < s.length; i++) {
            char c = s[i];
            ++cnt[c - 'a'];
            int x = cnt[0] - cnt[1];
            int y = cnt[1] - cnt[2];
            long k = f(x, y);

            Integer prev = pos.get(k);
            if (prev != null) {
                res = Math.max(res, i - prev);
            } else {
                pos.put(k, i);
            }
        }
        return res;
    }

    private long f(int x, int y) {
        return (x + 100000) << 20 | (y + 100000);
    }
}


// Time Complexity:
// -> calc1: O(n)
// -> calc2: O(n)
// -> calc3: O(n)
// Overall, O(n) + O(n) + O(n) 
// => O(n)