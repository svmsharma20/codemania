package edu.math.concepts;

import java.util.Scanner;

public class ModularMultiplicativeInverse {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int modulo = sc.nextInt();

        int mmi = getMMI(a, modulo-2, modulo);

        System.out.println("The module multiplicative inverse of "+a+
                " under modulo "+modulo+ " is : "+ mmi);
        sc.close();
    }
    
    static int getMMI(int a, int n, int modulo){
        int res=1;
        int pow = a;

        while(n>0){
            if((n&1)!=0){
                res = ((res % modulo) * (pow % modulo)) % modulo;
            }
            pow = ((pow % modulo) * (pow % modulo)) % modulo;
            n = n>>1;
        }
        return res;
    }
}
