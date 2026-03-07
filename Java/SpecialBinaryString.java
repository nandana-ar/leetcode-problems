//-----------------------------PROBLEM 761--------------------------------//
//                        SPECIAL BINARY STRING                           //


// Logic:
// -> Initialize a variable count to keep track of the balance between '1's 
//    and '0's
// -> Create a list to store the special binary substrings
// -> Initialize a variable j to keep track of the starting index of the
//    current special binary substring
// -> Iterate through the string s:
//    - If the current character is '1', increment count
//    - If the current character is '0', decrement count
//    - If count becomes 0, it means we have found a special binary substring
//      - Add the substring from index j to i (inclusive) to the list,
//        with '1' at the start and '0' at the end, and recursively call
//        makeLargestSpecial on the inner substring (excluding the outer '1' and '0')
//      - Update j to the next index after i to start looking for the next
//        special binary substring
// -> After the loop, sort the list of special binary substrings in reverse
//    lexicographical order to get the largest possible arrangement
// -> Join the sorted list into a single string and return it as the result


class Solution {
    public String makeLargestSpecial(String s) {
        int count = 0;
        List<String> list = new LinkedList<>();
        int j = 0;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1') {
                count++; 
            } else {
                count--;
            } 

            if(count == 0){
                list.add('1'+ makeLargestSpecial(s.substring(j + 1,i)) + '0');
                j = i + 1;
            }

        }

        Collections.sort(list,Collections.reverseOrder());
        return String.join("",list);

    }
}


// Time Complexity:
// -> Iterating through the string s: O(n)
// -> Sorting the list of special binary substrings: O(m log m), where m is the
//    number of special binary substrings found
// Overall, O(n) + O(m log m)
// => O(n + m log m)