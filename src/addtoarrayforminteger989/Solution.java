package addtoarrayforminteger989;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> list = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();

        int carry = 0;

        int i = num.length - 1;
        int j = k;
        while(i >= 0 || j > 0 || carry > 0){
            int sum = carry;
            if(i >= 0){
                sum += num[i];
                i--;
            }
            if(j > 0){
                sum += j % 10;
                j = j / 10;
            }
            carry = sum / 10;
            sum = sum % 10;
            stack.push(sum);
        }
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }

    public static void main(String[] args) {
        var x = new Solution().addToArrayForm(new int[]{1,2,6,3,0,7,1,7,1,9,7,5,6,6,4,4,0,0,6,3}, 516);
        System.out.println(x);
    }
}