package edu.interview_bit.stacks_and_queues;

import java.util.List;

public class RainWaterTrapped {

  public int trap(final List<Integer> A) {

    int left = 1;
    int right = A.size()-2;
    int leftMaxHeight = A.get(0);
    int rightMaxHeight = A.get(A.size()-1);
    int totalWater = 0;

    while(left<=right){
      if(leftMaxHeight<rightMaxHeight){
        if(A.get(left)<leftMaxHeight){
          totalWater += leftMaxHeight - A.get(left);
        }else{
          leftMaxHeight = A.get(left);
        }
        left++;
      }else{
        if(A.get(right)<rightMaxHeight){
          totalWater += rightMaxHeight - A.get(right);
        }else{
          rightMaxHeight = A.get(right);
        }
        right--;
      }
    }

    return totalWater;
  }

}
