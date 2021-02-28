package edu.interviewBit.math;

import java.util.ArrayList;

public class PrimeSum {
    ArrayList<Integer> plist = new ArrayList<>();
    
    public ArrayList<Integer> primesum(int A) {
        
        ArrayList<Integer> l = new ArrayList<>();
        ArrayList<Integer> primes = getPrimeList(A);
        
        for(Integer num : primes){
                
            if(primes.contains(num) && primes.contains(A-num)){
                l.add(num);
                l.add(A-num);
                return l;
            }
            
        }
        
        return l;
    }
    
    public ArrayList<Integer> getPrimeList(int num){
        
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        
        for(int j=3; j<=num; j+=2){
            boolean isPrime = true;
            int upperlimit = (int)Math.ceil(Math.sqrt(j));
            int i=1;
            int p = list.get(0);
            while(p<=upperlimit && i<list.size()){
                p=list.get(i++);
                if(j%p==0){
                    isPrime=false;
                    break;
                }
                
            }
            if(isPrime){
                list.add(j);
            }
        }
        
        return list;
    }
}
