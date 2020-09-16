package edu.math.leetcode;

/* 
*   Note:- This program only provide square root at integer level which means the decimal plcaes will not be there.
*           sqrt(100) = 10
*           sqrt(110) = 10
*/

public class SqrtUsingBitManipulation {
    public static void main(String[] args) {
        System.out.println(sqrt(110));
    }

    /*
     * Basically, the function first locate the largest 2th power possible, which is
     * less than or equal to square root of x.
     * 
     * Once locating the the just small and nearest 2th power in reference to the
     * square root of x, So the ans lies between current 2th power and 2th power.
     * 
     * For Ex: for X = 110; 2^3 = 8, which is the nearest number and smaller number
     * than the square root of x=110 that is, 10.
     * 
     * So now, ans lies between 2^3 = 8 and next 2th power 2^4 = 16 where 16 is not
     * possible since we already check.
     * 
     * So, ans would be one of this {8, 9, 10, 11, 12, 13, 14, 15}
     * 
     * 8 bit wise representation is => 1000
     * 
     * on adding 100 it will become => 1100 that is, 12
     * 
     * Now we will check is 12's square is greater than x(=110)'s square: CASE I :
     * If it is greater than the ans lies in {8, 9, 10, 11}. So, we discard the last
     * added bit which will revert the ans to 1000 => 8. CASE II : If it is not than
     * the ans wer lies in {12, 13, 14, 15}. So we keep the ans as it is.
     * 
     * In case of x=110, 12's square is greater than 110 so we discard the last
     * added bit which gives us => 1100 -> discarding -> 1000 which is 8.
     * 
     * now we add a smaller number as compare to last time. Last time we added (100)
     * which is 4 in decimal. Now we are going to add (10) which is 2.
     * 
     * After adding 2 to 8 we get 100. now we check if 10^2 > 110.
     * 
     * No, then we keep this bit and can move forward.
     * 
     * Now ans can be {10, 11}.
     * 
     * So we add 1 now and check the square of the number is greater than x. If so
     * discard it else keep the last as it is.
     */

    public static int sqrt(int x) {
        long ans = 0;
        long bit = 1l << 16;
        while (bit > 0) {
            ans |= bit;
            if (ans * ans > x) {
                /*
                 * if the square of ans is more than x than discard the last bit added \; else
                 * continue and try to add more bits to increase the number and check whether
                 * there square is also less than the x.
                 */
                ans ^= bit;
            }
            bit >>= 1;
        }
        return (int) ans;
    }
}
