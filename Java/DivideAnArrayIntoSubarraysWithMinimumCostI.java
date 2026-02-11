//------------------------------PROBLEM 3010-------------------------------//  
//            DIVIDE AN ARRAY INTO SUBARRAYS WITH MINIMUM COST I           //


// Logic:
// -> Set a variable minTotalCost to store the minimum total cost, 
//    initialized to Integer.MAX_VALUE
// -> Iterate through the array nums using two nested loops to select two 
//    indices i and j such that 1 <= i < j <= n - 1
//    - For each pair of indices (i, j):
//       - Calculate the cost of the three subarrays:
//          - cost1 = nums[0] (cost of the first subarray)
//          - cost2 = nums[i] (cost of the second subarray)
//          - cost3 = nums[j] (cost of the third subarray)
//       - Calculate the total cost as the sum of cost1, cost2, and cost3
//       - If the total cost is less than minTotalCost, update minTotalCost
// -> After iterating through all pairs of indices, return minTotalCost as the
//    minimum total cost to divide the array into three subarrays


class Solution {
    public int minimumCost(int[] nums) {
        int n = nums.length; 
        int minTotalCost = Integer.MAX_VALUE; 
        
        for(int i = 1; i <= n - 2; i++) {
            for(int j = i + 1; j <= n - 1; j++) {
                int cost1 = nums[0];
                int cost2 = nums[i];
                int cost3 = nums[j];

                int totalCost = cost1 + cost2 + cost3; 

                if(totalCost < minTotalCost) {
                    minTotalCost = totalCost; 
                }

            }
        }

        return minTotalCost; 
        
    }
}


//Time Complexity:
// -> The outer loop runs from 1 to n-2: O(n - 2) = O(n)
// -> The inner loop runs from i+1 to n-1: O(n - i - 1) = O(n)
// -> Array access and cost calculation: O(1)
// Overall, O(n) * O(n) * O(1) 
// => O(n^2)