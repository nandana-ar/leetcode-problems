//-----------------------------PROBLEM 762--------------------------------//
//           PRIME NUMBER OF SET BITS IN BINARY REPRESENTATION            //


// Logic:
// -> Initialize a variable prime to keep track of the count of numbers with
//    a prime number of set bits
// -> Iterate through the numbers from left to right:
//    - For each number, initialize a variable count to keep track of the
//      number of set bits (1s) in its binary representation
//    - Use a while loop to count the set bits by repeatedly performing
//      n &= (n - 1) until n becomes 0, incrementing count each time
//    - This works because n & (n - 1) removes the rightmost set bit from n
//    - After counting the set bits, check if count is less than or equal to 1
//      (since 0 and 1 are not prime numbers, we can skip those)
//    - If count is greater than 1, check if it is a prime number by iterating
//      from 2 to the square root of count and checking for divisibility
//    - If count is prime, increment the prime variable
// -> After iterating through all numbers, return the value of prime as the
//    result


class Solution {
    public int countPrimeSetBits(int left, int right) {
        int prime = 0; 

        for (int i = left; i <= right; i++) {
            int count = 0; 

            int n = i; 
            while (n != 0) {
                n &= (n - 1); 
                count++; 
            }
            
            if(count <= 1) {
                continue; 
            }

            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(count); j++) {
                if (count % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                prime++;
            }

        }

        return prime; 
    }
}


// Time Complexity:
// -> Iterating through the numbers from left to right: O(n), where n is the
//    number of integers between left and right
// -> Counting the set bits for each number: O(log n), where n is the value of
//    the number (since the number of bits in n is log n)
// -> Checking if count is prime: O(sqrt(m)), where m is the value of count
// Overall, O(n) * (O(log n) + O(sqrt(m)))
// => O(n log n + n sqrt(m))