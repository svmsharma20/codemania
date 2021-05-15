package edu.interview_bit.math;

import java.util.ArrayList;

public class NumbersOfLengthNAndValueLessThanK {

    public static void main(String[] args) {
        int[] arr = { 0, 1, 3, 4, 6, 7 };
        int len = 4;
        int num = 59172;

        ArrayList<Integer> arrList = new ArrayList<>();
        for (int n : arr) {
            arrList.add(n);
        }

        System.out.println(new NumbersOfLengthNAndValueLessThanK().solve(arrList, len, num));
    }

    // https://www.youtube.com/watch?v=MT8zeLak_bI&t=1048s
    public int solve(ArrayList<Integer> A, int len, int maxNum) {

        if(A==null || A.size()==0){
            return 0;
        }

        int temp=maxNum;
        int lenOfMaxNum=0;
        int ans=0;

        while(temp>0){
            lenOfMaxNum++;
            temp /= 10;
        }

        if(len>lenOfMaxNum){
            return 0;
        }else if(len<lenOfMaxNum){
            if(A.get(0)==0){
                ans = (A.size()-1) * pow(A.size(),len-1);
                if(len==1){
                    // if possible length is 1 then '0' is also a valid number at first and only place.
                    ans++;
                }
            }else{
                ans = pow(A.size(), len);
            }
        }else{
            // len == lenOfMaxNum
            if(len==1){
                for(int i=0; i<A.size(); i++){
                    if(A.get(i)<maxNum){ ans++;	}
                }
            }else{
                sort(A,0, A.size()-1);

                // convert maxNum in array form for easy access
                int[] numDigit = new int[lenOfMaxNum];
                for(int i=lenOfMaxNum-1; i>=0; i--){
                    numDigit[i] = maxNum%10;
                    maxNum /= 10;
                }

                // count number of digits possible for first place from left
                int count=0;
                for(int n : A){
                    if(n==0){continue;}
                    if(n>numDigit[0]){break;}
                    count++;
                }

                // total numbers possible of given length starting with the first digit of maxNum.
                // if first digit of maxNum is not present in A then smaller than that.
                ans = count * pow(A.size(), len-1);

                boolean flag = false;
                int j=0;
                for(int i=0; i<A.size(); i++){
                    if(A.get(i)==numDigit[j]){
                        flag=true;
                        break;
                    }
                }
                j++;

                while(flag && j<=len-1){
                    flag = false;
                    int countx = 0;
                    for(int i=0; i<A.size(); i++){
                        if(A.get(i)>numDigit[j]){countx++;}
                        if(A.get(i)==numDigit[j]){flag=true;}
                    }
                    ans -= countx * pow(A.size(), len-j-1);
                    j++;
                }

                if(j==len && flag) { ans--; }
            }
        }
        return ans;
    }

    private void sort(ArrayList<Integer> list, int start, int end){
        if(start==end){
            return;
        }

        int mid = (start + end)/2;
        sort(list, start, mid);
        sort(list, mid+1, end);

        int i=start;
        int j=mid+1;

        ArrayList<Integer> temp  = new ArrayList<>();

        while(i<=mid && j<=end){
            if(list.get(i)<= list.get(j)){
                temp.add(list.get(i));
                i++;
            }else{
                temp.add(list.get(j));
                j++;
            }
        }

        while(i<=mid){
            temp.add(list.get(i));
            i++;
        }

        while(j<=end){
            temp.add(list.get(j));
            j++;
        }

        for (int p =0, q=start; p < temp.size() && q<=end; p++, q++) {
            list.set(q,temp.get(p));
        }
    }

    private int pow(int a, int n){
        int res=1;
        int pow = a;
        while(n>0){
            if((n&1) > 0){
                res *= pow;
            }

            pow = pow * pow;
             n >>= 1;
        }

        return res;
    }
}
