package ds.leetcode.exercises.tree;

import ds.leetcode.dataType.TreeNode;

public class ConstructBTFromPreorderAndInorderTraversal {
    private int index = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0 || preorder.length != inorder.length)
            return null;
        return dfs(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, int[] inorder, int start, int end) {
        if (start > end)
            return null;
        int value = preorder[index++];
        TreeNode node = new TreeNode(value);
        if (start == end)
            return node;
        int inx = search(inorder, value, start, end);
        node.left = dfs(preorder, inorder, start, inx - 1);
        node.right = dfs(preorder, inorder, inx + 1, end);
        return node;
    }

    private int search(int[] as, int value, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (as[i] == value)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        new ConstructBTFromPreorderAndInorderTraversal().buildTree(new int[]{1, 2}, new int[]{2, 1});
    }

}
