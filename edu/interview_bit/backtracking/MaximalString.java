package edu.interview_bit.backtracking;

public class MaximalString {

    public String solve(String A, int B) {
        if (B == 0) {
            return A;
        }
        String maxStr = A;
        for (int i = 0; i < A.length(); i++) {
            for (int j = i + 1; j < A.length(); j++) {
                if (A.charAt(i) < A.charAt(j)) {
                    String swappedStr = swap(A, i, j);
                    maxStr = compareString(maxStr, solve(swappedStr, B - 1));
                }
            }
        }
        return maxStr;
    }

    public static String swap(String s, int i, int j) {
        char ichar = s.charAt(i);
        char jchar = s.charAt(j);
        String str = "";
        for (int k = 0; k < s.length(); k++) {

            if (k == i) {
                str += jchar;
            } else if (k == j) {
                str += ichar;
            } else {
                str += s.charAt(k);
            }
        }
        return str;
    }

    public static String compareString(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) > s2.charAt(i)) {
                return s1;
            }
            if (s1.charAt(i) < s2.charAt(i)) {
                return s2;
            }
        }
        return s1;
    }
}
