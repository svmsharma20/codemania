/*
*   Ques: https://practice.geeksforgeeks.org/problems/subarray-with-given-sum/0/?category[]=Arrays&company[]=Amazon&company[]=Microsoft&company[]=Google&page=1&sortBy=submissions&query=category[]Arrayscompany[]Amazoncompany[]Microsoftcompany[]Googlepage1sortBysubmissions
*/

package edu.concepts.array;

import java.util.Scanner;

public class SubarrayWithGivenSum {
    public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int p=0; p<t; p++){
		    int n = sc.nextInt();
		    int s = sc.nextInt();
		    int[] a = new int[n];
		    for(int q=0; q<a.length; q++){
		        a[q] = sc.nextInt();
		    }
		    
		    int i=0;
		    int j=1;
		    int sum = a[i];
		    if(sum == s){
                System.out.println(String.format("%d %d",0,0));
                
		    }
		    boolean isFound = false;
		    while(j<=a.length){
		        if(sum==s){
                    System.out.println(String.format("%d %d",i+1,j));
                    isFound = true;
                    break;
		        }else if(sum<s){
		            sum += a[j];
		            j++;
		        }else{
		            sum -= a[i];
		            i++;
		        }
		    }
            
            if(!isFound){
                System.out.println(-1);
            }
		        
        }
        sc.close();
	}
}
