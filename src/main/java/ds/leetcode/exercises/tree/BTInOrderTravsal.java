package ds.leetcode.exercises.tree;

import ds.leetcode.dataType.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//DFS - in order LNR

public class BTInOrderTravsal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            if (!stack.isEmpty()) {
                curr = stack.pop();
                res.add(curr.val);
                curr = curr.right;
            }
        }
        return res;
    }

    public List<Integer> inorderTraversalInRecursion(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        if (curr != null && curr.left != null) res.addAll(inorderTraversalInRecursion(curr.left));
        if (curr != null) res.add(curr.val);
        if (curr != null && curr.right != null) res.addAll(inorderTraversalInRecursion(curr.right));
        return res;
    }

}
