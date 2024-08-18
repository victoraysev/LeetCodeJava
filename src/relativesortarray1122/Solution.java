package relativesortarray1122;

import java.util.TreeMap;

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        var treeMap = new TreeMap<Integer,Integer>();
        for(var num:arr1){
            treeMap.merge(num,1,Integer::sum);
        }
        var n = arr1.length;
        var m = arr2.length;
        var r = new int[n];
        /*
        for(var key:treeMap.keySet()){
            System.out.println(key);
        }
        */
        var i = 0;
        var j = 0;
        while(j < m){
            var repeat = treeMap.get(arr2[j]);
            while(repeat > 0){
                r[i++] = arr2[j];
                repeat--;
            }
            treeMap.remove(arr2[j]);
            j++;
        }
        for(var key:treeMap.keySet()){
            var repeat = treeMap.get(key);
            while(repeat > 0){
                r[i++] = key;
                repeat--;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        new Solution().relativeSortArray(new int[]{2,3,1,3,2,4,6,7,9,2,19},new int[]{2,1,4,3,9,6});
    }
}