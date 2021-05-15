package edu.interview_bit.math;

import java.util.HashMap;
import java.util.Arrays;

public class SortedPermutationRank {
    // https://www.youtube.com/watch?v=gqlSxpOegoY
    
    HashMap<Integer, Long> factMap = new HashMap<>();
    
    public int findRank(String str) {
        String s = sort(str);
        int len=str.length();
        long pos=0;
        int[] check = new int[len];
        int index=0;
        factorial(len);

        for(int i=0; i<len; i++){
            
            if(check[i]==-1){
                continue;
            }else if (str.charAt(index)!=s.charAt(i)){
                pos = (pos + factMap.get(len-index-1))%1000003;
            }else{
                index++;
                check[i]=-1;
                i=-1;
            }
        }
        
        return (int)((pos+1)%1000003);
      }
      
      String sort(String s){
          char[] ch = s.toCharArray();
          Arrays.sort(ch);
          return new String(ch);
      }
      
      void factorial(int num){
        
        factMap.put(0, 1l);
        long fact = 1;
        int i=1;
        while(i<=num){
            fact *= i;
            fact = fact%1000003;
            factMap.put(i, fact);
            i++;
        }
      }
    
}
