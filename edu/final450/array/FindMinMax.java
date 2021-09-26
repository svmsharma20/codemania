package edu.final450.array;

/*
 * https://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/
 * */
public class FindMinMax {

  static class Pair {

    int min;
    int max;

    public Pair(int min, int max) {
      this.min = min;
      this.max = max;
    }

    @Override
    public String toString() {
      return "Pair{" +
          "min=" + min +
          ", max=" + max +
          '}';
    }
  }

  public static void main(String[] args) {
    int[] arr = {1000, 25, 2, 98, 100, 3000};

    System.out.println(getMinMax(arr));
  }

  private static Pair getMinMax(int[] arr) {
    int min = 0;
    int max = 0;
    int i = 0;

    if (arr.length % 2 == 0) {
      if (arr[0] < arr[1]) {
        min = arr[0];
        max = arr[1];
      } else {
        min = arr[1];
        max = arr[0];
      }
      i = 2;
    } else {
      min = max = arr[0];
      i = 1;
    }

    while (i < arr.length) {
      if (arr[i] < arr[i + 1]) {
        min = arr[i] < min ? arr[i] : min;
        max = arr[i + 1] > max ? arr[i + 1] : max;
      } else {
        min = arr[i + 1] < min ? arr[i + 1] : min;
        max = arr[i] > max ? arr[i] : max;
      }
      i += 2;
    }

    return new Pair(min, max);
  }
}
