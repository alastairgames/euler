/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package solutions;

/**
 * Project Euler Solution
 * Problem 0002
 * @author Alastair Games
 *
 * License: MIT
 */
public class Problem0002 {

    public static void main(String[] args){
        int sum = 0;
        int fib = 1;
        int prevFib = 0;
        int nextFib = 0;
        while (fib <= 4000000){
            sum += (fib & 1) == 0 ? fib : 0;
            //calculate the next Fibonacci number
            nextFib = prevFib + fib;
            prevFib = fib;
            fib = nextFib;
        }
        System.out.println(sum);
    }
}