package ds.leetcode.dailychallenge;

import ds.leetcode.dataType.Node;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Map<Node, Node> map = new HashMap<>();
        Node curr = head;
        Node last = null;
        Node newHead = null;
        while (curr != null) {
            Node node = new Node(curr.val);
            map.put(curr, node);
            if (last == null) {
                newHead = node;
            } else {
                last.next = node;
            }
            last = node;
            curr = curr.next;
        }
        for (Node old : map.keySet()) {
            Node nw = map.get(old);
            if (old.random != null) {
                nw.random = map.get(old.random);
            }
        }
        return newHead;
    }


    public static void main(String[] args) {
        Node node1 = new Node(7);
        Node node2 = new Node(12);
        node1.next = node2;
        node2.random = node1;
        Node node3 = new Node(11);
        node2.next = node3;
        Node node4 = new Node(10);
        node3.next = node4;
        node4.random = node3;
        Node node5 = new Node(1);
        node4.next = node5;
        node5.random = node1;
        node3.random = node5;
        new CopyListWithRandomPointer().copyRandomList(node1);
    }


}
