package findandreplacepattern890;

import java.util.*;

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list = new ArrayList<>();
        Map<Character,Integer> pMap = new HashMap<>();
        for(char c:pattern.toCharArray()){
            pMap.merge(c,1,Integer::sum);
        }
        List<Integer> x = new ArrayList<>(pMap.values());
        Collections.sort(x);
        for(String word:words){
            Map<Character,Integer> wordsMap = new HashMap<>();
            for(char c:word.toCharArray()){
                wordsMap.merge(c,1,Integer::sum);
            }
            List<Integer> y = new ArrayList<>(wordsMap.values());
            Collections.sort(y);
            if(x.size() != y.size()){
                continue;
            }
            boolean same = true;
            for(int i= 0; i < x.size(); i++){
                if(x.get(i)!=y.get(i)){
                    same = false;
                    break;
                }
            }
            if(same){

                list.add(word);
            }
        }
        return list;

    }

    public static void main(String[] args) {
        var x = new Solution().findAndReplacePattern(new String[]{"abc","deq","mee","aqq","dkd","ccc"}, "abb");
        System.out.println(x);
    }
}