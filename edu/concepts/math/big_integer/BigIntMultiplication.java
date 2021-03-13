package edu.concepts.math.big_integer;

import java.util.Scanner;

public class BigIntMultiplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String num1 = sc.nextLine();
        String num2 = sc.nextLine();

        int[] ans = new int[num1.length() + num2.length()];

        int shift = 0;
        int index = 0;
        int carry = 0;

        for (int i = num2.length() - 1, k = 0; i >= 0 && k < ans.length; i--, k++) {

            int b = Integer.parseInt(String.valueOf(num2.charAt(i)));

            shift = k;

            for (int j = num1.length() - 1; j >= 0; j--) {
                int a = Integer.parseInt(String.valueOf(num1.charAt(j)));

                int prod = (a * b);

                index = ans.length - 1 - shift;
                int intermittentSum = ans[index] + prod + carry;

                ans[index] = intermittentSum % 10;

                carry = intermittentSum / 10;

                shift++;

            }
            while (carry > 0) {
                index--;
                int temp_sum = ans[index] + (carry % 10);
                ans[index] = temp_sum % 10;
                carry = temp_sum / 10;
            }
        }

        boolean flag = true;
        for (int i = 0; i < ans.length; i++) {
            if (flag && ans[i] != 0) {
                flag = false;
            }
            if (!flag) {
                System.out.print(ans[i]);
            }
        }

        sc.close();
    }

}
