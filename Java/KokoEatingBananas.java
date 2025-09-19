//------------------------------PROBLEM 875------------------------------//
//                          KOKO EATING BANANAS                          //


// Logic: 
// ->  Get the maximum number of bananas in any pile to set the upper
//     limit for Koko's eating speed using getMax function
// ->  Use binary search between 1 and the maximum pile size to find the
//     minimum eating speed that allows Koko to finish all bananas within   
//     h hours
// ->  For each mid value (potential eating speed), calculate the total
//     hours required to eat all bananas using the canEatAll function
// ->  If Koko can eat all bananas within h hours at this speed, try a
//     lower speed by adjusting the right boundary
// ->  If Koko cannot finish in time, increase the speed by adjusting
//     the left boundary
// ->  Continue until the optimal speed is found
// ->  Return the minimum eating speed


import java.util.*;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1; 
        int right = getMax(piles); 
        int result = right; 

        while(left <= right) {
            int mid = left + (right - left) / 2; 
            if(canEatAll(piles, h, mid)) {
                result = mid; 
                right = mid - 1; 
            } else { 
                left = mid + 1; 
            }
        }

        return result; 
    }

    private boolean canEatAll(int[] piles, int h, int speed) {
        long totalTime = 0; 
        for(int pile : piles) {
            totalTime += (pile + speed - 1)/speed; 
        }

        return totalTime <= h; 
    }

    private int getMax(int[] piles) {
        int max = piles[0]; 
        for(int pile : piles) {
            if(pile > max)
                max = pile; 
        }
        
        return max; 
    }
}


// Time Complexity:
// -> Finding the maximum pile size: O(n) 
// -> Binary search over the range of possible speeds: O(log m) 
//    where m is the maximum pile size
// -> Calculating the total hours required for each speed: O(n)
// Overall, O(n) + O(log m) * O(n)
// => O(n log m)