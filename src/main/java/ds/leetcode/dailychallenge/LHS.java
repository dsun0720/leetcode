package ds.leetcode.dailychallenge;

/*
We define a harmonious array as an array where the difference between its maximum value and its minimum value is exactly 1.

Given an integer array nums, return the length of its longest harmonious subsequence among all its possible subsequences.

A subsequence of array is a sequence that can be derived from the array by deleting some or no elements without changing the order of the remaining elements.
 */
public class LHS {
    static public int findLHS(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            int gtLen = 0;
            int ltLen = 0;
            int zeroLen = 0;
            for (int j = i + 1; j < nums.length; j++) {
                int next = nums[j];
                int cmp = next - curr;
                if (cmp == 1) gtLen++;
                else if (cmp == -1) ltLen++;
                else if (cmp == 0) zeroLen++;
            }
            int len = Math.max(gtLen, ltLen);
            len = (len > 0) ? len + zeroLen + 1 : 0;
            res = (res > len) ? res : len;
        }
        return res;
    }
}
