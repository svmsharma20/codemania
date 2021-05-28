package edu.concepts.sorting;

public class InsertionSort {

  public static void main(String[] args) {
    int[] arr = {2, 5, 1, 7, 10, 4, 3, 8, 9, 6};
    new InsertionSort().sort(arr);
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }

  private void sort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      int index = i;
      int value = arr[i];
      while (index>0 && arr[index-1]>value){
        arr[index] = arr[index-1];
        index--;
      }
      arr[index] = value;
    }
  }

}
