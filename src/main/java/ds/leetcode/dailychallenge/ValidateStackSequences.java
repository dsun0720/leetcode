package ds.leetcode.dailychallenge;

import java.util.Stack;

public class ValidateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int curr = 0;
        for (int pop : popped) {
            if (!stack.isEmpty() && stack.peek() == pop) {
                stack.pop();
            } else {
                boolean out = false;
                while (!out && curr < pushed.length) {
                    stack.push(pushed[curr]);
                    if (pushed[curr] == pop) {
                        stack.pop();
                        out = true;
                    }
                    curr++;
                }
            }
        }
        return stack.isEmpty() && curr >= pushed.length;
    }
}
