package edu.math.other_sources;

import java.util.Arrays;
import java.util.HashMap;

public class SortedPermutationRank {

    // https://www.youtube.com/watch?v=gqlSxpOegoY


    HashMap<Integer, Integer> factMap = new HashMap<>();
    public static void main(String[] args) {
        System.out.println(new SortedPermutationRank().findRank("AaBbCc"));
    }

    public int findRank(String str) {
        String s = sort(str);
        int len=str.length();
        int pos=0;
        int[] check = new int[len];
        int index=0;
        factorial(len);

        for(int i=0; i<len; i++){
            
            if(check[i]==-1){
                continue;
            }else if (str.charAt(index)!=s.charAt(i)){
                pos += factMap.get(len-index-1);
            }else{
                index++;
                check[i]=-1;
                i=-1;
            }
        }
        
        return pos+1;
      }
      
      String sort(String s){
          char[] ch = s.toCharArray();
          Arrays.sort(ch);
          return new String(ch);
      }
      
      void factorial(int num){
        
        factMap.put(0, 1);
        int fact = 1;
        int i=1;
        while(i<=num){
            fact *= i;
            factMap.put(i, fact);
            i++;
        }
      }
}
