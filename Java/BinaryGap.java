//-----------------------------PROBLEM 868--------------------------------//
//                             BINARY GAP                                 //


// Logic:
// -> Right shift n to remove trailing zeros (if any) since they don't 
//    contribute to the gap
// -> If n becomes 1 after removing trailing zeros, it means there is only
//    one '1' in the binary representation, so we can return 0 as there are
//    no gaps
// -> Initialize two variables maxGap and gap to keep track of the maximum gap
//    and the current gap respectively
// -> Use a while loop to iterate through the bits of n until n becomes 0:
//    - If the least significant bit of n is 1, it means we have found a '1':
//      - Update maxGap with the maximum of maxGap and gap
//      - Reset gap to 0 since we have found a '1'
//    - If the least significant bit of n is 0, it means we are in a gap:
//      - Increment gap by 1
//    - Right shift n to move to the next bit
// -> After the loop, return maxGap + 1 to account for the last '1' that
//    ended the gap


class Solution {
    public int binaryGap(int n) {
        n >>= Integer.numberOfTrailingZeros(n);
        if (n == 1) return 0;

        int maxGap = 0, gap = 0;

        while (n > 0) {
            if ((n & 1) == 1) {
                maxGap = Math.max(maxGap, gap);
                gap = 0;
            } else
                gap++;
            n >>= 1;
        }

        return maxGap + 1;
    }
}


// Time Complexity:
// -> Right shifting n to remove trailing zeros: O(log n) in the worst case
// -> Iterating through the bits of n: O(log n) since we are right shifting
//    n until it becomes 0
// Overall, O(log n) + O(log n) 
// => O(log n)