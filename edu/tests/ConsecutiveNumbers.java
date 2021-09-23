package edu.tests;

import java.util.HashSet;

public class ConsecutiveNumbers {

  public static void main(String[] args) {
    int[] arr = {14, 13, 14, 12, 11, 15};
    System.out.println(isConsecutiveConstantSpace(arr));
  }

  private static int isConsecutive(int[] arr) {
    HashSet<Integer> set = new HashSet<>();
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < arr.length; i++) {
      set.add(arr[i]);
      min = Math.min(min, arr[i]);
    }

    for (int i = 0; i < set.size(); i++) {
      if (!set.contains(min + i)) {
        return 0;
      }
    }

    return set.size() == arr.length ? 1 : 0;
  }

  private static int isConsecutiveConstantSpace(int[] arr) {
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < arr.length; i++) {
      min = min > arr[i] ? arr[i] : min;
    }
    int i = 0;
    int len = arr.length;

    while (i < arr.length) {
      if ((arr[i] - min + 1) != i) {
        int swapIndex = (arr[i] - min + 1) % len;
        if (swapIndex < 0 && swapIndex > arr.length) {
          return 0;
        }
        int intAtSwapIndex = arr[swapIndex];
        if ((intAtSwapIndex - min + 1) % len != swapIndex) {
          arr[swapIndex] = arr[i];
          arr[i] = intAtSwapIndex;
        } else {
          i++;
        }
      } else {
        i++;
      }
    }
    i = 0;
    boolean flag = false;
    while (i < arr.length && (arr[i] - min + 1) % len != i) {
      i++;
    }
    if (i == 0) {
      flag = true;
    }
    while (i < arr.length && (arr[i] - min + 1) % len == i) {
      i++;
    }

    if (!flag) {
      while (i < arr.length && (arr[i] - min + 1) % len != i) {
        i++;
      }
    }

    if (i != arr.length) {
      return 0;
    }

    return 1;
  }

}

