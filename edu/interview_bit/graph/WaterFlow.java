package edu.interview_bit.graph;

public class WaterFlow {

    public int solve(int[][] A) {
        int[][] blueSea = new int[A.length][A[0].length];
        int[][] redSea = new int[A.length][A[0].length];

        for (int row = 0; row < A.length; row++) {
            dfs(A, row, 0, Integer.MIN_VALUE, blueSea);
            dfs(A, row, A[0].length - 1, Integer.MIN_VALUE, redSea);
        }

        for (int col = 0; col < A[0].length; col++) {
            dfs(A, 0, col, Integer.MIN_VALUE, blueSea);
            dfs(A, A.length - 1, col, Integer.MIN_VALUE, redSea);
        }

        int count = 0;
        for (int row = 0; row < A.length; row++) {
            for (int col = 0; col < A[0].length; col++) {
                if (blueSea[row][col] == 1 && redSea[row][col] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int[][] graph, int row, int col, int prev, int[][] ocean) {

        if (row < 0 || row >= graph.length || col < 0 || col >= graph[0].length) {
            return;
        }
        if (graph[row][col] < prev || ocean[row][col] == 1) {
            return;
        }

        ocean[row][col] = 1;
        prev = graph[row][col];
        dfs(graph, row - 1, col, prev, ocean);
        dfs(graph, row, col + 1, prev, ocean);
        dfs(graph, row + 1, col, prev, ocean);
        dfs(graph, row, col - 1, prev, ocean);
    }
}
