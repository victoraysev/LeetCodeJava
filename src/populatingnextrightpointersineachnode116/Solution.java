package populatingnextrightpointersineachnode116;

import java.util.HashMap;
import java.util.Map;

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node(int i, Node node, Node node1) {
        val = i;
        left = node;
        right = node1;
    }
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};


class Solution {
    public Node connect(Node root) {
        Map<Integer, Node> map = new HashMap<>();
        if(root == null){
            return root;
        }
        recursiveMapCreater(root, map, 1);
        recursiveNextSetter(root.left, map, 2, 2);
        return root;
    }

    private void recursiveNextSetter(Node node, Map<Integer, Node> map, int level, int val) {
        if(node == null){
            return;
        }
        int maxNum = (int) Math.pow(2, level) - 1;
        Node leftNode = node.left;
        while(node != null && val < maxNum){
            node.next = map.get(val + 1);
            node = node.next;
            val++;
        }
        recursiveNextSetter(leftNode, map,  level + 1, val + 1);
    }

    public void recursiveMapCreater(Node node, Map<Integer, Node> map, int i){
        if(node != null){
            map.put(i, node);
            recursiveMapCreater(node.left, map, i * 2);
            recursiveMapCreater(node.right, map, i * 2 + 1);
        }
    }

    public static void main(String[] args) {
        var x = new Node(1, new Node(2, new Node(4), new Node(5)), new Node(3, new Node(6), new Node(7)));
        new Solution().connect(x);
        System.out.println("Hello world!");
    }
}