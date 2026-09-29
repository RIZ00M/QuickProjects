class Solution(object):
    def twoSum(self, nums, target):
        lookup = {}

        for i, num in enumerate(nums):
            contains = target - num

            if contains in lookup:
                return [lookup[contains], i]

            lookup[num] = i