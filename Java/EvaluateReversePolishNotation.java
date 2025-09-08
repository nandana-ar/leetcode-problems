//------------------------------PROBLEM 150------------------------------//
//                    EVALUATE REVERSE POLISH NOTATION                   //


// Logic:
// -> Use a stack to keep track of numbers
// -> Iterate through each token in the input array
// -> If the token is a number, push it onto the stack
// -> If the token is an operator (+, -, *, /), pop the top two numbers
//    from the stack, apply the operator, and push the result back onto
//    the stack
// -> At the end, the stack will contain only the result element
// -> Pop and return this result


import java.util.*;

class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> tokenStack = new Stack<>();

        for(int i = 0; i < tokens.length; i++) {

            try {
                int tokenAsInt = Integer.parseInt(tokens[i]);
                tokenStack.push(tokenAsInt);
            } catch (NumberFormatException e) {
                int num1 = tokenStack.pop(); 
                int num2 = tokenStack.pop(); 
                int result = 0; 

                switch (tokens[i]) {
                    case "+":
                        result = num2 + num1;
                        break;
                    case "-":
                        result = num2 - num1;
                        break;
                    case "*":
                        result = num2 * num1;
                        break;
                    case "/":
                        result = num2 / num1;
                        break;
                }
                
                tokenStack.push(result); 
            }

        }

        return tokenStack.pop(); 

    }
}


// Time Complexity:
// -> Iterating through the tokens array: O(n)
// -> Stack operations (push and pop): O(1)
// Overall, O(1) * n
// => O(n)