package array;

import java.util.HashSet;

public class ContainsDuplicate {
    /**
     * @param nums: the given array
     * @return: if any value appears at least twice in the array
     */
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i)) {
                return true;
            } else {
                set.add(i);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3};
        System.out.println(new ContainsDuplicate().containsDuplicate(nums));

        int[] nums2 = new int[] {1, 1, 2};
        System.out.println(new ContainsDuplicate().containsDuplicate(nums2));
    }
}
