/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP_2;

/**
 * Cisco
 * @author SHUBHAM
 * Given an unsigned 8-bit integer, swap its even and odd bits. The 1st and 2nd bit should be swapped, the 3rd and 4th bit should be swapped, and so on.
    For example, 10101010 should be 01010101. 11100010 should be 11010001.
    Bonus: Can you do this in one line?
 */
public class P109_SwapBits 
{
    public static void main(String[] args) 
    {
        int i1 = 10101010;
        int i2 = 11100010;
        
        System.out.println(swap(i1));
        System.out.println(swap(i2));
    }
    private static String swap(int i1)
    {
        String s = String.valueOf(i1);
        String str = "";
        for (int i = 0; i < 8; i+=2) 
        {
            char c1 = s.charAt(i);
            char c2 = s.charAt(i+1);
            str += c2;
            str += c1;
        }
        return str;
    }
}
