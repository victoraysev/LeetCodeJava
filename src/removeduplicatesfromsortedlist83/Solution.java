package removeduplicatesfromsortedlist83;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        Set<Integer> set = new HashSet<>();
        while(node != null && node.next != null){
            set.add(node.val);
            var next = node.next;
            while(next != null && set.contains(next.val)){
                next = next.next;
            }
            node.next = next;
            node = node.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode x = new ListNode(1);
        ListNode x2 = new ListNode(1);
        ListNode x3 = new ListNode(1);
        x.next = x2;
        x2.next = x3;
        var head = new Solution().deleteDuplicates(x);
        System.out.println("done");
    }
}