package edu.interview_bit.backtracking;

import java.util.ArrayList;

/*
 * https://www.youtube.com/watch?v=wvaYrOp94k0&t=35s
 * */
public class PalindromePartitioning {

    boolean[][] mat;

    public ArrayList<ArrayList<String>> partition(String input) {
        initMat(input);
        ArrayList<ArrayList<String>> output = new ArrayList<>();
        generateAll(input, output, new ArrayList<>(), 0);
        return output;
    }

    public void generateAll(String input, ArrayList<ArrayList<String>> output,
        ArrayList<String> temp, int index) {
        if (index == input.length()) {
            output.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < input.length(); i++) {
            if (mat[index][i]) {
                String s = input.substring(index, i + 1);
                temp.add(s);
                generateAll(input, output, temp, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public void initMat(String input) {
        mat = new boolean[input.length()][input.length()];
        for (int g = 0; g < mat.length; g++) {
            for (int i = 0, j = g; j < mat.length; j++, i++) {
                if (g == 0) {
                    mat[i][j] = true;
                } else if (g == 1 && input.charAt(i) == input.charAt(j)) {
                    mat[i][j] = true;
                } else if (input.charAt(i) == input.charAt(j) && mat[i + 1][j - 1]) {
                    mat[i][j] = true;
                }
            }
        }
    }
}
