/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

import java.util.Random;

/**
 * Two sigma
 * @author SHUBHAM
 * Using a function rand5() that returns an integer from 1 to 5 (inclusive) with uniform probability, implement a function rand7() that returns an integer from 1 to 7 (inclusive).
 */
public class P71_Rand7FromRand5 {
    public static void main(String[] args) 
    { 
        System.out.println(uniform_distribution_secure(0, 5));
    }
    private static int rand5()
    {
        int result = 0;
        int first, second; 
        for ( first=1; first<=5; ++first ) 
            for ( second=1; second<=5; ++second ) 
                result = 5*first + second - 5; 
        return result;
    } 
    private static int rand7()
    {
        int i = 5*rand5() + rand5() - 5;
        if (i<22) {
            return i%7 + 1;
        }
        return rand7();
    }
    private static int uniform_distribution_secure(int rangeLow, int rangeHigh) {
        int range = rangeHigh - rangeLow + 1;
        int secureMax = 7 - 7 % range;
        int x = 0;
        Random r = new Random();
        for (int i = 1; i <= secureMax; i++) {
            x = r.nextInt(i);
        }
        return rangeLow + x % range;
    }
}
