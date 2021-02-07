package ds.leetcode.dailychallenge;

import ds.leetcode.dailychallenge.dataType.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 * https://en.wikipedia.org/wiki/Tree_traversal
 */

public class BTSRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> rightView = new HashMap<>();
        rightTraversal(root, 1, list, rightView);
        return list;
    }

    //depth-first search (DFS) based on pre-order NRL
    private void rightTraversal(TreeNode node, Integer level, List<Integer> list, Map<Integer, Integer> view) {
        if (node != null) {
            if (!view.containsKey(level)) {
                view.put(level, node.val);
                list.add(node.val);
            }
            rightTraversal(node.right, level + 1, list, view);
            rightTraversal(node.left, level + 1, list, view);
        }
    }
}
