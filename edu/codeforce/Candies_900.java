/*

Candies => https://codeforces.com/problemset/problem/1343/A

time limit per test1 second
memory limit per test256 megabytes
inputstandard input
outputstandard output
Recently Vova found n candy wrappers. He remembers that he bought x candies during the first day, 2x candies during the second day, 
    4x candies during the third day, …, 2k−1x candies during the k-th day. But there is an issue: 
Vova remembers neither x nor k but he is sure that x and k are positive integers and k>1.

Vova will be satisfied if you tell him any positive integer x so there is an integer k>1 that x+2x+4x+⋯+2k−1x=n. 
It is guaranteed that at least one solution exists. Note that k>1.

You have to answer t independent test cases.

Input
The first line of the input contains one integer t (1≤t≤104) — the number of test cases. Then t test cases follow.

The only line of the test case contains one integer n (3≤n≤109) — the number of candy wrappers Vova found. 
It is guaranteed that there is some positive integer x and integer k>1 that x+2x+4x+⋯+(2^(k−1))x=n.

Output
Print one integer — any positive integer value of x so there is an integer k>1 that x+2x+4x+⋯+(2^(k−1))x=n.

Example
input
7
3
6
7
21
28
999999999
999999984

output
1
2
1
7
4
333333333
333333328

Note
In the first test case of the example, one of the possible answers is x=1,k=2. Then 1⋅1+2⋅1 equals n=3.

In the second test case of the example, one of the possible answers is x=2,k=2. Then 1⋅2+2⋅2 equals n=6.

In the third test case of the example, one of the possible answers is x=1,k=3. Then 1⋅1+2⋅1+4⋅1 equals n=7.

In the fourth test case of the example, one of the possible answers is x=7,k=2. Then 1⋅7+2⋅7 equals n=21.

In the fifth test case of the example, one of the possible answers is x=4,k=3. Then 1⋅4+2⋅4+4⋅4 equals n=28.

*/

/*

Solution:

    N = x + 2x + 4x + . . . + 2^k
      = x(2^0 + 2^1 + 2^2 + . . . + 2^k)
      = x( 2^(k+1) - 1 )

    => x = N /  ( 2^(k+1) - 1 )

    So now, we just have to divide N by ( 2^(k+1) - 1 ) and when it divides it completely thats our answer.

*/

package edu.codeforce;

import java.util.Scanner;

public class Candies_900 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numberOfTestcases = sc.nextInt();
        while (numberOfTestcases > 0) {

            int n = sc.nextInt();

            for (int i = 2; i < 30; i++) {
                int val = (1 << i) - 1;
                if (n % val == 0) {
                    System.out.println(n / val);
                    break;
                }
            }

            numberOfTestcases--;
        }
        sc.close();
    }

}