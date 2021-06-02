package edu.interview_bit.greedy_algorithms;

import java.util.ArrayList;

public class Seats {

  public static void main(String[] args) {
    String seats = "....x..xx...x..";
    System.out.println(new Seats().seats(seats));
  }

  // https://www.youtube.com/watch?v=SK2ypa7poKg
  public int seats(String seats) {

    long minJumpReq = 0;
    ArrayList<Integer> seatIndex = new ArrayList<>();

    for (int i = 0; i < seats.length(); i++) {
      if(seats.charAt(i)=='x'){
        seatIndex.add(i);
      }
    }
    int size = seatIndex.size();
    if(size==0){
      return 0;
    }
    int median= size/2;
    int centerPosition = seatIndex.get(median);
    int indexFromSittingWillStart = centerPosition - median;
    /*
     * Total number of persons sitting are  = size of seatIndex
     * When they will seat together, median person will be in the center.
     * */

    for (int i = 0; i < size; i++) {
      int startPosition = seatIndex.get(i);
      int endPosition = indexFromSittingWillStart + i;
      minJumpReq += Math.abs(endPosition-startPosition);
      minJumpReq %= 10000003;
    }

    return (int)minJumpReq;

  }
}
