package cousinsinbinarytree933;

import util.TreeNode;

import java.util.HashMap;

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
 */
    class Solution {
        public boolean isCousins(TreeNode root, int x, int y) {
            var map = new HashMap<Integer,Integer>();
            var p1 = dfs(root,x, root.val, map);
            var p2 = dfs(root,y, root.val, map);
            return p1 == p2 && map.get(x) != map.get(y);
        }
        /*
            1
        2       3
    null    4  null null
        */
        int dfs(TreeNode node, int val, int parentVal, HashMap<Integer,Integer> map) {
            if(node == null) return -1;
            if(node.val == val) {
                map.put(node.val, parentVal);
                return 0;
            }
            var pathR = dfs(node.right,val, node.val, map);
            var pathL = dfs(node.left,val, node.val, map);
            if(pathR >= 0) return 1 + pathR;
            else if(pathL >= 0) return 1 + pathL;
            else return -1;
        }

    public static void main(String[] args) {
        Integer[] values = {1, 2, 3, 4};
        TreeNode root = new TreeNode(1);
        TreeNode node = root;
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node = node.left;
        node.right = new TreeNode(4);

    }
}