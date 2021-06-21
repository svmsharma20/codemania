package edu.pepcoding.dynamic_programming_2;

import java.util.Scanner;

public class MaximumNonOverlappingBridges {

  // https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/max-non-overlapping-bridges-official/ojquestion
  // https://www.youtube.com/watch?v=o1h3aoeSTOU&list=TLGGgByTZQF3j1oyMTA2MjAyMQ
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int[] north = new int[n];
    int[] south = new int[n];

    for (int i = 0; i < n; i++) {
      north[i] = sc.nextInt();
      south[i] = sc.nextInt();
    }

    System.out.println(getMaxNonOverlappingBridges(north, south));
  }

  private static int getMaxNonOverlappingBridges(int[] north, int[] south) {
    sort(north, south, 0, north.length-1);

    int[] dp = new int[north.length];

    for (int i = 0; i < north.length; i++) {
      int max = 0;
      for (int j = 0; j < i; j++) {
        if(south[j]<south[i]){
          max = Math.max(max, dp[j]);
        }
      }
      dp[i] = max + 1;
    }

    int maxCount = 0;
    for (int i = 0; i < dp.length; i++) {
      maxCount = Math.max(maxCount, dp[i]);
    }

    return maxCount;
  }

  private static void sort(int[] north, int[] south, int start, int end) {
    if(start==end){
      return;
    }

    int mid = start + (end - start)/2;
    sort(north, south, start, mid);
    sort(north, south, mid+1, end);

    int[] tempN = new int[end-start+1];
    int[] tempS = new int[end-start+1];

    int i = start;
    int j = mid+1;
    int k = 0;

    while(i<=mid && j<=end){
      if(north[i]<north[j]){
        tempN[k] = north[i];
        tempS[k] = south[i];
        i++;
      }else if (north[i]>north[j]){
        tempN[k] = north[j];
        tempS[k] = south[j];
        j++;
      }else{
        // If north point are same consider south
        if(south[i]<south[j]){
          tempN[k] = north[i];
          tempS[k] = south[i];
          i++;
        }else{
          tempN[k] = north[j];
          tempS[k] = south[j];
          j++;
        }
      }
      k++;
    }

    while(i<=mid){
      tempN[k] = north[i];
      tempS[k] = south[i];
      i++;
      k++;
    }

    while(j<=end){
      tempN[k] = north[j];
      tempS[k] = south[j];
      j++;
      k++;
    }

    for (int p = 0, q=start; p < tempN.length && q<=end; p++, q++) {
      north[q] = tempN[p];
      south[q] = tempS[p];
    }
  }
}
