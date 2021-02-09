package ds.leetcode.exercises.tree;

import ds.leetcode.dataType.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeZigzagLevelOrdeTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) {
            List<TreeNode> list = new ArrayList<>();
            list.add(root);
            zigzagBFS(list, 1, res);
        }
        return res;
    }

    //BFS in recursion
    private void zigzagBFS(List<TreeNode> nodes, int level, List<List<Integer>> printers) {
        if (nodes.isEmpty())
            return;
        List<TreeNode> list = new ArrayList<>();
        List<Integer> printer = new ArrayList<>();
        for (TreeNode node : nodes) {
            if (node.left != null)
                list.add(node.left);
            if (node.right != null)
                list.add(node.right);
        }
        if (level % 2 == 0)
            Collections.reverse(nodes);
        for (TreeNode node : nodes) {
            printer.add(node.val);
        }
        printers.add(printer);
        zigzagBFS(list, level + 1, printers);
    }
}
