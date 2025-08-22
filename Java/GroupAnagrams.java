//-----------------------------PROBLEM 49--------------------------------//
//                           GROUP ANAGRAMS                              //

//Logic:
// -> Create a HashMap to store sorted character strings as keys and
//    lists of anagrams as values
// -> Iterate through the array of strings
// -> For each string, convert it to a character array, sort the array,
//    and convert it back to a string to use as a key
// -> If the key is not already in the HashMap, add it with an empty list
// -> Append the original string to the list corresponding to the key
// -> Return a list of all the values in the HashMap


import java.util.*; 

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String word: strs) {
            char[] chars = word.toCharArray(); 
            Arrays.sort(chars);
            String key = new String(chars);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(word);
        }
        
        return new ArrayList<>(map.values());
    }
}

//Time Complexity:
// -> For each string in the array:
//    - Converting to a character array: O(k), where k is the length of the string
//    - Sorting the character array: O(k log k)
//    - Converting back to a string: O(k)
//    - HashMap operations (containsKey, put, get): O(1)
//   => O(k) + O(k log k) + O(k) + O(1) = O(k log k)
// Overall, O(n) * O(k log k)
// => O(n k log k)
