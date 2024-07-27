package balancedbinarytree110;

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
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        if(height(root) == -1)
            return false;
        return true;
    }

    private int height(TreeNode node) {
        if(node == null)
            return 0;
        var lR = height(node.left);
        var rR = height(node.right);
        if(lR == -1 || rR == -1)
            return -1;
        if(Math.abs(lR - rR) > 1)
            return -1;
        return Math.max(lR, rR) + 1;
    }
}