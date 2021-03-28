package edu.interview_bit.math;

public class ExcelColumnTitle {
    public String convertToTitle(int A) {
        String title ="";
        while(A>0){
            A--;
            char rem =(char)(A%26+65);
            title = rem+title;
            A /= 26;
        }
        
        return title;
    }
}
