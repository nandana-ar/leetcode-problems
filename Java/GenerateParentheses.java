//-----------------------------PROBLEM 22--------------------------------//
//                        GENERATE PARENTHESES                           //


// Logic:
// generateParenthesis= 
// -> Generate all possible combinations of '(' and ')' of length 2*n using 
//    generateAllCombos function
// -> Check each combination for validity using isValid function
// -> If valid, add to valid result list
// -> Return the valid result list
// generateAllCombos=
// -> Recursively build combinations by adding '(' or ')' until the desired 
//    length is reached
// -> Add each complete combination to the result list
// isValid=
// -> Use a stack to track opening parentheses
// -> For each '(', push onto the stack
// -> For each ')', check if the stack is empty (invalid if true), otherwise 
//    pop from the stack
// -> At the end, if the stack is empty, the combination is valid
// -> Return true if valid, false otherwise


import java.util.*; 

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>(); 
        generateAllCombos("", 2*n, result);

        List<String> valid = new ArrayList<>(); 
        for(String s : result) {
            if(isValid(s)) {
                valid.add(s);
            }
        }
        return valid; 
    }

    private void generateAllCombos(String current, int length, List<String> result){
        if(current.length() == length) {
            result.add(current); 
            return; 
        }
        
        generateAllCombos(current + "(", length, result);
        generateAllCombos(current + ")", length, result);
    }

    private boolean isValid(String s){
        Stack<Character> stack = new Stack<>(); 
        for(char c: s.toCharArray()) {
            if(c == '(') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) 
                    return false; 
                stack.pop(); 
            }
        }

        return stack.isEmpty(); 
    }
}


// Time Complexity:
// -> Generating all combinations: O(2^(2n)) 
// -> Validating each combination: O(n) 
// Overall, O(n) * O(2^(2n))
// => O(n * 4^n)
