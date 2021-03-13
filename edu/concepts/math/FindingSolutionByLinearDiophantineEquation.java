package edu.concepts.math;

import java.util.Scanner;

public class FindingSolutionByLinearDiophantineEquation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int[] sol = findSolution(a, b, c);

        System.out.println(String.format("Equation -> %s.(%s) + %s.(%s) = %s", a, sol[0], b, sol[1], c));

        sc.close();
    }

    static int[] findSolution(int a, int b, int c){
        int[] gcdDetails = gcdWithCoefficient(a, b);

        int[] sol = new int[2];
        sol[0] = (gcdDetails[1] * c) / gcdDetails[0];
        sol[1] = (gcdDetails[2] * c) / gcdDetails[0];

        return sol;
    }

    static int[] gcdWithCoefficient(int a, int b){
        int[] arr = new int[3];
        if(b==0){
            arr[0] = a;
            arr[1] = 1;
            arr[2] = 0;

            return arr;
        }

        int[] prev = gcdWithCoefficient(b, a%b);
        arr[0] = prev[0];
        arr[1] = prev[2];
        arr[2] = prev[1] - (a/b)*prev[2];

        return arr;
    }
}
