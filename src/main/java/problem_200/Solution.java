package main.java.problem_200;

public class Solution {

    /**
     * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
     * <p>
     * Example 1:
     * <p>
     * Input:
     * 11110
     * 11010
     * 11000
     * 00000
     * <p>
     * Output: 1
     * Example 2:
     * <p>
     * Input:
     * 11000
     * 11000
     * 00100
     * 00011
     * <p>
     * Output: 3
     */

    public int numIslands(char[][] grid) {

        int counter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    counter++;
                    helper(grid, i, j);
                }
            }
        }
        return counter;
    }

    private void helper(char[][] grid, int i, int j) {

        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1 || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        helper(grid, i + 1, j);
        helper(grid, i - 1, j);
        helper(grid, i, j + 1);
        helper(grid, i, j - 1);
    }
}
