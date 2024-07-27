package binarytreelevelordertraversal102;

import util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        TreeNode node = root;
        Map<Integer, List<Integer>> map = new HashMap<>();
        rec(node, map, 0);
        return new ArrayList<>(map.values());
    }

    void rec(TreeNode node, Map<Integer, List<Integer>> map, int level) {
        if (node == null) {
            return;
        }
        int val = node.val;
        if (!map.containsKey(level)) {
            map.put(level, new ArrayList<>());
        }
        map.get(level).add(val);
        rec(node.left, map, level + 1);
        rec(node.right, map, level + 1);
    }
}