package nqueens51;

import java.util.ArrayList;
import java.util.List;

class Solution {
    class Queen {
        int x;
        int y;

        public Queen(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void recursive(int n, List<Queen> queenList, List<List<Queen>> result) {
        if (queenList.size() == n) {
            result.add(queenList);
            return;
        }
        int i = queenList.size();
        for (int j = 0; j < n; j++) {
            Queen newQueen = new Queen(i, j);
            boolean attack = false;
            for (Queen currentQueen : queenList) {
                if (currentQueen.x == newQueen.x || currentQueen.y == newQueen.y ||
                        Math.abs(currentQueen.x - newQueen.x)
                                == Math.abs(currentQueen.y - newQueen.y)
                ) {
                    attack = true;
                    break;
                }
            }
            if (!attack) {
                ArrayList<Queen> cloneList = new ArrayList<>(queenList);
                cloneList.add(newQueen);
                recursive(n, cloneList, result);
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<Queen>> result = new ArrayList<>();
        recursive(n, new ArrayList<Queen>(), result);
        List<List<String>> res = new ArrayList<>();
        for(List <Queen>  list : result){
            List<String> rowList = new ArrayList<>();
            for(int i = 0; i < n; i++){
                Queen queen = list.get(i);
                int jQ = queen.y;
                StringBuilder row = new StringBuilder();
                for (int j = 0; j < n; j++){
                    if(j == jQ){
                        row.insert(0,"Q");
                    }
                    else{
                        row.insert(0,".");
                    }
                }
                rowList.add(row.toString());
            }
            res.add(rowList);
        }

        return res;
    }

    public static void main(String[] args) {
        new Solution().solveNQueens(4);
    }
}

/*
list draw(k,n){
    for(j=0 to n)
        if(j == k)
            list.add('Q')
        else
            list.add('.')
}
void setMap(i,k)
    
void rec(list, listResult, map, i, n)
    if(list.size == 0)
        for(k = 0 to n)
            list = draw(k,n)
            setMap(i,k)
*/