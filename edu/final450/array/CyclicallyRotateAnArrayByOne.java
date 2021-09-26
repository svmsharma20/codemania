package edu.final450.array;

public class CyclicallyRotateAnArrayByOne {

  // generic solution
  public void rotate(int arr[], int n) {
    int left = 0;
    int right = n - 2;

    while (left < right) {
      int temp = arr[left];
      arr[left] = arr[right];
      arr[right] = temp;
      left++;
      right--;
    }

    left = 0;
    right = n - 1;

    while (left < right) {
      int temp = arr[left];
      arr[left] = arr[right];
      arr[right] = temp;
      left++;
      right--;
    }
  }
}
