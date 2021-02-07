package ds.leetcode.dailychallenge;

import ds.leetcode.dailychallenge.dataType.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root of a binary search tree and the lowest and highest boundaries as low and high, trim the tree so that all its elements lies in [low, high].
 * Trimming the tree should not change the relative structure of the elements that will remain in the tree (i.e., any node's descendant should remain a descendant). It can be proven that there is a unique answer.
 * <p>
 * Return the root of the trimmed binary search tree. Note that the root may change depending on the given bounds.
 * referenced by https://en.wikipedia.org/wiki/Introduction_to_Algorithms
 */

public class TrimBST {
    //including a breadth-first search(BFS)
    public TreeNode trimBST(TreeNode root, int low, int high) {
        TreeNode node = null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr.val >= low && curr.val <= high) {
                node = addBST(node, curr.val);
            }
            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
        }
        return node;
    }

    //add an element in a binary tree
    private TreeNode addBST(TreeNode root, int value) {
        TreeNode y = null;
        TreeNode x = root;
        while (x != null) {
            y = x;
            if (x.val > value) x = x.left;
            else x = x.right;
        }
        if (y == null) root = new TreeNode(value);
        else if (y.val > value) y.left = new TreeNode(value);
        else y.right = new TreeNode(value);
        return root;
    }

}