/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP_2;

/**
 * LinkedIn
 * @author SHUBHAM
 * Given a string, return whether it represents a number. Here are the different kinds of numbers:
    •	"10", a positive integer
    •	"-10", a negative integer
    •	"10.1", a positive real number
    •	"-10.1", a negative real number
    •	"1e5", a number in scientific notation
    And here are examples of non-numbers:
    •	"a"
    •	"x 1"
    •	"a -2"
    •	"-"
 */
public class P123_ATOIString 
{
    public static void main(String[] args) 
    {
        String s1 = "10";
        String s2 = "-10";
        String s3 = "10.1";
        String s4 = "-10.1";
        String s5 = "1e5";
        String s6 = "a";
        String s7 = "x 1";
        String s8 = "a -2";
        String s9 = "-";
        System.out.println(isRealNo(s1));
        System.out.println(isRealNo(s2));
        System.out.println(isRealNo(s3));
        System.out.println(isRealNo(s4));
        System.out.println(isRealNo(s5));
        System.out.println(isRealNo(s6));
        System.out.println(isRealNo(s7));
        System.out.println(isRealNo(s8));
        System.out.println(isRealNo(s9));
    }
    private static String isRealNo(String str)
    {
        try
        {
            Double i = Double.valueOf(str);
            if (str.contains("-") && !str.contains(".")) {
                return "negative integer";
            }
            if (!str.contains("-") && str.contains(".")) {
                return "positive real number";
            }
            if (str.contains("-") && str.contains(".")) {
                return "negative real integer";
            }
            if (str.contains("e")) {
                return "number in scientific notation";
            }
            return "positive number";
        }
        catch(NumberFormatException e)
        {
            return "not a number";
        }
        
    }
}
