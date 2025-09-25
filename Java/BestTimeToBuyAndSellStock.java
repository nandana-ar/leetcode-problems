//------------------------------PROBLEM 121------------------------------//
//                    BEST TIME TO BUY AND SELL STOCK                    //


//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Attempt #1~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
// Logic: 
// -> Initialize two variables to keep track of the minimum price and the
//    maximum profit
// -> Iterate through the prices array
// -> For each price, update the minimum price if the current price is
//    lower than the minimum price
// -> Calculate the potential profit by subtracting the minimum price
//    from the current price
// -> Update the maximum profit if the potential profit is greater than
//    the maximum profit
// -> Return the maximum profit


import java.util.*;


public class Solution {
    public int maxProfit(int[] prices) {
        
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice){
                minPrice = price; 
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice; 
            }
        }

        return maxProfit;

    }
}


// Time Complexity:
// -> Iterating through the prices array: O(n)
// -> Updating minPrice and maxProfit: O(1)
// Overall, O(n) * O(1)
// => O(n)


//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Attempt #2~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
// Logic:
// -> Use two pointers, left and right, to represent the buying and selling
//    days respectively
// -> Initialise left to 0 (first day) and right to 1 (second day)
// -> Iterate through the prices array with the right pointer
// -> If the price at the left pointer is less than the price at the right
//    pointer, calculate the profit and update the maximum profit if necessary
// -> If the price at the left pointer is greater than or equal to the price
//    at the right pointer, move the left pointer to the right pointer
// -> Move the right pointer to the next day
// -> Return the maximum profit


import java.util.*;

public class Solution {
    public int maxProfit(int[] prices) {
        
        int left = 0, right = 1, maxProfit = 0;

        while(right < prices.length) {
            if(prices[left] < prices[right]) {
                int profit = prices[right] - prices[left];
                maxProfit = Math.max(maxProfit, profit); 
            } else {
                left = right; 
            }
            right+=1; 
        }

        return maxProfit;

    }
}


// Time Complexity:
// -> Iterating through the prices array with the right pointer: O(n)
// -> Updating left pointer and maxProfit: O(1)
// Overall, O(n) * O(1)
// => O(n)