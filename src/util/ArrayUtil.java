
/**
 * A set of useful tools for arrays.
 *
 * License: MIT
 */

package util;

public final class ArrayUtil {

    public static long max(long[] array){
        if (array == null)
            throw new NullPointerException();

        if (array.length == 0)
            throw new RuntimeException("Empty array.");

        long max = array[0];
        for (int i=0;i<array.length-1;i++)
            max = Math.max(max, array[i+1]);

        return max;
    }

    public static long[] union(long[] a, long[] b){
        long[] result = new long[a.length+b.length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }
    
     public static void swap(int[] a){
            int temp;
            for (int i = 0; i < (a.length/2);i++)
            {
                temp = a[i];
                a[i] = a[a.length-i-1];
                a[a.length-i-1] = temp;
            }
    }
}
