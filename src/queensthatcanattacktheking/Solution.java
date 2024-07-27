package queensthatcanattacktheking;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    public class Queen {
        int x;
        int y;
        int distance = Integer.MAX_VALUE;
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT,
        UP_LEFT,
        UP_RIGHT,
        DOWN_LEFT,
        DOWN_RIGHT
    }

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> res;
        int kingX = king[0];
        int kingY = king[1];
        Map<Direction, Queen> map = new HashMap<>();
        for (int[] queen : queens) {
            int x = queen[0];
            int y = queen[1];
            int distance = Math. abs(x - kingX) + Math.abs(y - kingY);
            if(x != kingX && y == kingY){
                if(x >  kingX){
                    Queen currentQueen = map.getOrDefault(Direction.DOWN, new Queen());
                    if(distance < currentQueen.distance){
                        currentQueen.x = x;
                        currentQueen.y = y;
                        currentQueen.distance = distance;
                        map.put(Direction.DOWN, currentQueen);
                    }
                }
                else{
                    Queen currentQueen = map.getOrDefault(Direction.UP, new Queen());
                    if(distance < currentQueen.distance){
                        currentQueen.x = x;
                        currentQueen.y = y;
                        currentQueen.distance = distance;
                        map.put(Direction.UP, currentQueen);
                    }
                }
            }
            else if (x == kingX && y != kingY) {
                if(y >  kingY){
                    Queen currentQueen = map.getOrDefault(Direction.RIGHT, new Queen());
                    if(distance < currentQueen.distance){
                        currentQueen.x = x;
                        currentQueen.y = y;
                        currentQueen.distance = distance;
                        map.put(Direction.RIGHT, currentQueen);
                    }
                }
                else{
                    Queen currentQueen = map.getOrDefault(Direction.LEFT, new Queen());
                    if(distance < currentQueen.distance){
                        currentQueen.x = x;
                        currentQueen.y = y;
                        currentQueen.distance = distance;
                        map.put(Direction.LEFT, currentQueen);
                    }
                }
            }
            else if(x > kingX && y > kingY && Math.abs(x - kingX) == Math.abs(y - kingY)){
                Queen currentQueen = map.getOrDefault(Direction.DOWN_RIGHT, new Queen());
                if(distance < currentQueen.distance){
                    currentQueen.x = x;
                    currentQueen.y = y;
                    currentQueen.distance = distance;
                    map.put(Direction.DOWN_RIGHT, currentQueen);
                }
            }
            else if(x > kingX && y < kingY && Math.abs(x - kingX) == Math.abs(y - kingY)){
                Queen currentQueen = map.getOrDefault(Direction.DOWN_LEFT, new Queen());
                if(distance < currentQueen.distance){
                    currentQueen.x = x;
                    currentQueen.y = y;
                    currentQueen.distance = distance;
                    map.put(Direction.DOWN_LEFT, currentQueen);
                }
            }
            else if(x < kingX && y > kingY && Math.abs(x - kingX) == Math.abs(y - kingY)){
                Queen currentQueen = map.getOrDefault(Direction.UP_RIGHT, new Queen());
                if(distance < currentQueen.distance){
                    currentQueen.x = x;
                    currentQueen.y = y;
                    currentQueen.distance = distance;
                    map.put(Direction.UP_RIGHT, currentQueen);
                }
            }
            else if(x < kingX && y < kingY && Math.abs(x - kingX) == Math.abs(y - kingY)){
                Queen currentQueen = map.getOrDefault(Direction.UP_LEFT, new Queen());
                if(distance < currentQueen.distance){
                    currentQueen.x = x;
                    currentQueen.y = y;
                    currentQueen.distance = distance;
                    map.put(Direction.UP_LEFT, currentQueen);
                }
            }
        }
        res = map.values().stream()
                .map(value -> List.of(value.x, value.y))
                .collect(Collectors.toList());
        return res;
    }

    public static void main(String[] args) {
        new Solution().queensAttacktheKing(new int[][]{{0, 1}, {1, 1}}, new int[]{0, 0});
    }
}
