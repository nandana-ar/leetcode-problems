//------------------------------PROBLEM 739------------------------------//
//                           DAILY TEMPERATURES                          //


// Logic: 
// -> Use a stack to keep track of temperatures and their indices (day number)
// -> Iterate through the temperatures array
// -> For each temperature:
//    - While the stack is not empty and the current temperature is greater
//      than the temperature at the top of the stack
//      -> Pop the top of the stack
//      -> Calculate the difference in indices (days) and store it in the result array
//    - Push the current temperature and its index onto the stack
// -> After processing all temperatures, any indices left in the stack will have 0 days
//   in the result array (already initialized to 0)
// -> Return the result array


import java.util.*;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int[] result = new int[temperatures.length]; 
        Stack<int[]> stack = new Stack<>(); 
    
        for(int i = 0; i < temperatures.length; i++){
           int currentTemp = temperatures[i];
           while(!stack.isEmpty() && currentTemp > stack.peek()[0]){
              int[] pair = stack.pop(); 
              result[pair[1]] = i - pair[1];
           }
           stack.push(new int[]{currentTemp, i});

        }
        
        return result; 
    }
}


// Time Complexity:
// -> Iterating through the temperatures array: O(n)
// -> Each temperature is pushed and popped at most once so while loop has no extra cost
// -> Pushing and popping from the stack: O(n)
// Overall, O(n) + O(n)
// => O(n)