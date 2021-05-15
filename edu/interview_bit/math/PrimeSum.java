package edu.interview_bit.math;

import java.util.ArrayList;

public class PrimeSum {
    ArrayList<Integer> plist = new ArrayList<>();

    public static void main(String[] args) {
        int N = 35;
        System.out.println(new PrimeSum().primesum(N));
    }


    public ArrayList<Integer> primesum(int A) {
        
        ArrayList<Integer> l = new ArrayList<>();
        ArrayList<Integer> primes = getPrimeListUsingSieveOfEratosthenes(A);
        
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

    public ArrayList<Integer> getPrimeListUsingSieveOfEratosthenes(int n){
        ArrayList<Integer> primeList = new ArrayList<>();
        int[] arr = new int[n+1];
        int sqrtN = (int) Math.ceil(Math.sqrt(n));

        for (int i = 2; i < sqrtN; i++) {
            if(arr[i]==0){
                for (int j = i * 2; j < n+1; j+=i) {
                    arr[j]=1;
                }
            }
        }

        for (int i = 2; i < n+1; i++) {
            if(arr[i]==0){
                primeList.add(i);
            }
        }

        return primeList;
    }
}
