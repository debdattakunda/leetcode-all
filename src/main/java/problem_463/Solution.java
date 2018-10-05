package main.java.problem_463;

/**
 *
 * @problem-statement : You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
 *
 * Example:
 *
 * [[0,1,0,0],
 *  [1,1,1,0],
 *  [0,1,0,0],
 *  [1,1,0,0]]
 *
 * Answer: 16
 * Explanation: The perimeter is the 16 yellow stripes in the image below:
 */

class Solution {

    int peremiter = 0;
    public int islandPerimeter(int[][] grid) {
        boolean[][] visit = new boolean[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    dfs(i, j, grid, visit);
                }
            }
        }
        return peremiter;
    }

    private void dfs(int i, int j, int[][] grid, boolean[][] visit) {

        if(i<0 || i>grid.length-1 || j<0 || j>grid[0].length-1) {
            peremiter++;
            return;
        }
        if(grid[i][j] == 0) {
            if(!visit[i][j]) {
                peremiter++;
            }
            return;
        }
        grid[i][j] = 0;
        visit[i][j] = true;
        dfs(i+1, j, grid, visit);
        dfs(i-1, j, grid, visit);
        dfs(i, j+1, grid, visit);
        dfs(i, j-1, grid, visit);
    }
}
