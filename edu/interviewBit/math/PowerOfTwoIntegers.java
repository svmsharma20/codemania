package edu.interviewBit.math;

public class PowerOfTwoIntegers {
    public int isPower(int A) {
        
        //     int num = A;
            
        //     HashMap<Integer, Integer> factors = new HashMap<>();
        //     int i=2;
        //     while(i<=num){
        //         if(num%i==0){
        //             Integer oldCount = factors.get(i);
        //             Integer newCount = 1;
        //             if(oldCount != null){
        //                 newCount = oldCount+1;
        //             }
        //             factors.put(i,newCount);
        //             num /= i;
        //         }
        //         else{
        //             i++;
        //         }
        //     }
        //     if(factors.size()==1 && (factors.get(factors.keySet().iterator().next())>1)){
        //         return 1;
        //     }
            
        //     for(Integer key : factors.keySet()){
        //         // System.out.println(key+" : " +factors.get(key));
        //         if(factors.get(key)%2!=0){
        //             return 0;
        //         }
        //     }
                    
        //     return 1;
        // }
        if(A==1){
            return 1;
        }
        
        int upperLimit = (int)Math.ceil(Math.sqrt(A+1));
        
        for(int i=2; i<upperLimit; i++){
            double div = Math.log(A)/Math.log(i);
            int intPart = (int)div;
            if(div-intPart == 0){
                return 1;
            }
            
        }
        
        return 0;
        
    }
}
