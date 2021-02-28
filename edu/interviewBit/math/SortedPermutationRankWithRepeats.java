package edu.interviewBit.math;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class SortedPermutationRankWithRepeats {
    /* References:
    * https://www.youtube.com/watch?v=Ni24yuaMHv0
    * https://www.geeksforgeeks.org/multiplicative-inverse-under-modulo-m/
    */
    
    static HashMap<Integer, Long> factMap = new HashMap<>();
    static HashMap<Character, Integer> countMap = new HashMap<>();
    static final long MODULOUS = 1000003;
    
    public int findRank(String str) {
        String sortedStr = sort(str);
        int len = str.length();
        initFactMap(str.length());
         
        int index=0;
        long rank=0l;
        
        for(int i=0; i<sortedStr.length() && index<len; i++){
            char c = str.charAt(index);
            char charAtI = sortedStr.charAt(i);
            if(countMap.get(charAtI)<1){
                continue;
            }else if(c != charAtI){
                long factorial = factMap.get(len-index-1);
                
                for(Map.Entry entry : countMap.entrySet()){

                    long multiplicativeInverse = 1;
                    
                    if((char)entry.getKey() == charAtI){
                        multiplicativeInverse = getModuloMultiplicativeInverse(factMap.get((int)entry.getValue()-1), MODULOUS);
                    }else{
                        multiplicativeInverse = getModuloMultiplicativeInverse(factMap.get((int)entry.getValue()), MODULOUS);
                    }
                    
                    factorial = ((factorial%MODULOUS)*(multiplicativeInverse%MODULOUS))%MODULOUS;
                }
                
                rank += factorial;
                rank %= MODULOUS;
            }else{
                index++;
                countMap.put(c, countMap.get(c)-1);
                i=-1;
            }
        }
        return (int)((rank+1)%1000003);
    }
    
    String sort(String str){
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        
        for(char c : ch){
            countMap.put(c, countMap.getOrDefault(c,0)+1);
        }
        StringBuilder builder = new StringBuilder();
        builder.append(ch[0]);

        for(int i=1; i<ch.length; i++){
            if(ch[i]!=ch[i-1]){
                builder.append(ch[i]);
            }
        }

        return builder.toString();
    }
    
    void initFactMap(int n){
        factMap.put(0,1l);
        int i=1;
        long fact = 1;
        while(i<=n){
            fact *= i;
            fact = fact%1000003;
            factMap.put(i, fact);
            i++;
        }
    }

    long getModuloMultiplicativeInverse(Long a, Long m){
        long m0 = m;
        long y = 0, x = 1;
 
        if (m == 1)
            return 0;
 
        while (a > 1) {
            // q is quotient
            long q = a / m;
 
            long t = m;
 
            // m is remainder now, process
            // same as Euclid's algo
            m = a % m;
            a = t;
            t = y;
 
            // Update x and y
            y = x - q * y;
            x = t;
        }
 
        // Make x positive
        if (x < 0)
            x += m0;
 
        return x;
    }
}
