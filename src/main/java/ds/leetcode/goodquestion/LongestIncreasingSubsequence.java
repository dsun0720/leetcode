package ds.leetcode.goodquestion;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        return lengthInRecursion(nums, Integer.MIN_VALUE, 0);
    }

    private int lengthInRecursion(int[] nums, int prev, int index) {
        if (index == nums.length)
            return 0;
        else {
            int a = 0;
            if (prev < nums[index])
                a += 1 + lengthInRecursion(nums, nums[index], index + 1);
            int b = lengthInRecursion(nums, prev, index + 1);
            return Math.max(a, b);
        }
    }

}
