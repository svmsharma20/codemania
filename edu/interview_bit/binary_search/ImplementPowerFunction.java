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

			if(n==0){ return 1; }

			if(x<0){
				return pow(x+d, n, d);
			}

			boolean isNeg = (x<0)?true:false;
			long num = Math.abs(x);
			int exp = n;
			long power = 1;

			while(exp>0){
				if((exp&1)>0){
					power = (power * num) % d;
				}
                num = (num * num) % d;
                exp >>= 1;
			}

        return (int) ((isNeg && n % 2 == 1) ? (power * -1) : power);
	}
}
