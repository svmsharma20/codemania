package edu.concepts.math;

import java.util.Scanner;

public class BinaryExponential {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int n = sc.nextInt();
        System.out.println(pow(a, n));
        sc.close();
    }

    static public int pow(int a, int n) {
        int _result = 1;
        int _pow = a;
        int i = 1;
        while (n > 0) {
            if ((n & i) > 0) {
                _result *= _pow;
            }
            _pow = _pow * _pow;

            n = n >> 1;
        }
        return _result;
    }
}
