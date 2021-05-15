package edu.interview_bit.math;

public class CityTour {

    // https://www.youtube.com/watch?v=fUS9G-WG9SQ

    static long MODULO = 1000000007;
    
    public int solve(int totalCities, int[] citiesAlreadyVisited) {
        sort(citiesAlreadyVisited, 0, citiesAlreadyVisited.length-1);
        
        int citiesYetToVisit = totalCities - citiesAlreadyVisited.length;
        
        int previousCity=0;
        int i=0;
        int citiesInBetween = citiesAlreadyVisited[i] - previousCity - 1;
        long result = getFactorial(citiesYetToVisit) % MODULO;;
        if(citiesInBetween>0){
            result *= getModuloMultiplicativeInverse(getFactorial(citiesInBetween))%MODULO;
            result %= MODULO;    
        }
        previousCity = citiesAlreadyVisited[i];
        i++;
        
        while(i<citiesAlreadyVisited.length){
            citiesInBetween = citiesAlreadyVisited[i] - previousCity - 1;
            result = ( result * (getModuloMultiplicativeInverse(getFactorial(citiesInBetween)))%MODULO) % MODULO;
            result = ( result * (pow(2, citiesInBetween-1))%MODULO ) %MODULO;
            previousCity = citiesAlreadyVisited[i];
            i++;
        }
        
        if(previousCity<totalCities){
            citiesInBetween = totalCities - previousCity;
            result *= getModuloMultiplicativeInverse(getFactorial(citiesInBetween)) % MODULO; 
            result %= MODULO;
        }

        return (int)result;
    }
    
    private long getModuloMultiplicativeInverse(long a){
        return pow(a, MODULO-2);
    }
    
    private long pow(long a, long n){
        long res = 1;
        long pow = a;
        
        while(n>0){
            if((n&1)>0){
                res = ((res%MODULO) * (pow%MODULO)) % MODULO;
            }
            
            pow = ((pow%MODULO) * (pow%MODULO)) % MODULO;
            n >>= 1;
        }
        return res;
    }
    
    private long getFactorial(long n){
        long p = n;
        long res = 1;
        while(p>1){
            res = ((res%MODULO) * (p%MODULO)) % MODULO ;
            p--;
        }
        
        return res;
    }
    
    private void sort(int[] arr, int start, int end){
        if(start==end){
            return;
        }
        
        int mid = start + (end-start)/2;
        sort(arr, start, mid);
        sort(arr, mid+1, end);
        
        int i=start;
        int j=mid+1;
        int k=0;
        int[] temp = new int[end-start+1];
        
        while(i<=mid && j<=end){
            if(arr[i] <= arr[j]){
                temp[k] = arr[i];
                i++;
            }else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        
        while(i<=mid){
            temp[k] = arr[i];
            i++;
            k++;
        }
        
        while(j<=end){
            temp[k] = arr[j];
            j++;
            k++;
        }
        
        for(int p=start, q=0; q<temp.length && p<=end; p++,q++){
            arr[p] = temp[q];
        }
    }
}
