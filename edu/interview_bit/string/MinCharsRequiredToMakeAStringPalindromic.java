package edu.interview_bit.string;

public class MinCharsRequiredToMakeAStringPalindromic {

    public static void main(String[] args) {
        String str = "ACECAAAA";
        System.out.println(getPalindromicString(str));
    }

    private static int getPalindromicString(String input) {

        /*
        *   Intuition:
        *   To minimize the number of characters to prepend to make the whole string palindromic,
        *   we should use any existing palindromic sequence if it is already present in the input.
        *
        *   So now, there are two cases:
        *   CASE 1: Palindromic sequence is not present in the input string. e.g.: "abcdef"
        *           then, we just have to clone and reverse the input string from [1st index to (n-1)th index] and prepend it.
        *
        *   CASE 2: Palindromic sequence is present in the input string:
        *           CASE a:  Palindromic sequence is present at the end of the string e.g.: "xyaba"
        *                    Since we can only prepend and can't perform append;
        *                    we can't use the palindromic sequence("aba") present in the input string
        *
        *           CASE b: Palindromic sequence is present in the middle of the input string. e.g.: "xabay"
        *                    Again, since we can only prepend and can't perform append,
        *                    we can't use the palindromic sequence("aba") present in the input string
        *
        *           CASE c: Palindromic string is present at the start of the input string. e.g.: "abaxy"
        *                    We can use the starting palindromic sequence and,
        *                    just have to prepend the characters who are not part of palindromic sequence in reverse order
        *                    which in above case will be "xy" so the final string will look like => "yxabaxy"
        *                    so we have added 2 characters at the beginning of the string.
        *
        *   Conclusion:
        *   So overall, we just have take care about the case where a palindromic sequence is present at the beginning of the input string.
        *
        * */
        int left=0;
        int right=input.length()-1;
        int count = 0;

        while(left < right){
            if(input.charAt(left) == input.charAt(right)){
                left++;
                right--;
            }else{
                if(left == 0) {
                    count++;
                    right--;
                }
                else {
                    count += left;
                    left = 0;
                }

            }
        }

        return count;
    }

}
