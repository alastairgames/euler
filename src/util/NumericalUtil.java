package util;

import java.util.Arrays;

/**
 *
 * @author aurix
 */
public final class NumericalUtil {


    public static boolean isPalindrome(long n){
        int length = (int) Math.ceil(Math.log10(n));
        int[] digits = new int[length];
        long temp = n;

        for (int i = 0; i < digits.length;i++){
            digits[i] = (int)(temp % 10);
            temp = temp - digits[i];
            temp = temp / 10;
        }

        //if the number is equal to its reverse then it's a palindrome.
        int[] reverse = new int[digits.length];
        System.arraycopy(digits, 0, reverse, 0, digits.length);
        ArrayUtil.swap(reverse);
        
        return Arrays.equals(digits, reverse);
    }
    
}