package main.java.problem_542;

public class Solution {
    public int[][] updateMatrix(int[][] matrix) {

        int[][] distance = new int[matrix.length][matrix[0].length];
        if(matrix == null || matrix.length == 0) return distance;
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    boolean[][] visited = new boolean[matrix.length][matrix[0].length];
                    this.dfs(matrix, distance, visited, i, j, 0);
                }
            }
        }
        return distance;
    }

    private void dfs(int[][] matrix, int[][] distance, boolean[][] visited, int i, int j, int count) {

        if(i<0 || i>matrix.length-1 || j<0 || j>matrix[0].length-1 || (visited[i][j] && count>distance[i][j])) {
            return;
        }
        if(matrix[i][j] == 1) {
            if(distance[i][j] == 0) {
                distance[i][j] = count;
            } else {
                distance[i][j] = Math.min(distance[i][j], count);
            }
        }
        visited[i][j]=true;
        dfs(matrix, distance, visited, i+1, j, count+1);
        dfs(matrix, distance, visited, i-1, j, count+1);
        dfs(matrix, distance, visited, i, j+1, count+1);
        dfs(matrix, distance, visited, i, j-1, count+1);
    }
}
