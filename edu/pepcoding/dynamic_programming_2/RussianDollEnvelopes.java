package edu.pepcoding.dynamic_programming_2;

import java.util.Scanner;

public class RussianDollEnvelopes {

  // https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/russian-doll-envelopes-official/ojquestion
  // https://youtu.be/Mud_QjUwbw8?list=TLGGnNRv6tMQQwoyMTA2MjAyMQ
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] width = new int[n];
    int[] height = new int[n];

    for (int i = 0; i < n; i++) {
      width[i] = sc.nextInt();
      height[i] = sc.nextInt();
    }

    System.out.println(getMaxCount(width, height));

    sc.close();
  }

  private static int getMaxCount(int[] width, int[] height) {
    sort(width, height, 0, width.length-1);

    int[] dp = new int[width.length];

    for (int i = 0; i < width.length; i++) {
      int max = 0;
      for (int j = 0; j < i; j++) {
        if(height[j]<height[i] && width[j]<width[i]){
          max = Math.max(max, dp[j]);
        }
      }

      dp[i] = max+1;
    }

    int maxCount = 0;
    for (int i = 0; i < dp.length; i++) {
      maxCount = Math.max(maxCount, dp[i]);
    }

    return maxCount;
  }

  private static void sort(int[] width, int[] height, int start, int end) {
    if(start==end){
      return;
    }

    int mid = start + (end-start)/2;
    sort(width, height, start, mid);
    sort(width, height, mid+1, end);

    int[] tempW = new int[width.length];
    int[] tempH = new int[height.length];

    int i=start;
    int j=mid+1;
    int k=0;

    while (i<=mid && j<=end){
      if(width[i]<=width[j]){
        tempW[k] = width[i];
        tempH[k] = height[i];
        i++;
      }else {
        tempW[k] = width[j];
        tempH[k] = height[j];
        j++;
      }
      k++;
    }

    while(i<=mid){
      tempW[k] = width[i];
      tempH[k] = height[i];
      i++;
      k++;
    }

    while (j<=end){
      tempW[k] = width[j];
      tempH[k] = height[j];
      j++;
      k++;
    }

    for (int p = 0, q = start; p < width.length && q <= end; p++, q++) {
      width[q] = tempW[p];
      height[q] = tempH[p];
    }
  }
}
