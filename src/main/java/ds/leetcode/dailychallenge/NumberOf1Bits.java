package ds.leetcode.dailychallenge;

/**
 * https://blog.csdn.net/xiaochunyong/article/details/7748713
 * https://www.coder.work/article/4698580
 */

public class NumberOf1Bits {
    // you need to treat n as an unsigned value
    //right shift to factor out every bit from left to right
    public int hammingWeight(int n) {
        int res = 0;
        int maxBit = 32;
        for (int i = maxBit - 1; i >= 0; i--) {
            int value = (n >> i) & 1;
            if (value == 1) res++;
        }
        return res;
    }
}
