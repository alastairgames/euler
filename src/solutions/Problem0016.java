/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package solutions;

import java.math.BigInteger;

/**
 *
 * @author Aurix
 */
public class Problem0016 {
     public static void main(String[] args){
        int sum = 0;
        String NUMBER = BigInteger.ONE.shiftLeft(1000).toString();
        for (int i = 0; i < NUMBER.length();i++){
            sum += Integer.parseInt(""+NUMBER.charAt(i));
        }
        System.out.println(sum);
     }
}
