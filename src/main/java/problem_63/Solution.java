package main.java.problem_63;

/**
 * @problem-statement : A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 *
 *
 *
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 *
 * Note: m and n will be at most 100.
 *
 * Example 1:
 *
 * Input:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * Output: 2
 * Explanation:
 * There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 */

class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int[][] path = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i=0; i<obstacleGrid.length; i++) {
            if(obstacleGrid[i][0] == 0) {
                path[i][0] = 1;
            } else {
                break;
            }
        }
        for(int j=0; j<obstacleGrid[0].length; j++) {
            if(obstacleGrid[0][j] == 0) {
                path[0][j] = 1;
            } else {
                break;
            }
        }
        for(int i=1; i<obstacleGrid.length; i++) {
            for(int j=1; j<obstacleGrid[0].length; j++) {
                if(obstacleGrid[i][j] == 1) {
                    path[i][j] = 0;
                    continue;
                }
                path[i][j] = path[i-1][j] + path[i][j-1];
            }
        }
        return path[path.length - 1][path[0].length - 1];
    }
}
