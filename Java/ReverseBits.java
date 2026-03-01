//-----------------------------PROBLEM 190--------------------------------//
//                            REVERSE BITS                                //


// Logic:
// -> Initialize a variable result to 0 to store the reversed bits
// -> Loop through each of the 32 bits of the input integer n:
//    - Extract the least significant bit of n using n & 1 and store it in
//      lastBit
//    - Shift result to the left by 1 to make room for the new bit
//    - Use bitwise OR to add lastBit to result
//    - Shift n to the right by 1 to process the next bit in the next iteration
// -> After the loop, result will contain the reversed bits of n, so return it


class Solution {
    public int reverseBits(int n) {
        int result = 0; 

        for(int i = 0; i < 32; i++) {
            int lastBit = n & 1; 
            result = result << 1;
            result = result | lastBit; 
            n = n >> 1; 
        }

        return result;
    }
}


// Time Complexity:
// -> Loop through 32 bits: O(1) 
// since the number of bits is fixed at 32