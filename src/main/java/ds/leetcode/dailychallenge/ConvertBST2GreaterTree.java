package ds.leetcode.dailychallenge;

import ds.leetcode.dataType.TreeNode;

public class ConvertBST2GreaterTree {

    private Integer sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode node = new TreeNode();
        node.right = convertBST(root.right);
        sum += root.val;
        node.val = sum;
        node.left = convertBST(root.left);
        return node;
    }

}
