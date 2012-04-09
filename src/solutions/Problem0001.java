/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package solutions;

/**
 * Project Euler Solution
 * Problem 0001
 * @author Alastair Games
 *
 * License: MIT
 */
public class Problem0001 {

    public static void main(String[] args){
        int sum = 0;
        for (int i = 1; i < 1000; i++){
            sum += (i % 3 == 0||i % 5 == 0) ? i : 0;
        }
        System.out.println(sum);
    }
}