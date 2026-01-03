//----------------------------PROBLEM 1411-------------------------------//
//                  NUMBER OF WAYS TO PAINT NX3 GRID                     //


// Logic:
// -> Define constant for modulo operation, since the number of ways can
//    become very large
// -> Use dynamic programming to keep track of the number of ways to paint
//    the grid row by row
// -> Observe that each row of 3 cells can be painted in only two valid
//    pattern types (due to horizontal constraints):
//    - Two-color pattern: first and third cells have the same color
//    - Three-color pattern: all three cells have different colors
// -> Initialize variable twoColorWays to represent the number of ways to
//    paint the current row using a two-color pattern
//    - For the first row, there are 6 such ways
// -> Initialize variable threeColorWays to represent the number of ways to
//    paint the current row using a three-color pattern
//    - For the first row, there are 6 such ways
// -> For each row from 2 to n:
//    - Store the old values of twoColorWays and threeColorWays, since the
//      new values depend on the previous row
//    - Update twoColorWays:
//      - A two-color row can be formed in 3 ways from a previous two-color row
//      - A two-color row can be formed in 2 ways from a previous three-color row
//      - Multiply and add these values, then apply modulo MOD.
//    - Update threeColorWays:
//      - A three-color row can be formed in 2 ways from a previous two-color row
//      - A three-color row can be formed in 2 ways from a previous three-color row
//      - Multiply and add these values, then apply modulo MOD
// -> Return the sum of twoColorWays and threeColorWays modulo MOD, which
//    represents the total number of valid ways to paint the grid


class Solution {
    private static final int MOD = 1000000007; 

    public int numOfWays(int n) {
         
        if(n == 1) { 
            return 12; 
        }

        long twoColorWays = 6;
        long threeColorWays = 6; 

        for(int i = 2; i <= n; i++) {
            long oldTwo = twoColorWays; 
            long oldThree = threeColorWays; 

            twoColorWays = (oldTwo*3 + oldThree*2) % MOD;
            threeColorWays = (oldTwo*2 + oldThree*2) % MOD;
        }

        return (int)((twoColorWays + threeColorWays) % MOD);

    }
}


// Time Complexity:
// -> Iterating through n rows: O(n)
// -> Addition and multiplication operations: O(1)
// Overall, O(n) * O(1)
// => O(n)