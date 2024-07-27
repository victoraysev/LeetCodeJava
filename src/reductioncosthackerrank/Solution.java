package reductioncosthackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static int reductionCost(List<Integer > list) {
        int cost = 0;
        Collections.sort(list, (o1, o2) -> Math.abs(o1) - Math.abs(o2));
        int [] arr = new int[] {1,2,3};
        if(list.size() == 1)
            return 0;

        int j = list.size();
        int i = 0;
        while ( j > 1) {
            cost += Math.abs(list.get(i) + list.get(i + 1));
            list.remove(i + 1);
            list.remove(i);
            list.add(cost);
            j = list.size();
            i = 0;
        }
        return cost;
    }

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(4,6,8));
        System.out.println(reductionCost(list));
    }
}
