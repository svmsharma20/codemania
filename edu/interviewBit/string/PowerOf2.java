package edu.interviewBit.string;

public class PowerOf2 {

    public static void main(String[] args) {
        String num = "147573952589676412928";
        System.out.println(isAPowerOfTwo(num));
    }

    private static int isAPowerOfTwo(String num) {
        while(num.length()>1){

            if(Integer.parseInt(num.charAt(num.length()-1)+"")%2!=0){
                return 0;
            }

            int previousRem = 0;
            String nextNum = "";

            for (int i = 0; i < num.length(); i++) {
                int chInt = Integer.parseInt(num.charAt(i) + "");
                int n = previousRem*10+chInt;
                previousRem = n % 2;
                if(!((n/2)==0 && nextNum.length()==0)){
                    nextNum += (n/2)+"";
                }

            }
            num = nextNum;

        }

        if(Integer.parseInt(num.charAt(num.length()-1)+"")%2!=0){
            return 0;
        }
        return 1;
    }
}
