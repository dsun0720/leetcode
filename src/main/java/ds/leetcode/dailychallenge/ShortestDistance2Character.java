package ds.leetcode.dailychallenge;

/**
 * Given a string s and a character c that occurs in s,
 * return an array of integers answer where answer.length == s.length and answer[i] is the shortest distance from s[i] to the character c in s.
 * <p>
 * 1 <= s.length <= 104
 * s[i] and c are lowercase English letters.
 * c occurs at least once in s.
 */
public class ShortestDistance2Character {
    public int[] shortestToChar(String s, char c) {
        int[] res = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            res[i] = Integer.MAX_VALUE;
        }
        int startPos = 0;
        for (int i = 0; i < s.length(); i++) {
            if (c == s.charAt(i)) {
                for (int j = startPos; j < s.length(); j++) {
                    res[j] = Math.min(res[j], Math.abs(i - j));
                }
                startPos = i;
            }
        }
        return res;
    }
}
