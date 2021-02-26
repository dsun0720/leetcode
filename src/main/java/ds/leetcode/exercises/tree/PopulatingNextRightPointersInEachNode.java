package ds.leetcode.exercises.tree;

import ds.leetcode.dataType.Node1;

import java.util.ArrayList;
import java.util.List;

public class PopulatingNextRightPointersInEachNode {
    public Node1 connect(Node1 root) {
        if (root == null)
            return null;
        List<Node1> list = new ArrayList<>();
        list.add(root);
        bfsConnect(list);
        return root;
    }

    private void bfsConnect(List<Node1> nodes) {
        if (nodes == null || nodes.isEmpty())
            return;
        Node1 last = nodes.get(0);
        List<Node1> newNodes = new ArrayList<>();
        if (last.left != null) newNodes.add(last.left);
        if (last.right != null) newNodes.add(last.right);
        for (Node1 node : nodes.subList(1, nodes.size())) {
            if (node.left != null) newNodes.add(node.left);
            if (node.right != null) newNodes.add(node.right);
            last.next = node;
            last = node;
        }
        bfsConnect(newNodes);
    }

}
