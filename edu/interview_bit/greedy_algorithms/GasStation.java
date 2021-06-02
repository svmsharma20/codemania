package edu.interview_bit.greedy_algorithms;

public class GasStation {

  //  https://www.youtube.com/watch?v=wDgKaNrSOEI
  public int canCompleteCircuit(final int[] A, final int[] B) {
    int diff = 0;

    for(int i=0; i<A.length; i++){
      diff += A[i]-B[i];
    }

    if(diff<0){
      return -1;
    }

    int startingIndex = 0;
    int tank = 0;

    for(int i=0; i<A.length; i++){
      tank += A[i]-B[i];
      if(tank<0){
        startingIndex = i+1;
        tank = 0;
      }
    }

    return startingIndex;
  }

}
