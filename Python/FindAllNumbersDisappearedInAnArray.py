#------------------------------PROBLEM 448------------------------------#
#              FIND ALL NUMBERS DISAPPEARED IN AN ARRAY                 #


# Logic: 
# -> Create a set containing all expected numbers from 1 to n where n is 
#    the length of the input array 
# -> For each number present in the input array, remove it from the set 
#    of expected numbers
# -> The remaining numbers in the set are the ones that are missing from 
#    the input array
# -> Return the set as a list


class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        
        results_set = set(range(1, len(nums) + 1))
        
        for num in nums:
            results_set.discard(num)

        return list(results_set)


# Time Complexity:
# -> Creating a set of expected numbers: O(n)
# -> For each number in the array:
#     - Discarding elements from the set: O(1)
#     => O(n) * O(1) = O(n)
# Overall, O(n) + O(n)
# => O(n)