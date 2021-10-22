package edu.interview_bit.graph;

import java.util.ArrayList;

public class CaptureRegionsOnBoard {

    public void solve(ArrayList<ArrayList<Character>> a) {
        boolean[][] visited = new boolean[a.size()][a.get(0).size()];

        for (int col = 0; col < a.get(0).size(); col++) {
            if (a.get(0).get(col) == 'O' && !visited[0][col]) {
                dfs(a, visited, 0, col);
            }
            if (a.get(a.size() - 1).get(col) == 'O' && !visited[a.size() - 1][col]) {
                dfs(a, visited, a.size() - 1, col);
            }

        }
        int col = 0;
        int lastCol = a.get(0).size() - 1;
        for (int row = 1; row < a.size() - 1; row++) {
            if (a.get(row).get(col) == 'O' && !visited[row][col]) {
                dfs(a, visited, row, col);
            }
            if (a.get(row).get(lastCol) == 'O' && !visited[row][lastCol]) {
                dfs(a, visited, row, lastCol);
            }

        }

        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                if (!visited[i][j]) {
                    a.get(i).set(j, 'X');
                }
            }
        }
    }

    private void dfs(ArrayList<ArrayList<Character>> a, boolean[][] visited, int row, int col) {
        if (row < 0 || row >= visited.length || col < 0 || col >= visited[0].length
            || visited[row][col] || a.get(row).get(col) == 'X') {
            return;
        }

        visited[row][col] = true;

        dfs(a, visited, row, col - 1);
        dfs(a, visited, row, col + 1);
        dfs(a, visited, row - 1, col);
        dfs(a, visited, row + 1, col);
    }
}
