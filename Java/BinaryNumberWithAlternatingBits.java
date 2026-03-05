//-----------------------------PROBLEM 693--------------------------------//
//                    BINARY NUMBER WITH ALTERNATING BITS                 //


// Logic:
// -> Initialize a variable cur to store the current bit (0 or 1) of n, 
//    starting with the least significant bit (n % 2)
// -> Divide n by 2 to shift right and remove the least significant bit
// -> While n is greater than 0:
//    - Check if the current bit (cur) is the same as the next bit (n % 2):
//      - If they are the same, return false since the bits are not alternating
//    - Update cur to the next bit (n % 2)
//    - Divide n by 2 to shift right and continue checking the next bits
// -> If the loop completes without finding any adjacent bits that are the same,
//    return true since all bits are alternating


class Solution {
    public boolean hasAlternatingBits(int n) {
        int cur = n % 2;
        n /= 2;
        while (n > 0) {
            if (cur == n % 2) return false;
            cur = n % 2;
            n /= 2;
        }
        return true;
    }
}


// Time Complexity:
// -> Iterating through the bits of n: O(log n)
// since we are dividing n by 2 in each iteration, the number of iterations is
// proportional to the number of bits in n, which is log base 2 of n.