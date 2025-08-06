#------------------------------PROBLEM 268------------------------------#
#                             MISSING NUMBER                            #


# Logic: 
# -> Calculate the expected sum of numbers from 0 to n using formula 
#    n*(n+1)/2
# -> Calculate the actual sum of the numbers present in the array using 
#    built-in sum function
# -> The missing number is the difference between the expected sum and 
#    actual sum
# -> Return that difference
# -> If the expected and actual sum are equal, return 0 


class Solution(object):
    def missingNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        length = len(nums)
        expectedSum = length * (length + 1)/2
        actualSum = sum(nums)
        
        if actualSum == expectedSum: 
            return 0 
        
        else: 
            return expectedSum - actualSum


# Time Complexity: 
# -> Calculating the expected sum: O(1)
# -> Calculating the actual sum: O(n)
# Overall, O(1) + O(n) 
# => O(n)