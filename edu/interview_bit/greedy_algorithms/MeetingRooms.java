package edu.interview_bit.greedy_algorithms;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MeetingRooms {

  public static final int START_TIME = 0;
  public static final int END_TIME = 1;

  public int solveUsingPriorityQueue(ArrayList<ArrayList<Integer>> A) {
    if(A==null || A.isEmpty()){
      return 0;
    }

    java.util.Collections.sort(A, (a,b) -> a.get(START_TIME)-b.get(START_TIME) );

    PriorityQueue<ArrayList<Integer>> meetingRooms = new PriorityQueue<ArrayList<Integer>>( (a,b) -> a.get(1) - b.get(1));
    meetingRooms.add(A.get(0));

    for(int currentRoom=1; currentRoom<A.size(); currentRoom++){
      int startTimeOfCurrentRoom = A.get(currentRoom).get(START_TIME);
      ArrayList<Integer> earliestRoomAvailable = meetingRooms.remove();
      if(earliestRoomAvailable.get(END_TIME) <= startTimeOfCurrentRoom){
        earliestRoomAvailable = A.get(currentRoom);
      }else{
        meetingRooms.add(A.get(currentRoom));
      }

      meetingRooms.add(earliestRoomAvailable);
    }

    return meetingRooms.size();
  }

}
