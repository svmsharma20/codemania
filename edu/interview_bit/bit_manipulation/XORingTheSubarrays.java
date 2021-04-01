package edu.interview_bit.bit_manipulation;

public class XORingTheSubarrays {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(getXoringOfTheSubarrays(arr));
    }

    /*
    *   How (n-i)*(i+1) formula came?
    *
    *   Lets consider an array and we are trying to find the total occurrence of the ith element.
    *   For which we have to find all the subarry which contains ith element.
    *   And the position of ith element is like : [1st, 2nd, ... ith,(i+1),...(n-1),nth]
    *
    *   (1) Lets consider all the subarrays which starts at ith element are:
    *       subarray1 = [ith element]
    *       subarray2 = [i to (i+1)]elements
    *       subarray3 = [i to (i+2)]elements
    *                   .
    *                   .
    *       subarrayith = [i to n]elements
    *
    *       So total number of times ith contributed in it is (n-i) times;            (equ 1)
    *
    *   (2) Any subarray start before ith element and ends after ith element will also contains ith element,
    *       Those subarrays are:
    *
    *       All the subarray ends at (i+1)th element:
    *       subarray1 = [i to (i+1)]elements
    *       subarray2 = [(i-1) to (i+1)]elements
    *       subarray1 = [(i-2) to (i+1)]elements
    *                   .
    *                   .
    *       subarrayith = [1 to (i+1)]elements
    *       Total count for above is = i
    *
    *
    *
    *       Similary All the subarray ends at (i+2)th element::
    *       subarray1 = [i to (i+2)]elements
    *       subarray2 = [(i-1) to (i+2)]elements
    *       subarray1 = [(i-2) to (i+2)]elements
    *                   .
    *                   .
    *       subarrayith = [1 to (i+2)]elements
    *       Total count for above is = i
    *
    *       So, There will be (n-i) elements after i, and each will contribute i times,
    *       So total will be [i*(n-i)] times.                                                 (equ 2)
    *
    *       So total number of contribution by i will be from (equ 1) and (equ 2):
    *               (n-i) + i*(n-i)
    *           ==> (n-i)*(i+1)
    *
    * */
    private static int getXoringOfTheSubarrays(int[] arr) {
        int n = arr.length;
        int xor = 0;

        /*
        * As we know a ⊕ a = 0. When we write all substrings, we have to check how many numbers occur an even number of times and
        * how many numbers occur an odd number of times. If a number occured even number of times then it will cancel himself out
        * and, will contribute nothing. So only the elements which will occur odd times will contribute to final answer.
        *
        * From above formula, the number at ith index will occur (i + 1) * (N - i) times.
        *
        * if N is even:
        *     1) if i is even, then (N - i) will also be even since (even - even = even) and,
        *         So (i + 1) * (N - i) will also be even because product of any number with an even number will also be an even number.
        *     2) If i is odd, then (i + 1) will be even so (i + 1) * (N - i) will again even for the same above reason.
        *         So if N is even every element will contribute even number of times and will cancel himself out.
        *         And, the final ans will be 0.
        *
        * if N is odd:
        *     1) if i is even, then (N-i) will be odd since (even - odd = odd). Also, (i + 1) will be odd since i is even.
        *        So (i + 1) * (N - i) will be odd (since odd * odd = odd) and this element will contribute 1 time.
        *     2) if i is odd, then (i + 1) will be even so (i + 1) * (N - i) will again even for the same above reason.
        *        So if N is even every element will contribute even number of times and will cancel himself out.
        *        And the final ans will be 0.
        *
        * So finally if N is even the ans will be zero and if Nis odd only the even indexed element will contribute one time.
        *
        * */

        if(n%2==0){
            return 0;
        }
        for (int i = 0; i < arr.length; i+=2) {
            xor ^= arr[i];
        }

        return xor;
    }
}
