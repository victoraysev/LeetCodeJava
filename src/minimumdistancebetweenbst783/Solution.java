package minimumdistancebetweenbst783;

import util.TreeNode;

import java.util.ArrayList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 90
 69      null
 49      89
 null 52
 */
class Solution {
    public int minDiffInBST(TreeNode root) {
        var min = Integer.MAX_VALUE;
        var queue = new ArrayList<Integer>();
        //                    1,3,2,6,4
        inOrder(root,queue);
        for(int i = 0; i < queue.size(); i++){
            var val = queue.get(i);
            if(i + 1 < queue.size()){
                var val2 = queue.get(i+1);
                min = Math.min(min,Math.abs(val-val2));
            }
        }
        return min;
    }
    void inOrder(TreeNode node, ArrayList<Integer> queue){
        if(node == null) return;
        if(node.left != null){
            inOrder(node.left,queue);
        }
        queue.add(node.val);
        if(node.right != null){
            inOrder(node.right,queue);
        }
    }
//
    public static void main(String[] args) {
        Integer[] values = {90, 69, null, 49, 89, null, 52};
        TreeNode root = null;

        // Insert each value into the BST
        for (Integer value : values) {
            if (value != null) {
                root = insertIntoBST(root, value);
            }
        }

        // Print the in-order traversal of the BST
        System.out.println("Inorder traversal of the BST:");
        var x = new Solution().minDiffInBST(root);
        System.out.println(x);
    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    public static void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }}