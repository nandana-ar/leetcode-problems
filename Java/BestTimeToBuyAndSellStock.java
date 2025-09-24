//------------------------------PROBLEM 121------------------------------//
//                    BEST TIME TO BUY AND SELL STOCK                    //


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