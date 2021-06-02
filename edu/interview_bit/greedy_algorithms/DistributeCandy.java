package edu.interview_bit.greedy_algorithms;

public class DistributeCandy {

  // https://www.youtube.com/watch?v=h6_lIwZYHQw
  public static void main(String[] args) {
    int[] arr = {2, 5, 2, 1, 1, 1};
    System.out.println(new DistributeCandy().candy(arr));
  }

  public int candy(int[] a) {
    int minCandies = 0;
    int[] minCandyArr = new int[a.length];
    int len = a.length;
    minCandyArr[0] = 1;

    for (int i = 1; i < a.length; i++) {
      if(a[i]>a[i-1]){
        minCandyArr[i] = minCandyArr[i-1]+1;
      }else{
        minCandyArr[i] = 1;
      }
    }

    minCandyArr[len-1] = Math.max(minCandyArr[len-1], 1);

    for (int i = len-2; i >= 0; i--) {
      if(a[i]>a[i+1]){
        minCandyArr[i] = Math.max(minCandyArr[i+1]+1, minCandyArr[i]);
      }
    }

    for (int n : minCandyArr) {
      minCandies += n;
    }

    return minCandies;
  }
}
