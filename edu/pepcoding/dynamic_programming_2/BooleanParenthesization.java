package edu.pepcoding.dynamic_programming_2;

import java.util.Scanner;

// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/boolean-parenthesization-official/ojquestion
// https://youtu.be/JbRsM2X2_pg?list=TLGGt1nvmuLHyhkwMzA3MjAyMQ
public class BooleanParenthesization {

  public static int solution(String str1, String str2) {
    int len = str1.length();
    int[][] dpt = new int[len][len];
    int[][] dpf = new int[len][len];

    for(int g = 0; g < len; g++){
      for(int i = 0, j = g; j < len; i++, j++){
        if(g==0){
          dpt[i][j] = (str1.charAt(i) == 'T') ? 1 : 0;
          dpf[i][j] = (str1.charAt(i) == 'F') ? 1 : 0;
        }else {
          for(int k = i; k<j; k++){
            int ltc = dpt[i][k];
            int rtc = dpt[k+1][j];
            int lfc = dpf[i][k];
            int rfc = dpf[k+1][j];

            if(str2.charAt(k) == '&'){
              dpt[i][j] += (ltc * rtc);
              dpf[i][j] += (lfc * rfc) + (lfc * rtc) + (ltc * rfc);
            }else if(str2.charAt(k) == '|'){
              dpt[i][j] += (ltc * rtc) + (ltc * rfc) + (lfc * rtc);
              dpf[i][j] += (lfc * rfc);
            }else{ // xor
              dpt[i][j] += (ltc * rfc) + (lfc * rtc);
              dpf[i][j] += (ltc * rtc) + (lfc * rfc);
            }
          }
        }
      }
    }

    return dpt[0][len-1];
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String s1 = scn.next();
    String s2 = scn.next();
    System.out.println(solution(s1, s2));
  }
}
