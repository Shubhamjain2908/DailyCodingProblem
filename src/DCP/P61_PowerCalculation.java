/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

/**
 * Google
 * @author SHUBHAM
 *  Implement integer exponentiation. That is, implement the pow(x, y) function, where x and y are integers and returns x^y.
    Do this faster than the naive method of repeated multiplication.
    For example, pow(2, 10) should return 1024.
 */
public class P61_PowerCalculation 
{
    public static void main(String[] args) 
    {
        int x = 2;
        int y = 10;
        System.out.println(power(x, y));
    }
    private static int power(int x, int y)
    {
        if (y == 0) 
            return 1; 
        else if (y % 2 == 0) 
            return power(x, y / 2) * power(x, y / 2); 
        else
            return x * power(x, y / 2) * power(x, y / 2);
    }
}
