package edu.interview_bit.array;

import java.util.ArrayList;

public class SpiralOrderMatrix_II {
    
    public ArrayList<ArrayList<Integer>> generateMatrix(int A) {
        
        int[][] matrix = new int[A][A];
        
        int left=0;
        int right=A-1;
        int top=0;
        int down=A-1;
        
        int dir=0;  // 0 -> right, 1 -> down, 2 -> left, 3 -> top
        int n=1;
        
        while(top<=down && left<=right){
            switch(dir){
                case 0:
                    for(int i=left; i<=right; i++){
                        matrix[top][i] = n;
                        n++;
                    }
                    top++;
                    dir=1;
                    break;
                
                case 1:
                    for(int i=top; i<=down; i++){
                        matrix[i][right] = n;
                        n++;
                    }
                    right--;
                    dir=2;
                    break;
                    
                case 2:
                    for(int i=right; i>=left; i--){
                        matrix[down][i] = n;
                        n++;
                    }
                    down--;
                    dir=3;
                    break;
                
                case 3:
                    for(int i=down; i>=top; i--){
                        matrix[i][left] = n;
                        n++;
                    }
                    left++;
                    dir=0;
                    break;
            }
        }
        
        ArrayList<ArrayList<Integer>> spiralList = new ArrayList<>();
        
        for(int i=0; i<A; i++){
            ArrayList<Integer> l = new ArrayList<>();
            for(int j=0; j<A; j++){
                l.add(matrix[i][j]);
            }
            spiralList.add(l);
        }
        
        return spiralList;
    }

}
