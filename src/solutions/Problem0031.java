package solutions;

/**
 * Project Euler Solution Problem 0031
 * 
 * @author Alastair Games
 * License: MIT
 */
public class Problem0031 {
    
    private static final int VALUE = 200;
    
    private static final int[] DENOMINATION = {1,2,5,10,20,50,100,200};
    
    public static void main(String[] args) {
        System.out.println(countCombination(VALUE, DENOMINATION.length-1));
    }
    
    private static int countCombination(int v, int d){
        if (v == 0) //a sucessful combination has been found
            return 1;
        
        if (d == -1) // as the combination goes from largest to smallest, there are no more coins left.
            return 0;
            
        int count = 0;
        int nCoins = v/DENOMINATION[d];
            
        for (int i = nCoins; i >= 0; i--)
            count += countCombination(v-i*DENOMINATION[d],d-1);
        
        return count;
    }
}
