package edu.interviewBit.array;

import java.util.ArrayList;

public class MinStepsInInfiniteGrid {
    public int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
        if(A==null || A.size()==0 || B==null || B.size()==0){
            return 0;
        }
        
        int totalDistance = 0;
        
        for(int i=0; i< A.size()-1; i++){
            int differenceInXCoordinates = Math.abs(A.get(i)-A.get(i+1));
            int differenceInYCoordinates = Math.abs(B.get(i)-B.get(i+1));
            if(differenceInXCoordinates == differenceInYCoordinates){
                totalDistance += differenceInXCoordinates;
            }else if(differenceInXCoordinates < differenceInYCoordinates){
                totalDistance += differenceInXCoordinates ;
                if(B.get(i) > B.get(i+1)){
                    totalDistance += Math.abs(B.get(i)-B.get(i+1)-differenceInXCoordinates);
                }else{
                    totalDistance += Math.abs(B.get(i)-B.get(i+1)+differenceInXCoordinates);
                }
            }else {
                totalDistance += differenceInYCoordinates;
                if(A.get(i) > A.get(i+1)){
                    totalDistance += Math.abs(A.get(i)-A.get(i+1)-differenceInYCoordinates);
                }else{
                    totalDistance += Math.abs(A.get(i)-A.get(i+1)+differenceInYCoordinates);
                }
            }
        }
        
        return totalDistance;
    }
}
