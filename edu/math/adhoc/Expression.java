/*

Expression => https://codeforces.com/problemset/problem/479/A

time limit per test1 second
memory limit per test256 megabytes
inputstandard input
outputstandard output
Petya studies in a school and he adores Maths. His class has been studying arithmetic expressions. On the last class the teacher wrote three positive integers a, b, c on the blackboard. The task was to insert signs of operations '+' and '*', and probably brackets between the numbers so that the value of the resulting expression is as large as possible. Let's consider an example: assume that the teacher wrote numbers 1, 2 and 3 on the blackboard. Here are some ways of placing signs and brackets:

1+2*3=7
1*(2+3)=5
1*2*3=6
(1+2)*3=9
Note that you can insert operation signs only between a and b, and between b and c, that is, you cannot swap integers. For instance, in the given sample you cannot get expression (1+3)*2.

It's easy to see that the maximum value that you can obtain is 9.

Your task is: given a, b and c print the maximum value that you can get.

Input
The input contains three integers a, b and c, each on a single line (1 ≤ a, b, c ≤ 10).

Output
Print the maximum value of the expression that you can obtain.

Examples
input
1
2
3
output
9
input
2
10
3
output
60


*/

package edu.math.adhoc;

import java.util.Scanner;

public class Expression {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int maxValue = 0;

        if (a == 1 && c == 1) {
            maxValue = a + b + c;
        } else if (a == 1 || b == 1 || c == 1) {
            if (a == 1) {
                maxValue = (a + b) * c;
            } else if (b == 1 && a < c) {
                maxValue = (a + b) * c;
            } else {
                maxValue = a * (b + c);
            }
        } else {
            maxValue = a * b * c;
        }

        System.out.println(maxValue);

        sc.close();
    }

}