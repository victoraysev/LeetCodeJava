package binarytreeinordertraversal94;

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> treeNodeStack = new Stack<>();
        TreeNode node = root;
        while(node != null || !treeNodeStack.isEmpty()){
            while(node != null ){
                treeNodeStack.push(node);
                node = node.left;
            }
            node = treeNodeStack.pop();
            result.add(node.val);
            node = node.right;
        }
        return result;
    }
}