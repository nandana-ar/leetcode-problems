#------------------------------PROBLEM 217------------------------------#
#                           CONTAINS DUPLICATE                          #


# Logic: 
# -> Create set of seen elements  
# -> Loop through and see if an element is already present in the set 
# -> If it is already present, return true 
# -> Else add the element to the set 
# -> If no duplicates present, return false


class Solution(object):
    def containsDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        seen = set()
        for num in nums:
            if num in seen: 
                return True
            seen.add(num)
        return False 
        


# Time Complexity: 
# ->  Checking if an element is already present in the seen set: O(1)
# ->  Adding elements if not already present in the set: O(1) 
# ->  Repeat either of the above for n elements: O(1) * n = O(n) 
# => O(n) 
