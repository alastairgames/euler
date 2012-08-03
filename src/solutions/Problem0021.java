/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package solutions;

/**
 * This is just pure brute force.
 * @author Aurix
 */
public class Problem0021 {
     public static void main(String[] args){
         long sum = 0;
         int[] d = new int[10000];
         for (int i = 0; i < d.length; i++){
             d[i] = sumOfdivisorsExceptSelf(i);
         }
         
         for (int i = 0; i < d.length; i++){
             if (d[i] < d.length && d[d[i]] == i && d[i] != i){
                 sum += i + d[i];
             }
         }
         
         //Divide by two because the pairs are discovered twice.
         System.out.println(sum / 2);
     }
     
     private static int sumOfdivisorsExceptSelf(int n){
         int s = 0;
         for (int i = 1; i < n; i++)
             if (n % i == 0)
                 s += i;
         return s;
     }
}
