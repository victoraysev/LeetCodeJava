package addtwonumbers2;


import util.ListNode;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode node = head;
        ListNode prev = null;
        var carry = 0;
        while (l1 != null || l2 != null) {
            var valL1 = -1;
            var valL2 = -1;
            if(l1 == null)
                valL1 = 0;
            else
                valL1 = l1.val;
            if(l2 == null)
                valL2 = 0;
            else
                valL2 = l2.val;
            var val = valL1 + valL2 + carry;
            if (val >= 10)
                carry = 1;
            else
                carry = 0;
            node.val = val % 10;
            if (prev != null)
                prev.next = node;
            prev = node;
            node = new ListNode();
            if(l1!= null)
                l1 = l1.next;
            if(l2!= null)
                l2 = l2.next;
        }
        if (carry == 1) {
            node.val = 1;
            prev.next = node;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode();
        ListNode l11 = new ListNode();
        ListNode l12 = new ListNode();
        ListNode l2 = new ListNode();
        ListNode l21 = new ListNode();
        ListNode l22 = new ListNode();
        l1.val = 2;
        l11.val = 4;
        l12.val = 3;
        l2.val = 5;
        l21.val = 6;
        l22.val = 4;
        l1.next = l11;
        l11.next = l12;
        l2.next = l21;
        l21.next = l22;
        var x = new Solution().addTwoNumbers(l1,l2);
        System.out.println("x");
    }
}
