package ds.leetcode.dailychallenge;

import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctIslands {
    public int numDistinctIslands(int[][] grid) {
        if (grid.length == 0)
            return 0;
        int height = grid.length;
        int width = grid[0].length;
        Set<String> shapes = new HashSet<>();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (grid[y][x] == 1) {
                    StringBuffer shape = new StringBuffer();
                    findIsland(grid, x, y, shape, "S");
                    shapes.add(shape.toString());
                }
            }
        }
        return shapes.size();
    }

    // 深度优先算法(DFS)-从一点出发寻找范围
    private void findIsland(int[][] grid, int x, int y, StringBuffer shape, String dir) {
        int height = grid.length;
        int width = grid[0].length;
        if (x < 0 || x == width || y < 0 || y == height || grid[y][x] != 1) {
            shape.append("0");
            return;
        }
        grid[y][x] = 0;
        shape.append(dir);
        findIsland(grid, x - 1, y, shape, "L");
        findIsland(grid, x + 1, y, shape, "R");
        findIsland(grid, x, y - 1, shape, "U");
        findIsland(grid, x, y + 1, shape, "D");
    }

}

