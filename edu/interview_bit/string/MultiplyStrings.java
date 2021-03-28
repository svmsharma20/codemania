package edu.interview_bit.string;

public class MultiplyStrings {

    public static void main(String[] args) {
        String num1 = "99999";
        String num2 = "99999";

        System.out.println(multiplyIntegeralStrings(num1, num2));
    }

    private static String multiplyIntegeralStrings(String num1, String num2) {

        String result = "";

        int[] numArr1 = new int[num1.length()];
        int[] numArr2 = new int[num2.length()];

        for (int i = 0; i < num1.length(); i++) {
            numArr1[i] = Integer.parseInt(num1.charAt(i)+"");
        }

        for (int i = 0; i < num2.length(); i++) {
            numArr2[i] = Integer.parseInt(num2.charAt(i)+"");
        }

        int[] product = new int[numArr1.length+numArr2.length+1];

        int shift=0;
        for (int i = numArr1.length-1; i >= 0 ; i--) {
            if(numArr1[i]==0){
                shift++;
                continue;
            }
            int carry = 0;
            int k = product.length-1 - shift;

            for (int j = numArr2.length-1; j >= 0; j--) {

                int localProduct = numArr1[i] * numArr2[j];
                int p = product[k] + carry + localProduct;
                product[k] = p%10;
                carry = p/10;
                k--;
            }

            while(carry>0){
                int p = product[k] + carry;
                product[k] = p%10;
                carry = p/10;
                k--;
            }
            shift++;
        }

        for (int i = 0; i < product.length; i++) {
            if(!(result.length()==0 && product[i]==0)){
                result += product[i];
            }
        }

        return (result.length()>0) ? result : "0";
    }
}
