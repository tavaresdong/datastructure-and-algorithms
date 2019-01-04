#pragma once
/*
Given an array nums, write a function to move all 0's to the end of it
while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.

*/

#include <vector>

using namespace std;

class MoveZeroes {
public:
    void moveZeroes(std::vector<int>& nums) {
        if (nums.size() == 0)
        {
            return;
        }

        int pre = 0, idx = 0;
        for (; idx < nums.size(); idx++)
        {
            if (nums[idx] != 0)
            {
                nums[pre] = nums[idx];
                pre++;
            }
        }

        for (; pre < nums.size(); pre++)
        {
            nums[pre] = 0;
        }
    }
};