package solutions;

/**
 * Project Euler Solution Problem 0004 
 * 
 * @author Alastair Games
 * License: MIT
 */
public class Problem0009 {
    private static final int MAX = 1000;
    
    //Since a*a + b*b = c*c and a + b + c = 1000 then
    //a*a + b*b = (1000-a*b)^2, elimiating testing for c.

    //secondly, since a < b, so I test b with every possible value of a that
    //is less than b.
    public static void main(String[] args) {
        int a2;
        int b2;
        int c;
        int c2;
        
        for (int b = MAX; b > 0; b--) {
            b2 = b * b;
            for (int a = b; a > 0; a--) {
                a2 = a * a;
                c = MAX-a-b;
                c2 = c*c;
                if (a2+b2 == c2){
                    System.out.println(a*b*c);
                    return;
                }
                    
            }
        }
    }
}
