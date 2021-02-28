
package edu.interviewBit.binary_search;

import java.util.Arrays;

/*

1)  Find the size of left half:
		size of left half = (m+n+1)/2;  {for both cases when total length is even or odd}
2)  Find no. of values contributed by A, that is find min no. of values contributed and max no. of values contributed by A.
3)  From (2) and (3) Find number of values contributed by B (total no values in left from (1) - total values contributed by A from (2))
4)  Let say x1 is the last value in A and x2 is next larger to x1 in A.
5)  Let say y1 is the last value in B and y2 is next larger to y1 in B.
6)  Condition for median is:
       (a) x1 is the median if:   y1<x1<y2 (x1 is greater than y1, but, smaller than y2 )
	   (b) y1 is the median if:   x1<y1<x2 (y1 is greater than x1, but, smaller than x2 )
7)  For condition (a) and (b)	
        if x1>y2 that means y2 will come first and later x1 will come, if A and B are merged in sorted form. 
        In other words A will contribute less in left half so lets minimize the A's contribution
			To do so now max1=mid-1
		else we will check next condition y1>x2 that means x2 will come first and later y1 will come, 
        if A and B are merged in sorted form. In other words B will contribute less in left half so lets maximize the A's contribution
			To do so now min=mid+1
		else we found our median
		    median = Max(x1, y1) in case of odd length of total array
			median = (x1+y1)/2 in case of even length of total array

*/

import java.util.List;

public class MedianOfArray {

    public static void main(String[] args) {
        // Integer[] arrA = {4, 20, 32, 50, 55, 61};
        // Integer[] arrB = {1, 15, 22, 30, 70, 75};

        // Integer[] arrA = { -43, -25, -18, -15, -10, 9, 39, 40 };
        // Integer[] arrB = { -2};

        Integer[] arrA = { -50, -42, -38, 1, 4, 9, 16, 33, 47 };
        Integer[] arrB = { -44};


        final List<Integer> a = Arrays.asList(arrA);
        final List<Integer> b = Arrays.asList(arrB);

        System.out.println(new MedianOfArray().findMedaian(a, b));
    }
    
    public double findMedaian(final List<Integer> a, final List<Integer> b){

        if(a==null || a.size()==0 || b==null || b.size()==0){
            if(a==null || a.size()==0){
                int sizeOfB = b.size();
                int mid = (sizeOfB+1)/2;
                if(sizeOfB%2==0){
                    return (b.get(mid-1) + b.get(mid))/2.0;
                }else{
                    return b.get(mid-1);
                }
            }else{
                int sizeOfA = a.size();
                int mid = (sizeOfA+1)/2;
                if(sizeOfA%2==0){
                    return (a.get(mid-1) + a.get(mid))/2.0;
                }else{
                    return a.get(mid-1);
                }
            }
        }


        List<Integer> A = a;
        List<Integer> B = b;    

        int aLen = A.size();
        int bLen = B.size();
        
        if(aLen>bLen){
            /*
            *   If A is larger than B, than, sawp the references, 
            *   because we going to do calculation from A's perspective and,
            *   time complexity will be smaller if size of A is as small as possible. 
            */

            A = b;
            B = a;
            aLen = A.size();
            bLen = B.size();
        }

        int leftHalfLen = (aLen+bLen+1)/2;

        /*
        *   Since A is guaranteed to be either shorter or of
        *   the same length as B, we know it can contribute 
        *   0 or all of its values to the left half of A ∪ B.
        */
        int aMinCount = 0;
        int aMaxCount = (leftHalfLen <=aLen) ? leftHalfLen : aLen;

        while(aMinCount <= aMaxCount){
            int aCount = aMinCount + (aMaxCount-aMinCount)/2;
            
            // if(aCount>aLen){
            //     aCount=aLen;
            // }
            
            int bCount = leftHalfLen-aCount;

            /*
            *   x1 can be null if A is not contributing any values to left half.
            *   e.g. A = [10, 11], B = [3, 4] 
            *   ⟹ left half = [3, 4], aCount = 0, bCount = 2.
            */
            double x1 = (aCount>0) ? A.get(aCount-1) : Double.NaN;

            /*
            *   y can be null if B is not contributing any values to left half.
            *   e.g. A = [3, 4], B = [10, 11] 
            *   ⟹ left half = [3, 4], aCount = 2, bCount = 0.
            */
            double y1 = (bCount>0) ? B.get(bCount-1) : Double.NaN;

            /*
            *   x2 can be null if A is contributing all of its values to left half, 
            *   i.e. aCount = A.Length.
            *   e.g. A = [3, 4], B = [10, 11] 
            *   ⟹ left half = [3, 4], aCount = 2, bCount = 0.
            */
            double x2 = (aCount<aLen) ? A.get(aCount) : Double.NaN;

            /*
            *   yP can be null if B is contributing all of its values to left half, 
            *   i.e. bCount = B.Length.
            *   e.g. A = [10, 11], B = [3, 4] 
            *   ⟹ left half = [3, 4], aCount = 0, bCount = 2.
            */
            double y2 = (bCount<bLen) ? B.get(bCount) : Double.NaN;

            if(x1>y2){
            
                // Decrease A's contribution size; x lies in the right half.
                aMaxCount = aCount-1;
            
            }else if(y1>x2){

                // Decrease B's contribution size, i.e. increase A's contribution size; 
                // y lies in the right half.
                aMinCount = aCount+1;

            }else{

                /*
                *   Neither x nor y lie beyond the left half. We found the right aCount.
                *   We don't know how x and y compare to each other yet though.
                */
                
                /*
                *   If aLen + bLen is odd, the median is the greater of x and y.
                *   Remember that either x or y can be null (if A or B is not contributing).
                */
                double leftHalfEnd = (Double.isNaN(x1)) ? y1 
                                                      : ( (Double.isNaN(y1)) ? x1 : Math.max(x1, y1) );
                                 

                // If total length is Odd
                if((aLen+bLen)%2==1){
                   return leftHalfEnd;
                }

                /*
                *   aLen + bLen is even. To compute the median, we need to find 
                *   the first element in the right half, which will be the smaller 
                *   of xP and yP. Remember that either xP or yP can be null (if all 
                *   the values of A or B are in the left half).
                */
                double rightHalfStart = (Double.isNaN(x2)) ? y2 
                                                         : ( (Double.isNaN(y2)) ? x2 : Math.min(x2, y2) );

                return (leftHalfEnd+rightHalfStart)/2;
            }
        }

        return 0.0;
    }
}
