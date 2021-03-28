package edu.concepts.string;

public class StringCompression {

    public static void main(String[] args) {
        String msg = "aabbbacaab";
        System.out.println(compress(msg));
    }

    private static String compress(String msg) {
        int count=1;
        StringBuilder result = new StringBuilder();

        for (int i = 1; i < msg.length(); i++) {
            if (msg.charAt(i) == msg.charAt(i - 1)) {
                count++;
            }else{
                result.append(msg.charAt(i-1));
                if(count>1){ result.append(count);}
                count=1;
            }
        }
        result.append(msg.charAt(msg.length()-1));

        if(count>1){ result.append(count);}

        return result.toString();
    }
}
