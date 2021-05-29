package edu.interview_bit.array;

import java.util.ArrayList;

public class MaximumAbsoluteDifference {
  public int maxArr(ArrayList<Integer> A) {
    int maxAIMinusI = Integer.MIN_VALUE;
    int minAIMinusI = Integer.MAX_VALUE;
    int maxAIPlusI = Integer.MIN_VALUE;
    int minAIPlusI = Integer.MAX_VALUE;

    for(int i=0; i<A.size(); i++){
      maxAIMinusI = Math.max(maxAIMinusI, A.get(i)-i);
      minAIMinusI = Math.min(minAIMinusI, A.get(i)-i);
      maxAIPlusI = Math.max(maxAIPlusI, A.get(i)+i);
      minAIPlusI = Math.min(minAIPlusI, A.get(i)+i);
    }

    return Math.max( (maxAIPlusI - minAIPlusI),
        (maxAIMinusI - minAIMinusI));
  }
}
