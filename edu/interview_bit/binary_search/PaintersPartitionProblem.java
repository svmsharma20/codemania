package edu.interview_bit.binary_search;

public class PaintersPartitionProblem {
    
    long MOD = 10000003;

    public static void main(String[] args) {
        int noOfPainters = 1;
        int timeTakenToPainPerUnit = 1000000;
        int[] board = {1000000, 1000000};

        System.out.println(new PaintersPartitionProblem().paint(noOfPainters, timeTakenToPainPerUnit, board));
    }


    public int paint(int noOfPainters, int timeTakenToPainPerUnit, int[] board) {
        
        long maxTime = 0;
        long totalTimeRequired = 0;
        
        for(int i=0; i<board.length; i++){
            if(maxTime<board[i]){
                maxTime=board[i];
            }
            totalTimeRequired = (totalTimeRequired + board[i])%MOD;
        }
        
        if(noOfPainters==1){
            return (int)((totalTimeRequired*timeTakenToPainPerUnit)%MOD);
        }
        
        long leastTime = maxTime;
        long atmostTime = (int)totalTimeRequired;
        long result = 0;
        
        while(leastTime<=atmostTime){
            long mid = leastTime + (atmostTime-leastTime)/2;
            
            if(isFeasibleToPaint(board, mid, noOfPainters)){
                result = mid;
                atmostTime = mid-1;
            }else{
                leastTime = mid+1;
            }
        }
        
        return (int)(( (result%MOD)* (timeTakenToPainPerUnit%MOD) )%MOD);
    }
    
    
    private boolean isFeasibleToPaint(int[] board, long timeLimit, int noOfPainters){
        int painterCount = 1;
        long totalTime = 0;
        
        for(int i=0; i<board.length; i++){
            totalTime = (totalTime + board[i]) %MOD;
            if(totalTime>timeLimit){
                painterCount++;
                totalTime = board[i];
            }
            
            if(painterCount>noOfPainters){
                return false;
            }
        }
        
        return true;
    }
}
