#------------------------------PROBLEM 242------------------------------#
#                             VALID ANAGRAM                             #


# Logic:
# -> If the lengths of the strings are not equal, return false
# -> Create an array to count occurrences of each character in the alphabet
# -> Iterate through both strings, incrementing the count for characters 
#    in the first string and decrementing for the second
# -> In a loop, check for each number in the array from index 0 up to 26:
#    - If any count number in the array is not zero, return false  
#    - If all counts are zero, return true


class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """

        if len(s) != len(t):
            return False
        
        length = 26 
        default_value = 0 
        alphabet_count_list = [default_value] * length
        
        for i in range(len(s)):
            alphabet_count_list[ord(s[i]) - ord('a')]+=1
            alphabet_count_list[ord(t[i]) - ord('a')]-=1
        
        for count in alphabet_count_list:
            if count != 0: 
                return False


        return True
    

# Time Complexity: 
# -> Checking lengths: O(1)
# -> Initializing the alphabet count list: O(1)
# -> Iterating and counting characters in both strings: O(n)
# -> Checking counts: O(1) since the alphabet size is constant (26)
# Overall, O(1) + O(n) + O(1) 
# => O(n)