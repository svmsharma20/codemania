package edu.array;

public class MaximumSumSubArrayUsingDivideAndConquer {
    public static void main(String[] args) {
        int[] array = {5, -3, 2, -1, -2, 6, -5, -3};
        // System.out.println("Max: "+getMax(array));

        System.out.println(uniquePaths(3, 7));

    }

    static int getMax(int[] nums){
        return getMaxRecur(nums, 0, nums.length-1);
    }

    static int getMaxRecur(int[] nums, int i, int j){
        if(i==j){
            return nums[i];
        }
        int mid = (i+j)/2;
        int lss = getMaxRecur(nums,i, mid );
        int rss = getMaxRecur(nums, mid+1, j);
        int css =  lss + rss;

        return Math.max(css, Math.max(lss, rss));
    }

    static int uniquePaths(int m, int n) {
        if(m == 1 || n == 1)
            return 1;
        m--;
        n--;
        if(m < n) {              // Swap, so that m is the bigger number
            m = m + n;
            n = m - n;
            m = m - n;
        }
        long res = 1;
        int j = 1;
        for(int i = m+1; i <= m+n; i++, j++){       // Instead of taking factorial, keep on multiply & divide
            res *= i;
            res /= j;
        }
            
        return (int)res;
    }
}
