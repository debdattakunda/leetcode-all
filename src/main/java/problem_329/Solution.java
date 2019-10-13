package main.java.problem_329;

public class Solution {
    int pathCount = 0;
    int maxCount = 0;
    public int longestIncreasingPath(int[][] matrix) {
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                pathCount = 0;
                this.dfs(matrix, i, j, 1, matrix[i][j]+1);
                maxCount = Math.max(pathCount, maxCount);
            }
        }
        return maxCount;
    }

    private void dfs(int[][] matrix, int i, int j, int count, int prev) {
        if(i<0 || i>matrix.length-1 || j<0 || j>matrix[0].length-1 || matrix[i][j] <= prev) {
            return;
        }
        dfs(matrix, i+1, j, count+1, matrix[i][j]);
        dfs(matrix, i-1, j, count+1, matrix[i][j]);
        dfs(matrix, i, j+1, count+1, matrix[i][j]);
        dfs(matrix, i, j-1, count+1, matrix[i][j]);
        pathCount = Math.max(count, pathCount);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = new int[][]{{9,9,4}, {6,6,8}, {2,1,1}};
        int count = solution.longestIncreasingPath(grid);
        System.out.println(count);
    }
}
