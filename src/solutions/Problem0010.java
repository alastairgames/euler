package solutions;

import util.PrimeSieve;

/**
 * Project Euler Solution
 * Problem 0010
 * @author Alastair Games
 *
 * License: MIT
 */
public class Problem0010 {
      
    private static final int VALUE = 2000000;
    
    public static void main(String[] args){
        int[] primes = PrimeSieve.sieve(VALUE);
        long total = 0L;
        for (int i = 0; i < primes.length;i++)
            total += primes[i];
        System.out.println(total);
    }
}