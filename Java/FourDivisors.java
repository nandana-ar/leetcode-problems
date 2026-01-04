//----------------------------PROBLEM 1390-------------------------------//
//                           FOUR DIVISORS                               //


// Logic:
// -> Initialize a totalSum variable to accumulate the sum of divisors
// -> Iterate through each number in the input array nums
// -> For each number, initialize divisorCount and divisorSum to track the
//    number of divisors and their sum respectively
// -> Set the initial divisor d to 1
// -> Use a while loop to find divisors from 1 up to the square root of the number
//    - If d divides the number evenly, find the paired divisor
//    - If d and the paired divisor are the same, increment divisorCount by 1
//      and add d to divisorSum
//    - If they are different, increment divisorCount by 2 and add both d and
//      the paired divisor to divisorSum
//    - If at any point divisorCount exceeds 4, break out of the loop early
// -> After checking all potential divisors, if divisorCount equals 4, add
//    divisorSum to totalSum
// -> Return totalSum 


class Solution {
    public int sumFourDivisors(int[] nums) {
        int totalSum = 0; 
        
        for(int i = 0; i < nums.length; i++) {
            int divisorCount = 0; 
            int divisorSum = 0; 
            int d = 1; 

            while(d*d <= nums[i]) {
                if(nums[i] % d == 0) {
                    int pairedDivisor = nums[i]/d; 
                    if(d == pairedDivisor) {
                        divisorCount +=1;
                        divisorSum +=d; 
                    } else {
                        divisorCount +=2; 
                        divisorSum = divisorSum + d + pairedDivisor;
                    }
                }

                if(divisorCount > 4) {
                    break; 
                }

                d+=1; 
            }

            if(divisorCount == 4) {
                totalSum += divisorSum; 
            }

        }

        return totalSum; 

    }
}


// Time Complexity:
// -> Iterating through each number in nums: O(m) where m is the length of nums
// -> For each number, finding divisors up to its square root: O(√n)
// Overall, O(m) * O(√n) where n is the maximum number in nums
//=> O(m√n)