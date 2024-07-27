package reverselinkedlist206;

import util.ListNode;

public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return null;
        ListNode node = head;
        var res = recursive(node, node.next);
        System.out.println("test");
        return res;
    }
    public ListNode recursive(ListNode node, ListNode nodeNext){
        if(nodeNext == null )
            return node;
        var res = recursive(nodeNext, nodeNext.next);
        nodeNext.next = node;
        node.next = null;
        return res;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l.next = l2;
        l2.next = l3;
        new Solution().reverseList(l);
    }
}
