/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP_2;

/**
 *
 * @author SHUBHAM
 * Given a real number n, find the square root of n. For example, given n = 9, return 3.
 */
public class P129_SquareRoot 
{
    public static void main(String[] args) 
    {
        double n = 10;
        System.out.println(sqrt(n));
        System.out.println(squareRoot(n));
    }
    private static double sqrt(double n)
    {
        if (n==1) {
            return 1;
        }
        double x = 0;
        double i;
        for (i = 1; i < n; i++) 
        {
            if (n/i == i) {
                return i;
            }
        }
        double nearestRoot = sqrt(n-1);
        while (count(x) < 5) {
            double c = n/nearestRoot;
            x = (nearestRoot + c)/2;
        }
        return x;
    }
    private static int count(double d)
    {
        String text = Double.toString(Math.abs(d));
        int integerPlaces = text.indexOf('.');
        return text.length() - integerPlaces - 1;
    }
    
    // Babylonian Method
    private static double squareRoot(double n) 
    { 
        /*We are using n itself as initial approximation 
        This can definitely be improved */
        double x = n; 
        double y = 1; 

        /* e decides the accuracy level*/
        double e = 0.000001;  
        while(x - y > e) 
        { 
            x = (x + y) / 2; 
            y = n / x; 
        }  
        return x; 
    }
}
