package edu.interviewBit.string;

public class AmazingSubarrays {
    
    public static void main(String[] args) {
        System.out.println(new AmazingSubarrays().solve("ABEeCD"));
    }

    public int solve(String A) {
        int index=0;
        int count=0;
        int len=A.length();
        
        while(index<len){
            char ch = A.charAt(index);
            if(ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U' || ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                count += (len-index);
                count %= 10003;
            }
            index++;
        }
        
        return count;
    }

}
