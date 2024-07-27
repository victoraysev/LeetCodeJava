package numberofislands200;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int numIslands(char[][] grid) {
        Set<String> visited = new HashSet<>();
        int ct = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited.contains("" + i + j)) {
                    dfs(grid, i, j, visited);
                    ct++;
                }
            }
        }
        return ct;
    }

    private void dfs(char[][] grid, int i, int j, Set<String> visited) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0' || visited.contains("" + i + j)) {
            return;
        }
        visited.add("" + i + j);
        dfs(grid, i - 1, j, visited);
        dfs(grid, i + 1, j, visited);
        dfs(grid, i, j - 1, visited);
        dfs(grid, i, j + 1, visited);
    }

    public static void main(String[] args) {
        List<List<Character>> list = new ArrayList<>();
        List<Character> characters = new ArrayList<>();
        characters.add('a');
        list.add(characters);
        var x = list.get(0);
        x.add('b');
        System.out.println(x);
        System.out.println(list.get(0));
    }
}