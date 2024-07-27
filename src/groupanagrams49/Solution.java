package groupanagrams49;

import java.util.*;

public class Solution {
    public static void main(String[] args) {

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        Arrays.stream(strs).forEach(str -> {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String orderedStr = new String(arr);
//            List<String> list = map.getOrDefault(orderedStr, new ArrayList<>());
            if (map.containsKey(orderedStr)) {
                map.get(orderedStr).add(str);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                map.put(orderedStr, list);
            }
        });
        return new ArrayList<>(map.values());
    }

}
