package edu.array.leetcode;

public class MedianOfTwoSortedArray {
    
    public static void main(String[] args) {
        int[] nums1 = {1,3};        
        int[] nums2 = {2};
        
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        //         if(nums1 == null || nums1.length ==0){
        //             if(nums2 != null){
        //                 if(nums2.length%2==0){
        //                     return (nums2[(nums2.length/2)-1] + nums2[nums2.length/2])/2;
        //                 }else{
        //                     return nums2[nums2.length/2];
        //                 }
        //             }else{
        //                 return 0.0d;
        //             }
        //         }
                
        //         if(nums2 == null || nums2.length ==0){
        //             if(nums1 != null){
        //                 if(nums1.length%2==0){
        //                     return (nums1[(nums1.length/2)-1] + nums1[nums1.length/2])/2;
        //                 }else{
        //                     return nums1[nums1.length/2];
        //                 }
        //             }else{
        //                 return 0.0d;
        //             }
        //         }
                
                int m = nums1.length;
                int n = nums2.length;
        
                if(n<m){
                    int[] tempArr = nums1;
                    nums1 = nums2;
                    nums2 = tempArr;
                    
                    int temp = m;
                    m = n;
                    n = temp;
                }
                
                int sizeOfLeftHalf = (m+n+1)/2;
                int low = 0;
                int high = m;
                
                
                while(low<=high){
                    int mid = (low+high)/2;
                    int secondMid = sizeOfLeftHalf - mid;
                    
                    
                    int x = (mid>0) ? nums1[mid-1] : -1;
                    int y = (secondMid>0) ? nums2[secondMid-1] : -1;
                    int xp = (mid<m) ? nums1[mid] : -1;
                    int yp = (secondMid<n) ? nums2[secondMid] : -1;
                    
                    int expectedMedian = 0;
                    
                    if(x>yp && yp != -1){
                        high = mid-1;
                    }else if(y > xp && xp != -1){
                        low = mid+1;
                    }else{
                        
                        if(x==-1){
                            expectedMedian = y;
                        }else if(y==-1){
                            expectedMedian = x;
                        }else{
                            expectedMedian = Math.max(x,y);
                        }
                        
                        if((m+n) % 2 == 1){
                            return expectedMedian;
                        }
                    
                        return (expectedMedian + Math.min(xp, yp))/2.0;
                    
                    }
                    
                }
                
                return -2;
            }
}
