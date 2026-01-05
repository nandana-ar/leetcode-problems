//----------------------------PROBLEM 1975-------------------------------//
//                         MAXIMUM MATRIX SUM                            //


// Logic:
// -> Initialise variables to keep track of total sum, count of negative 
//    numbers, and minimum absolute value (initially set to infinity)
// -> Iterate through each element in the matrix
//    - If the element is negative, increment the negative count
//    - Add the absolute value of the element to the total sum
//    - Update the minimum absolute value if the current absolute value is
//      smaller
// -> After processing all elements, check if the count of negative numbers
//    is odd
//    - If it is even (meaning all negatives can be paired), return the total 
//      sum as is 
//    - If it is odd, subtract twice the minimum absolute value from the total
//      sum (to account for one negative number that cannot be paired)
// -> Return the maximum total sum


class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long totalSum = 0;   
        int negativeCount = 0; 
        long minAbs = Long.MAX_VALUE;

        for (int i = 0; i < matrix.length; i++) { 
            for (int j = 0; j < matrix[i].length; j++) {
                int value = matrix[i][j];

                if(value < 0) {
                    negativeCount+=1; 
                }

                long absValue = Math.abs(value);
                totalSum += absValue;
                minAbs = Math.min(minAbs, absValue);
            } 
        }

        if(negativeCount % 2 != 0) {
            totalSum -= 2 * minAbs;
        }

    return totalSum;

    }
}


// Time Complexity:
// -> Iterating through each element in the matrix: O(n * n)
//    where n is the number of rows and columns in the square matrix
// -> Accessing and updating variables takes constant time: O(1)
// Overall, O(n * n) * O(1)
// => O(n^2)
