package edu.interview_bit.greedy_algorithms;

public class MajorityElement {

  public int majorityElement(final int[] A) {
    int element = A[0];
    int count = 1;

    for(int i=1; i<A.length; i++){
      if(A[i]==element){
        count++;
      }else if(count>0){
        count--;
      }else{
        element = A[i];
        count=1;
      }
    }

    return element;
  }
}
