/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

/**
 * Facebook
 * @author SHUBHAM
 * Given three 32-bit integers x, y, and b, return x if b is 1 and y if b is 0, using only mathematical or bit operations. You can assume b can only be 1 or 0.
 */
public class P85_MathematicalBitOperation 
{
    public static void main(String[] args) 
    {
        int x = 12;
        int y = 78;
        int b = 0;
        System.out.println(getB(x, y, b));
    }
    private static int getB(int x, int y, int b)
    {
        return x*b + y*(1-b);
    }
}
