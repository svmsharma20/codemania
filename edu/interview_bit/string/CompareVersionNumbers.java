package edu.interview_bit.string;

public class CompareVersionNumbers {

    public static void main(String[] args) {
        String version1 = "13.53.0";
        String version2 = "13.53";

        System.out.println(compareVersion(version1, version2));
    }

    private static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int i=0;

        while(i<v1.length && i<v2.length){

            int res = compareTwoNumbers(v1[i], v2[i]);
            if(res!=0){
                return res;
            }
            i++;
        }

        // If any one of the remaining digit is non-zero that string would be larger
        // other wise even if the length of one of the string is larger
        // but their values would be same e.g. v1=13.5, v2=13.5.0.0.0
        // even if v2 length is more but the overall value is same.
        while(i<v1.length){
            if(isNonZero(v1[i])){
                return 1;
            }
            i++;
        }

        while(i<v2.length){
            if(isNonZero(v2[i])){
                return -1;
            }
            i++;
        }

        return 0;
    }

    // check if there is any non zero value in num
    private static boolean isNonZero(String num) {
        int i=0;
        while(i<num.length()){
            if(num.charAt(i)!='0'){
                return true;
            }
            i++;
        }
        return false;
    }

    private static int compareTwoNumbers(String num1, String num2) {
        int i=0;
        int j=0;

        int len1 = num1.length();
        int len2 = num2.length();

        // Handle zero's at the start for num1
        while(i< len1 && num1.charAt(i)=='0'){
            i++;
        }

        // Handle zero's at the start for num2
        while(j<len2 && num2.charAt(j)=='0'){
            j++;
        }

        // A number is already larger if its length is more than the other one
        if(len1-i > len2-j){
            return 1;
        }

        if(len1-i < len2-j){
            return -1;
        }

        // length of both the numbers are equal
        while(i<len1 && j<len2){
            int n1 = Integer.parseInt(num1.charAt(i)+"");
            int n2 = Integer.parseInt(num2.charAt(j)+"");

            if(n1>n2){
                return 1;
            }else if(n1<n2){
                return -1;
            }
            i++;
            j++;
        }

        return 0;
    }
}
