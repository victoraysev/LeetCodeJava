package binarytreepaths257;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        TreeNode node = root;
        if(node != null) {
            recursive(list, node, "");
        }
        return list;
    }
    void recursive(List<String> list, TreeNode node, String str){
        if(node.left == null && node.right == null){
            list.add(str  + node.val);
        }
        else{
            if(node.left != null){
                recursive(list, node.left, str + node.val + "->");
            }
            if(node.right != null){
                recursive(list, node.right, str + node.val + "->");
            }
        }
    }
}
