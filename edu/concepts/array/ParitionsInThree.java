package edu.concepts.array;

import java.util.ArrayList;

public class ParitionsInThree {
    
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(0);
        list.add(3);

        System.out.println(new ParitionsInThree().solve(list));
    }


    public int solve(ArrayList<Integer> B) {
        int totalSum = 0;
        
        for(int i=0; i<B.size(); i++){
            totalSum += B.get(i);
        }
        
        if(totalSum%3 != 0){
            return 0;
        }
        
        int sumOfEachSegment = totalSum/3;
        
        ArrayList<Integer> prefix = new ArrayList<>();
        ArrayList<Integer> suffix = new ArrayList<>();
        
        int sum = 0;
        
        for(int i=0; i<B.size(); i++){
            sum += B.get(i);
            if(sum==sumOfEachSegment){
                prefix.add(i);
            }
        }
        
        sum=0;
        
        for(int i=B.size()-1; i>=0; i--){
            sum += B.get(i);
            if(sum==sumOfEachSegment){
                suffix.add(i);
            }
        }
        
        int count=0;
        
        for(int i=0; i<prefix.size(); i++){
            for(int j=0; j<suffix.size(); j++){
                if(prefix.get(i)>= suffix.get(j)){
                    break;
                }
                
                    int midSum=0;

                    for(int k=prefix.get(i)+1; k<suffix.get(j); k++){
                        midSum+= B.get(k);
                    }

                if(midSum == sumOfEachSegment){
                    count++;
                }
            }
        }
        
        return count;
        
    }
}
