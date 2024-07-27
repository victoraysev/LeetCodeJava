package palindromelinkedlist234;

import util.ListNode;

import java.util.Stack;

public class Solution {
    public boolean isPalindrome(ListNode head) {
        var size = 0;
        var node = head;
        while(node != null){
            size++;
            node = node.next;
        }
        node = head;
        var cnt = size / 2 + 1;
        var i = 0;
        Stack<Integer> s = new Stack<>();
        while(node!= null){
            if(i < cnt){
                s.push(node.val);
            }
            else if ((i == cnt && size % 2 == 0) || i > cnt) {
                var val = s.pop();
                if(node.val != val){
                    return false;
                }
            }
            node = node.next;
            i++;
        }
        return true;
    }
}
