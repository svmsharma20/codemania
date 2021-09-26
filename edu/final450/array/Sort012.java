package edu.final450.array;

/*
 * https://practice.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1
 * */
public class Sort012 {

  public static void sort012(int arr[], int n) {
    int i = -1;
    int k = n;
    int j = 0;

    while (j < k) {
      if (i < j && arr[j] == 0) {
        i++;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      } else if (j < k && arr[j] == 2) {
        k--;
        int temp = arr[k];
        arr[k] = arr[j];
        arr[j] = temp;
      } else {
        j++;
      }
    }
  }
}
