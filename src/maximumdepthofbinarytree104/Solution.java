package maximumdepthofbinarytree104;


import util.TreeNode;

class Solution {
    public int maxDepth(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode node, int i) {
        if(node == null)
            return i;
        var x = helper(node.left, i + 1);
        var y = helper(node.right, i + 1);
        if(x > y)
            return x;
        return y;
    }

}