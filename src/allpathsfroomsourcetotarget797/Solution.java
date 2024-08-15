package allpathsfroomsourcetotarget797;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> r = new ArrayList<>();
        recursive(graph,r,new ArrayList<Integer>(), 0);
        return r;
    }
    void recursive(int[][] graph, List<List<Integer>> r, List<Integer> elem,int cur ){
        elem.add(cur);
        if(elem.size() > 0 && elem.get(elem.size() - 1) == cur ){
            r.add(new ArrayList<Integer>(elem));
            return;
        }
        for(int neighbor: graph[cur] ){
            recursive(graph,r,elem,neighbor);
        }
        elem.remove(elem.size()-1);
    }
}