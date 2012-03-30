package solutions;

import util.*;
/*
 * Project Euler Solution
 * Problem 0004
 * @author Alastair Games
 *
 * License: MIT
 */
public class Problem0004 {

    public static void main(String[] args){
        long maxPalidrome = 0;
        long temp;

        //by starting the inner loop at the current position of the
        //outer loop, I can reduce the number of calcuations in half.
        //this is because a * b = b * a;
        //it is made clear in a multiplication table:

        //  x   100 101 102
        //  100 o   x   x
        //  101 o   o   x
        //  102 o   o   o

        for (int i = 100; i <=999;i++)
            for (int j = i;j <=999;j++){
                temp = i * j;
                if (NumericalUtil.isPalindrome(temp) && temp > maxPalidrome)
                    maxPalidrome = temp;
            }

        System.out.println(maxPalidrome);
    }
}