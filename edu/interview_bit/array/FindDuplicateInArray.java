package edu.interview_bit.array;

import jdk.jfr.Enabled;


public class FindDuplicateInArray {

  public static void main(String[] args) {
    int[] arr = {3, 4, 1, 4, 1};
    System.out.println(new FindDuplicateInArray().repeatedNumber(arr));
  }

  public int repeatedNumber(final int[] A) {
    int slow = A[0];
    int fast = A[A[0]];

    while(A[slow] != A[fast]){
      slow = A[slow];
      fast = A[A[fast]];
    }
    fast = 0;
    while(slow!=fast){
      slow = A[slow];
      fast = A[fast];
    }

    return slow;
  }

  /*
  * This method is not working.
  * */
  public int repeatedNumberMethod2(final int[] A) {
    int NPlus1 = A.length;
    int N = NPlus1-1;
    int sqrtOfN = (int)Math.ceil(Math.sqrt(NPlus1));

    int[] bucketArray = new int[sqrtOfN];

    for (int i = 0; i < A.length; i++) {
      bucketArray[A[i]/sqrtOfN]++;
    }

    int index = -1;

    int higherLimitOfBucket = -1;
    int lowerLimitOBucket = -1;

    if(bucketArray[0]>=(sqrtOfN-1)){
      // for bucket at index 0
      index=0;
      lowerLimitOBucket = 1;
      higherLimitOfBucket = (sqrtOfN * 1) - 1;
      if(N<higherLimitOfBucket){
        higherLimitOfBucket = N+1;
      }
    }else {
      // for bucket from 1 to sqrtN
      for (int i = 1; i < sqrtOfN; i++) {
        higherLimitOfBucket = (sqrtOfN * (i+1)) - 1;
        lowerLimitOBucket   = (sqrtOfN * i) ;

        if(lowerLimitOBucket>N){
          return -1;
        }else if(higherLimitOfBucket>N){
          higherLimitOfBucket = N+1;
        }
        int expectedCountOfTheBucketIfNoRepetition = higherLimitOfBucket-lowerLimitOBucket;

        if(bucketArray[i]>=expectedCountOfTheBucketIfNoRepetition){
          index = i;
          break;
        }
      }
    }

    if(index==-1){
      return -1;
    }

    for (int i = 0; i < sqrtOfN; i++) {
      bucketArray[i] = 0;
    }

    for (int i = 0; i < A.length; i++) {
      if(A[i]>=lowerLimitOBucket && A[i]<higherLimitOfBucket){
        int j = A[i]-lowerLimitOBucket;   // normalize the value to fit as index
        A[j]++;
      }
    }

    for (int i = 0; i < sqrtOfN; i++) {
      if(A[i]>1){
        return lowerLimitOBucket+i;
      }
    }

    return -1;
  }

}
