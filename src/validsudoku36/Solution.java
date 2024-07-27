package validsudoku36;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> columns = new HashMap<>();
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> boxes = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char character = board[i][j];
                if (character == '.') {
                    continue;
                }
                if (!rows.containsKey(i)) {
                    rows.put(i, new HashSet<>());
                }
                if (!columns.containsKey(j)) {
                    columns.put(j, new HashSet<>());
                }
                if (!boxes.containsKey(i / 3 * 3 + j / 3)) {
                    boxes.put(i / 3  * 3 + j / 3, new HashSet<>());
                }
                if (!rows.get(i).add(character) || !columns.get(j).add(character) || !boxes.get(i / 3 * 3 + j / 3).add(character)) {
                    return false;
                }

            }
        }
        return true;
    }

    public static void main(String[] args) {
        Set<Character> set = new HashSet<>();
        var x = set.add('a');
        var y = set.add('a');
        System.out.println(x);
        System.out.println(y);
    }
}
