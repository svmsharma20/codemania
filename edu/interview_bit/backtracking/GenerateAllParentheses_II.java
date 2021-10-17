package edu.interview_bit.backtracking;

import java.util.ArrayList;

public class GenerateAllParentheses_II {

    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> output = new ArrayList<>();
        generate(n, output, "", 0);
        return output;
    }

    public void generate(int n, ArrayList<String> output, String temp, int i) {
        if (i > n || i < 0 || temp.length() > 2 * n) {
            return;
        }
        if (temp.length() == 2 * n && i == 0) {
            output.add(temp);
            return;
        }

        generate(n, output, temp + "(", i + 1);
        generate(n, output, temp + ")", i - 1);

    }
}
