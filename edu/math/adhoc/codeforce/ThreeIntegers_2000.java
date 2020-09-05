/*

Three Integers => https://codeforces.com/problemset/problem/1311/D

time limit per test2 seconds
memory limit per test256 megabytes
inputstandard input
outputstandard output
You are given three integers a≤b≤c.

In one move, you can add +1 or −1 to any of these integers (i.e. increase or decrease any number by one). You can perform such operation any (possibly, zero) number of times, you can even perform this operation several times with one number. Note that you cannot make non-positive numbers using such operations.

You have to perform the minimum number of such operations in order to obtain three integers A≤B≤C such that B is divisible by A and C is divisible by B.

You have to answer t independent test cases.

Input
The first line of the input contains one integer t (1≤t≤100) — the number of test cases.

The next t lines describe test cases. Each test case is given on a separate line as three space-separated integers a,b and c (1≤a≤b≤c≤104).

Output
For each test case, print the answer. In the first line print res — the minimum number of operations you have to perform to obtain three integers A≤B≤C such that B is divisible by A and C is divisible by B. On the second line print any suitable triple A,B and C.

Example
input
8
1 2 3
123 321 456
5 10 15
15 18 21
100 100 101
1 22 29
3 19 38
6 30 46

output
1
1 1 3

102
114 228 456

4
4 8 16

6
18 18 18

1
100 100 100

7
1 22 22

2
1 19 38

8
6 24 48  
*/

package edu.math.adhoc.codeforce;

import java.util.Scanner;

public class ThreeIntegers_2000 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numberOfTestcases = sc.nextInt();

        while (numberOfTestcases > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            int A = 0;
            int B = 0;
            int C = 0;

            int ops = Integer.MAX_VALUE;

            /*
             * Possible values of A can be from 1 to 2*A, Why?
             * 
             * We need a value for A which can divide B totally. Now, the nearest value the
             * from A that can divide B totally can be smaller or greater.
             * 
             * For example Case 1: If A=5 & B=28 then, By decrementing A once we will get 4
             * that can divide B. But, in some case Case 2: Lets say, A=5 & B=18 then, By
             * incrementing A once we wiil get 6 which can divide B. 3 is also a value that
             * can divide B totally but 6 is the nearest.
             * 
             * So, the nearest number can be smaller or greater.
             * 
             * Now, Is there any range we can defined for possible values of A which
             * guarantee a number that can divide B completely?
             * 
             * Yes, the range for A is: 1 -> (2*A)
             * 
             * Basically, we have to find a value for A which can completely divide B.
             * 
             * we don't have to check numbers after 2*A because, If we see the number line [
             * 1 <-(A terms in btw) --- A --- (A terms in btw) -> 2*A ] there are A terms
             * between 1 and A, And since 1 divides every number, we can say atmost A number
             * of subtractions we need to perform to get a number which can divide B
             * totally. But, there can be another number which is between A and (2*A) which
             * can divide B and needed less operations. Like in case 2 above. Therefore we
             * are checking upto 2*A.
             * 
             */
            for (int iA = 1; iA <= 2 * a; iA++) {
                /*
                 * Same explanation for range as A just once change since B should be either
                 * equal to or greater than A So, we are starting from A and going upto 2*B.
                 * 
                 * Also, since we want a multiple of A we are incrementing B by A factor.
                 */
                for (int jB = iA; jB <= 2 * b; jB += iA) {

                    int kC = 0;
                    int remC = c % jB;
                    int complementRemC = jB - remC;

                    /*
                     * To make a number divisible by another, we can either subtract the remainder
                     * or add a certain number to the dividend to make it a multiple of divisor.
                     * 
                     * For example, if B = 20 & C = 55. To make C divisible by B we can either
                     * subtratc the remainedr that is 15 which gives us 40 which is divisible by 20.
                     * 
                     * Or
                     * 
                     * We can add 5 to make it 60 which is again divisible by 20.
                     * 
                     * How did 5 came: ( B-(C % B) )=> (20 - (55 % 20)) => (20 - 15) => 5
                     */
                    if (remC < complementRemC && (c - remC >= jB)) {
                        kC = c - remC;
                    } else {
                        kC = c + complementRemC;
                    }

                    int tempOps = Math.abs(a - iA) + Math.abs(b - jB) + Math.abs(c - kC);
                    if (tempOps < ops) {
                        A = iA;
                        B = jB;
                        C = kC;
                        ops = tempOps;
                    }
                }
            }

            System.out.println(ops);
            System.out.println(String.format("%d %d %d", A, B, C));

            numberOfTestcases--;
        }

        sc.close();

    }

}