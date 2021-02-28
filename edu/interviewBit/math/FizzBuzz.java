package edu.interviewBit.math;

import java.util.ArrayList;

public class FizzBuzz {
    public ArrayList<String> fizzBuzz(int A) {
        ArrayList<String> l = new ArrayList<>();
        
        for(int i=1; i<=A; i++){
            if(i%3!=0 && i%5!=0){
                l.add(""+i);
            }
            else{
                String str = "";
                if(i%3==0){
                    str += "Fizz";
                }
                if(i%5==0){
                    str += "Buzz";
                }
                l.add(str);
            }
                
        }
        return l;
    }
}
