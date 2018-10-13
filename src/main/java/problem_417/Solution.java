package main.java.problem_417;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {

        List<int[]> result = new ArrayList<>();
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                boolean[][] visited = new boolean[matrix.length][matrix[0].length];
                Sea sea = helper(matrix, visited, matrix[i][j], i, j, new Sea());
                if(sea.pacific && sea.atlantic) {
                    int[] coordinates = new int[]{i, j};
                    result.add(coordinates);
                }
            }
        }
        return result;
    }

    private Sea helper(int[][] matrix, boolean[][] visited, int prev, int i, int j, Sea sea) {

        if(i<0 || j<0) {
            sea.pacific = true;
            return sea;
        }
        if(i>matrix.length-1 || j > matrix[0].length-1) {
            sea.atlantic = true;
            return sea;
        }
        if(prev < matrix[i][j] || visited[i][j]) {
            return sea;
        }
        visited[i][j] = true;
        helper(matrix, visited, matrix[i][j], i+1, j, sea);
        helper(matrix, visited, matrix[i][j], i-1, j, sea);
        helper(matrix, visited, matrix[i][j], i, j+1, sea);
        helper(matrix, visited, matrix[i][j], i, j-1, sea);
        return sea;
    }

    class Sea {
        boolean pacific;
        boolean atlantic;
    }
}
