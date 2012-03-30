package solutions;

import util.*;
/*
 * Project Euler Solution
 * Problem 0003
 * @author Alastair Games
 *
 * License: MIT
 */
public class Problem0003 {

    public static void main(String[] args){
        long v = 600851475143L;
        long[] primes = PrimeSolver.factor(v);
        System.out.println(ArrayUtil.max(primes));
    }
}