package main.java.problem_694;

import java.util.ArrayList;
import java.util.List;

/**
 * @problem-statement : Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 *
 * Count the number of distinct islands. An island is considered to be the same as another if and only if one island can be translated (and not rotated or reflected) to equal the other.
 *
 * Example 1:
 * 11000
 * 11000
 * 00011
 * 00011
 * Given the above grid map, return 1.
 *
 * Example 2:
 * 11011
 * 10000
 * 00001
 * 11011
 * Given the above grid map, return 3.
 *
 * Notice that:
 * 11
 * 1
 * and
 *  1
 * 11
 * are considered different island shapes, because we do not consider reflection / rotation.
 * Note: The length of each dimension in the given grid does not exceed 50.
 */

class Solution {

    public int numDistinctIslands(int[][] grid) {

        int count = 0;
        List<String> list = new ArrayList<>();
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    String path = dp(i, j, grid, new StringBuilder()).toString();
                    if(!list.contains(path)) {
                        count++;
                        list.add(path);
                    }
                }
            }
        }
        return count;
    }

    private StringBuilder dp(int i, int j, int[][] grid, StringBuilder sb) {
        if(i<0 || i>grid.length-1 || j<0 || j>grid[0].length-1 || grid[i][j] == 0) {
            return sb;
        }
        grid[i][j] = 0;
        dp(i+1, j, grid, sb.append("D"));
        dp(i-1, j, grid, sb.append("U"));
        dp(i, j+1, grid, sb.append("R"));
        dp(i, j-1, grid, sb.append("L"));
        return sb;
    }
}
