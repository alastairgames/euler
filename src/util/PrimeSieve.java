package util;

import java.util.Arrays;

/**
 * Prime sieve.
 *
 * License: MIT
 */
public final class PrimeSieve {
    
    private static final int[] PRIMES_UNDER_TEN = { 2, 3, 5, 7 };
    
    /* Based on Euler's sieve, described at
     * http://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
     */
    public static void main(String[] args){
        int[] s = sieve(100);
        for (int i : s)
            System.out.println(i);
    }
    
    
    /**Returns all the primes up to but not including max. */
    public static int[] sieve(int max){
        int[] primes = PRIMES_UNDER_TEN;
        int scale = 10;
        //as I know all the primes under x, I can safely evaluate
        //every number up to x^2. This grows very quickly using 10.
        while (scale < max)
        {
            scale = scale * scale;
            primes = sieve(primes,Math.min(max,scale));
        }
        
        if (max > 11) //11 and not 10 because sieve(11) returns primes under 10 because it does nto include max.
            return primes;
        else if (max < 10)
            return Arrays.copyOfRange(PRIMES_UNDER_TEN, 0, Arrays.binarySearch(PRIMES_UNDER_TEN, max));
        else
            return PRIMES_UNDER_TEN; 
    }
    
    private static int[] sieve(int[] primes, int max){
        boolean[] isPrime = new boolean[max];
        Arrays.fill(isPrime, true);
        
        //remove 0 and 1
        isPrime[0] = false;
        isPrime[1] = false;
        
        for (int i = 0; i < primes.length ; i++)
            for (int j = primes[i]*primes[i] ; j < max ; j+= primes[i])
                isPrime[j] = false;
        
        //count the number of primes
        int count = 0;
        for (int k = 0; k < isPrime.length; k++)
            if (isPrime[k])
                count++;
        
        //store these primes
        int[] foundPrimes = new int[count];
        int index = 0;
        for (int m = 0; m < isPrime.length;m++){
            if (isPrime[m]){
                foundPrimes[index] = m;
                index++;
            }
        }
        
        return foundPrimes;
    }
}
