package edu.interview_bit.array;

import java.util.ArrayList;

public class MinimumLightsToActivate {

    // https://www.youtube.com/watch?v=CQ0Tlu3o7Yg
    // There is bug in the video(in the inner loop while condition; j<A.size() should not be present there),
    // but this algo has resolve that as well, by moving it to if condition.

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(0);
        list.add(1);
        list.add(1);
        list.add(0);
        list.add(0);
        list.add(1);

        System.out.println(new MinimumLightsToActivate().solveWithMoreSimpleCode(list, 3));

    }

    public int solveWithMoreSimpleCode(ArrayList<Integer> A, int B) {
        int i=0;
        int count=0;

        while (i<A.size()){
            int j = i+(B-1);
            boolean isBulbFound = false;

            while (j>=(i-B+1) && j>=0){
                /*
                * The first condition tells that j is currently out of range as compare to size fo the array list
                * But, it might come after some iteration.
                * This will happen in below case:
                *
                *   A: [0, 1, 0, 1, 1, 0, 0, 1]
                *   B: 3  // power of the bulb
                *
                * In this case, we will enlighten bulb at 1st and 4th index.
                * After that, bulb at 7th index is still off and also not getting light.
                * In this scenario j=i+(B-1) => j=7+(3-1) => j=9
                *
                * So we have to wait until j becomes less than A.size()
                * */

                if(j<A.size() && A.get(j)==1){
                    count++;
                    i = j+B;
                    isBulbFound = true;
                    break;
                }
                j--;
            }

            if(!isBulbFound){
                return -1;
            }
        }

        return count;
    }


    public int solve(ArrayList<Integer> A, int B) {
        
        if(A==null || A.size()==0){
            return 0;
        }
        
        int size = A.size();
        int count = 0;
        int current=0;
        
        while(current<size){
            int left = -1;
            int right = -1;
            
            for(int i=0; i<B; i++){
                if(current-i < 0){
                    continue;
                }
                if(A.get(current-i) == 1){
                    left = current-i;
                    break;
                }
            }
            
            for(int i=B-1; i>0; i--){
                if(current+i>size){
                    continue;
                }
                if(A.get(current+i) == 1){
                    right = current+i;
                    break;
                }
            }
            
            if(left == -1 && right == -1){
                return -1;
            }else if(right != -1){
                count++;
                current = right+B;
            }else {
                count++;
                current = left+B;
            }
        }
        
        return count;
    }

}
