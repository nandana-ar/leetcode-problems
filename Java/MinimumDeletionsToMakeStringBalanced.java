//------------------------------PROBLEM 1653-------------------------------//  
//               MINIMUM DELETIONS TO MAKE STRING BALANCED                 //


// Logic:
// -> Initialize a variable bCount to count the number of 'b' characters in 
//    the string 
// -> Initialize a variable minDeletions to count the minimum deletions needed
//    to make the string balanced
// -> Iterate through each character in the string:
//    - If the character is 'b', increment bCount
//    - Else if the character is 'a' and bCount is greater than 0, it means 
//      we have an 'a' that comes after a 'b', which violates the balanced 
//      condition so: 
//      1. Delete the 'a' and increment minDeletions by 1
//      or
//      2. Delete all the 'b's counted so far and set minDeletions to bCount
//    - We choose the option that results in fewer deletions
// -> Return minDeletions as the result


class Solution {
    public int minimumDeletions(String s) {
        
        int bCount = 0; 
        int minDeletions = 0; 

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'b') {
                bCount++;
            }

            else if( !(s.charAt(i) == 'a' && bCount == 0)) {
                if(minDeletions + 1 < bCount) {
                    minDeletions++;
                } else {
                    minDeletions = bCount;
                }
            }
        }

        return minDeletions;
        
    }
}


// Time Complexity:
// -> Iterating through the string once: O(n)
// => O(n)