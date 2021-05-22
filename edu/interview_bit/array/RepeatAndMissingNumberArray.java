package edu.interview_bit.array;

import java.util.ArrayList;
import java.util.List;

public class RepeatAndMissingNumberArray {

    // https://www.youtube.com/watch?v=5nMGY4VUoRY


    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(3);
        A.add(1);
        A.add(2);
        A.add(5);
        A.add(3);

        System.out.println(new RepeatAndMissingNumberArray().repeatedNumbersUsingXOR(A));
    }

    public int[] repeatedNumber(final int[] A) {
        
        long sum = 0, sumSquares = 0;
        for (int i = 1; i <= A.length; i++) {
            sum += A[i-1] - i;
            sumSquares += A[i-1]*(long)A[i-1] - i*(long)i;
        }
        long AminusB = sum, AplusB = sumSquares / sum;
        return new int[] {(int)((AplusB+AminusB)/2), (int)((AplusB-AminusB)/2)};
    }

    public List<Integer> repeatedNumbersUsingXOR(final List<Integer> A){
        ArrayList<Integer> a = new ArrayList<Integer>();

        int ss=0;
        for (int i = 1; i <= A.size(); i++) {
            ss ^= i;
        }

        for(int i : A) {
            ss ^= i;
        }

        int c = 0;
        for(int i = 0; i < 64; i++) {
            if(((1 << i) & ss) > 0) {
                c = i;
                break;
            }
        }

        int f = 0, s = 0;

        for(int i = 1; i <= A.size(); i++) {
            if(((1 << c) & i) > 0) {
                f ^= i;
            } else {
                s ^= i;
            }
        }

        for(int i : A) {
            if(((1 << c) & i) > 0) {
                f ^= i;
            } else {
                s ^= i;
            }
        }

        for(int i : A) {
            if(i == f) {
                a.add(f);
                a.add(s);
                break;
            }

            if(i == s) {
                a.add(s);
                a.add(f);
                break;
            }
        }

        return a;

    }
    
}
