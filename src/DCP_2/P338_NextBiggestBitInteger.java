/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP_2;

/**
 * Facebook
 * @author SHUBHAM 
 * Given an integer n, find the next biggest integer with the same number of 1-bits on. 
 * For example, given the number 6 (0110 in binary), return 9 (1001).
 */
public class P338_NextBiggestBitInteger {

    public static void main(String[] args) {
        int n = 6;
        int k = getNextInteger(n);
        System.out.println("Next Int => " + k + ". Bits => " + Integer.toString(k, 2));
        System.out.println(snoob(6));
    }

    // Brute Force
    private static int getNextInteger(int n) {
        String bin = Integer.toString(n, 2);
        long onesCount = bin.chars().filter(s -> s == '1').count();
        int min = n;
        n++;
        while (n < Integer.MAX_VALUE) {
            bin = Integer.toString(n, 2);
            if (onesCount == bin.chars().filter(s -> s == '1').count()) {
                return n;
            }
            n++;
        }
        return -1;
    }

    // this function returns next higher  
    // number with same number of set bits as x. 
    private static int snoob(int x) {

        int rightOne, nextHigherOneBit, rightOnesPattern, next = 0;

        if (x > 0) {

            // right most set bit 
            rightOne = x & -x;

            // reset the pattern and set next higher bit 
            // left part of x will be here 
            nextHigherOneBit = x + rightOne;

            // nextHigherOneBit is now part [D] of the above explanation. 
            // isolate the pattern 
            rightOnesPattern = x ^ nextHigherOneBit;

            // right adjust pattern 
            rightOnesPattern = (rightOnesPattern) / rightOne;

            // correction factor 
            rightOnesPattern >>= 2;

            // rightOnesPattern is now part [A] of the above explanation. 
            // integrate new pattern (Add [D] and [A]) 
            next = nextHigherOneBit | rightOnesPattern;
        }

        return next;
    }
}
