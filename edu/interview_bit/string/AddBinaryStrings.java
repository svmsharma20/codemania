package edu.interview_bit.string;

public class AddBinaryStrings {

    public static void main(String[] args) {
        String binaryNum1 = "111";
        String binaryNum2 = "111";

        System.out.println(getBinarySum(binaryNum1, binaryNum2));
    }

    private static String getBinarySum(String binaryNum1, String binaryNum2) {
        String result = "";
        int carry = 0;
        int i = binaryNum1.length()-1;
        int j = binaryNum2.length()-1;

        while(i>=0 && j>=0){
            int n1 = Integer.parseInt(binaryNum1.charAt(i)+"");
            int n2 = Integer.parseInt(binaryNum2.charAt(j)+"");

            int sum = n1+n2+carry;
            int s = sum%2;
            carry = sum/2;

            result = s+ result;

            i--;
            j--;
        }

        while(i>=0){
            int n1 = Integer.parseInt(binaryNum1.charAt(i)+"");

            int sum = n1+carry;
            int s = sum%2;
            carry = sum/2;

            result = s+ result;

            i--;
        }

        while(j>=0){
            int n2 = Integer.parseInt(binaryNum2.charAt(j)+"");

            int sum = n2+carry;
            int s = sum%2;
            carry = sum/2;

            result = s+ result;

            j--;
        }

        if(carry>0){
            result = carry + result;
        }
        return result;
    }
}
