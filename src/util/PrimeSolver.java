package util;

/**
 * A very simple prime number solver.
 *
 * License: MIT
 */
public final class PrimeSolver {

    public static void main(String[] args){
        for (int i = 2; i < 20; i++){
        System.out.println(""+i+isPrime(i));
        }
    }

    public static long[] factor(long n){
        LongVector v = new LongVector();

        long temp = n;

        //make the number odd
        while (temp % 2 == 0){
            temp = temp / 2;
            v.addElement(2);
        }

        //use fermat factorization on the remaining odd part
        v.addElements(factorFermat(temp));
        return v.array();
    }


    /* http://en.wikipedia.org/wiki/Fermat's_factorization_method */
    private static long[] factorFermat(long n){
        if (n % 2 == 0)
            throw new RuntimeException("Only used for odd integers.");

        long a = (long)Math.ceil(Math.sqrt(n));
        long b2 = a*a - n;

        while (Math.sqrt(b2) != Math.floor(Math.sqrt(b2))){
            a++;
            b2 = a*a - n;
        }

        long x = a - (long)Math.sqrt(b2);
        long y = a + (long)Math.sqrt(b2);

        if (x == 1 || y == 1)
            if (x == 1)
                return new long[]{y};
            else
                return new long[]{x};
        
        return ArrayUtil.union(factorFermat(x), factorFermat(y));
    }


    public static long[] getPrimes(long n){
        LongVector l = new LongVector();
        for (int i = 2; i < n;i++)
            if (isPrime(i))
                l.addElement(i);

        return l.array();
    }

    public static boolean isPrime(long n){
        if (n < 2)
            return false;

        long squareRoot = (long)Math.floor(Math.sqrt(n));
        for (int i = 2; i<=squareRoot;i++){
            if (n % i == 0) return false;
        }

        return true;
    }
}