//------------------------------PROBLEM 712-------------------------------//
//                MINIMUM ASCII DELETE SUM FOR TWO STRINGS                //


// Logic:  
// -> Helper function sumAscii:
//    - Convert each character in the string to its ASCII value
//    - Return the total sum of these values
// -> Helper function longestCommonSubsequence:
//    - Create a 2D array dp to store the maximum ASCII sum of common
//      subsequences up to each index of s1 and s2
//    - Iterate through each character of s1 and s2
//    - If characters match, add the ASCII value of the character to the
//      value from the previous indices in dp
//    - If characters do not match, take the maximum value from either
//      excluding the current character from s1 or s2
//    - After filling the dp array, reconstruct the longest common subsequence
//      by backtracking through the dp array using StringBuilder
//      - If characters match, append the character to the lcs and move to 
//        the previous indices
//      - If characters do not match, move in the direction of the larger
//        value in dp
//    - Backtracking builds the lcs in reverse order, so reverse it before 
//      returning
// -> Main function minimumDeleteSum:
//    - Calculate the total ASCII sum of both string 1 and string 2 using 
//      sumAscii
//    - Find the longest common subsequence of the two strings using 
//      longestCommonSubsequence
//    - Calculate the ASCII sum of the longest common subsequence
//    - The minimum delete sum is: 
//     (sum of all characters in s1 - sum of lcs) + 
//     (sum of all characters in s2 - sum of lcs)



class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int sumAsciiS1 = sumAscii(s1);
        int sumAsciiS2 = sumAscii(s2);
        String subSeq = longestCommonSubsequence(s1, s2); 
        int sumAsciiSubSeq = sumAscii(subSeq);

        return (sumAsciiS1 - sumAsciiSubSeq) + (sumAsciiS2 - sumAsciiSubSeq);
    }

    public static int sumAscii(String s) {
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i); 
        }

        return sum;
    }

    public String longestCommonSubsequence(String s1, String s2) {
        int n = s1.length(); 
        int m = s2.length(); 

        int[][] dp = new int[n + 1][m + 1]; 

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + s1.charAt(i - 1); 
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); 
                }
            }
        }

        StringBuilder lcs = new StringBuilder(); 
        int i = n; 
        int j = m; 

        while(i > 0 && j > 0) {
            if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs.append(s1.charAt(i - 1)); 
                i--; 
                j--; 
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--; 
            } else {
                j--;
            }
        }

        return lcs.reverse().toString(); 
    }
}


// Time Complexity: