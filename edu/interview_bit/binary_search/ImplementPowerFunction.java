package edu.interview_bit.binary_search;

// Finding modulo of negative number
// https://www.youtube.com/watch?v=P-H1PAX5oIM

public class ImplementPowerFunction {
    public static void main(String[] args) {
        System.out.println(new ImplementPowerFunction().pow(71045970, 41535484, 64735492));
    }

    public int pow(int x, int n, int d) {
	    
	    if(x==0){
	        return 0;
	    }
	    
	    boolean isNeg = (x<0)?true:false;
	    long num = Math.abs(x);
	    int exp = n;
	    long power = 1;
        long mod = d;
	    
	    while(exp>0){
	        if((exp&1)>0){
	            power = ((power%d) * (num%d))%d;
	        }
	        num = ((num%d) * (num%d))%d;
	        exp >>= 1;
	    }
	    
	    if(isNeg && n%2==1){
	        int i=1;
	        while(mod<power){
	            i++;
	            d *= i;
	        }
	        return (int)(mod-power);
	    }
	    return (int)power;
	}
}