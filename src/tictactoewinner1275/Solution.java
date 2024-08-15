package tictactoewinner1275;

class Solution {
    public String tictactoe(int[][] arr) {
        var allFilled = true;
        var moves = new char [3][3];
        boolean x = true;
        for(int i = 0; i< arr.length ; i++){
            var i1 = arr[i][0];
            var j1 = arr[i][1];
            moves[i1][j1] = x?'X':'O';
            x = !x;
        }
        for(int i = 0; i< 3 ; i++){
            for(int j = 0; j < 3; j++){
                var c = moves[i][j];
                if(c == '\u0000'){
                    allFilled = false;
                    continue;
                }
                if(j + 1 < 3 && j + 2 < 3){
                    if(moves[i][j+1] == c && moves[i][j+2] == c){
                        return c == 'X'?"A":"B";
                    }
                }
                 if (i + 1 < 3 && i + 2 < 3){
                    if(moves[i+1][j] == c && moves[i+2][j] == c){
                        return c == 'X'?"A":"B";
                    }
                }
                 if (i + 1 < 3 && j + 1 < 3 && i + 2 < 3 && j + 2 < 3){
                    if(moves[i+1][j+1] == c && moves[i+2][j+2] == c){
                        return c == 'X'?"A":"B";
                    }
                }
                if (i + 1 >= 0 && j - 1 >= 0 && i + 2 >= 0 && j - 2 >= 0){
                    if(moves[i+1][j-1] == c && moves[i+2][j-2] == c){
                        return c == 'X'?"A":"B";
                    }
                }

            }
        }
        if(!allFilled) return "Pending";
        return "Draw";
    }

    public static void main(String[] args) {
        var x = new Solution();
        int[][] arr = {{0,0},{1,1}};
        System.out.println(x.tictactoe(arr));
    }
}