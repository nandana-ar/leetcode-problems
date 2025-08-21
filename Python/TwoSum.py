#------------------------------PROBLEM 1--------------------------------#
#                               TWO SUM                                 #


# Logic:
# -> Loop through each element in the list
# -> For each element, loop through the rest of the list to find a pair that sums to the target
# -> If such a pair is found, return their indices
# -> If no such pair exists, return an empty list


class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        
        n = len(nums)

        for i in range(n):
            for j in range(i + 1, n):
                if nums[i] + nums[j] == target:
                    return [i, j]
        
        return []


# Time Complexity:
# -> Outer loop runs n times
# -> Inner loop runs (n - i - 1) times for each i
# [Total comparisons: n + (n-1) + (n-2) + ... + 1 = n(n-1)/2]
# Overall, O(n) * O(n)
# => O(n^2)
