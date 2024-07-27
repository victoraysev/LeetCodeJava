package binarytreepreordertraversal144;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(res, root);
        return res;
    }

    private void helper(List<Integer> res, TreeNode node) {
        if(node == null)
            return;
        res.add(node.val);
        helper(res, node.left);
        helper(res, node.right);
    }
    public List<Integer> preorderTraversalRecursive(TreeNode node) {
        List<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        return res;
    }

}