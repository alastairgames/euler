package solutions;

/**
 * Project Euler Solution Problem 0019
 * 
 * @author Alastair Games
 * License: MIT
 */
public class Problem0019 {
    
    public static void main(String[] args) {
        int count = 0;
        
         //include the last two months of 1900 (jan feb 1901)
        if (dayOfWeek(1900,11,1)==0)
            count++;
        if (dayOfWeek(1900,12,1)==0)
            count++;
        
        for (int y = 1901; y <= 2000; y++)
            for (int m = 0;m<12;m++)
                if (dayOfWeek(y,m+1,1)==0)
                    count++;
        
        //discard the first 2 months of 2001.
        if (dayOfWeek(2000,11,1)==0)
            count--;
        if (dayOfWeek(2000,12,1)==0)
            count--;
        
        System.out.println(count);
    }
    
    //Gaussian algorithm, explained http://en.wikipedia.org/wiki/Determination_of_the_day_of_the_week
    //note that january and february are considered months 11 and 12 of the previous year.
    //return 0 = Sunday
    private static int dayOfWeek(int year, int month, int day){
        int c = ((year - year % 10)/10)%10*10+year%10;
        return (day+(int)Math.floor(2.6*month-0.2)+year+year/4+c/4-2*c)%7;
    }
}
