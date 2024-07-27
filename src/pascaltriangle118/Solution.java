package pascaltriangle118;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            if(i == 0){
                res.add(new ArrayList<>(Arrays.asList(1)));
            }
            else if(i == 1){
                res.add(new ArrayList<>(Arrays.asList(1, 1)));
            }
            else{
                List<Integer> arr = new ArrayList<>() ;
                arr.add(1);
                var prevArr = res.get(i - 1);
                var j = 0;
                var k = 1;
                while(k < prevArr.size()){
                    arr.add(prevArr.get(j++) + prevArr.get(k++));
                }
                arr.add(1);
                res.add(arr);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().generate(3);
    }
}
