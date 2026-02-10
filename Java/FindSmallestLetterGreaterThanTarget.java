//------------------------------PROBLEM 744--------------------------------//  
//                FIND SMALLEST LETTER GREATER THAN TARGET                 //


// Logic:
// -> Iterate through the letters array
// -> Check if the current letter is greater than the target letter
//    - If it is, return the current letter
// -> If we finish iterating through the array without finding a letter greater 
//    than the target, return the first letter in the array (smallest letter)


class Solution {
    public char nextGreatestLetter(char[] letters, char target) {

       for (int i = 0; i < letters.length; i++) {
            if (letters[i] > target) {
                return letters[i];
            }
        }
        
        return letters[0];
        
    }
}


//Time Complexity:
// -> Iterating through the letters array: O(n)
// => O(n)