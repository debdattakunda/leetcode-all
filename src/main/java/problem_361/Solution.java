package main.java.problem_361;

/**
 * @problem-statement : Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum enemies you can kill using one bomb.
 * The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.
 * Note: You can only put the bomb at an empty cell.
 *
 * Example:
 *
 * Input: [["0","E","0","0"],["E","0","W","E"],["0","E","0","0"]]
 * Output: 3
 * Explanation: For the given grid,
 *
 * 0 E 0 0
 * E 0 W E
 * 0 E 0 0
 *
 * Placing a bomb at (1,1) kills 3 enemies.
 */

public class Solution {

    int count = 0;
    int maxCount = 0;
    public int maxKilledEnemies(char[][] grid) {
        boolean[][] visited = null;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == '0') {
                    this.count = 0;
                    visited = new boolean[grid.length][grid[0].length];
                    int temp = bombEnemy(grid, i, j, i, j, visited);
                    if(temp > maxCount) {
                        this.maxCount = temp;
                    }
                }
            }
        }
        return maxCount;
    }

    private int bombEnemy(char[][] grid, int i, int j, int p, int q, boolean[][] visited) {

        if(i<0 || i>grid.length-1 || j<0 || j>grid[0].length-1 || grid[i][j] == 'W') {
            return count;
        }
        if((i > p && j > q) || (i < p && j < q) || (i < p && j > q) || (i > p && j < q)) {
            return count;
        }
        if(visited[i][j]) {
            return count;
        }
        if(grid[i][j] == 'E') {
            count++;
        }
        visited[i][j] = true;
        bombEnemy(grid, i+1, j, p, q, visited);
        bombEnemy(grid, i-1, j, p, q, visited);
        bombEnemy(grid, i, j+1, p, q, visited);
        bombEnemy(grid, i, j-1, p, q, visited);
        return count;
    }
}
