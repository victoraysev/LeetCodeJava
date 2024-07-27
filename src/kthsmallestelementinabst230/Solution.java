package kthsmallestelementinabst230;

import util.TreeNode;

import java.util.PriorityQueue;

public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        TreeNode node = root;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        addHeap(node, queue);
        int i = 1;
        while(i != k){
            queue.remove();
            i++;
        }
         return queue.peek();
    }

    private void addHeap(TreeNode node, PriorityQueue<Integer> queue) {
        if(node == null){
            return;
        }
        queue.add(node.val);
        addHeap(node.right, queue);
        addHeap(node.left, queue);
    }

    public static void main(String[] args) {
//        TreeNode node1 = new TreeNode(5);
//        TreeNode node2 = new TreeNode(3);
//        TreeNode node3 = new TreeNode(6);
//        TreeNode node4 = new TreeNode(2);
//        TreeNode node5 = new TreeNode(4);
//        TreeNode node6 = new TreeNode(1);
//        node1.left = node2;
//        node1.right = node3;
//        node2.left = node4;
//        node2.right = node5;
//        node4.left = node6;
//        var res = new Solution().kthSmallest(node1, 3);
//        System.out.println(res);
        String s = "fasaf";
        System.out.println(s.substring(1, s.length() - 1));
    }
}
