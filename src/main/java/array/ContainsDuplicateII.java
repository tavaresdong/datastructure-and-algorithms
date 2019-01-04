package array;

import java.util.HashMap;

/*
Given an array of integers and an integer k,
find out whether there are two distinct indices i and j
in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

Example
Given nums = [1,2,1], k = 0, return false.
 */
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return false;
        }

        HashMap<Integer, Integer> numMaxIndex = new HashMap<>();
        for (int idx = 0; idx < nums.length; ++idx) {
            int num = nums[idx];
            if (numMaxIndex.containsKey(num)) {
                int preIndex = numMaxIndex.get(num);
                if (idx - preIndex <= k) {
                    return true;
                }
            }

            numMaxIndex.put(num, idx);
        }

        return false;
    }

}
