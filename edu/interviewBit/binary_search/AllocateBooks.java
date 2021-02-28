package edu.interviewBit.binary_search;

public class AllocateBooks {
    // https://www.youtube.com/watch?v=2JSQIhPcHQg
    
    public int books(int[] arr, int totalAvailableStudents) {
        if(arr==null || arr.length==0 || arr.length<totalAvailableStudents){
            return -1;
        }
        
        int maxPage = 0;
        int totalPages = 0;
        
        for(int i=0; i<arr.length; i++){
            if(arr[i]>maxPage){
                maxPage = arr[i];
            }
            totalPages += arr[i];
        }
        
        int start = maxPage;         // Atlesat one book will get allocated to a student, so the number of pages will be book with max page among all books or greater.
        int end = totalPages;        // all the books get allocated to one student when totalNumber of student is 1 only
        
        int result = -1;
        
        
        while(start<=end){
            int mid = start + (end-start)/2;
            if(isAllocatable(arr, totalAvailableStudents, mid)){
                result = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        
        return result;
        
    }
    
    private boolean isAllocatable(int[] arr, int totalAvailableStudents, int maxPages){
        int studentCount = 1;
        int sum = 0;
        
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
            if(sum>maxPages){
                studentCount++;
                sum = arr[i];
            }
            if(studentCount>totalAvailableStudents){
                return false;
            }
        }
        
        return true;
    }
}
