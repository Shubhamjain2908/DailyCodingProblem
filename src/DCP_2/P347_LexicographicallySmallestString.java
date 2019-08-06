/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP_2;

import java.util.Arrays;

/**
 * Yahoo
 * @author SHUBHAM
 * You are given a string of length N and a parameter k. The string can be manipulated by taking one of the first k letters and moving it to the end.
Write a program to determine the lexicographically smallest string that can be created after an unlimited number of moves.
For example, suppose we are given the string daily and k = 1. The best we can create in this case is ailyd.
 */
public class P347_LexicographicallySmallestString {
    public static void main(String[] args) {
        String str = "geeksforgeeks";
        int k = 5;
        System.out.println("Lexicographical String => " + getSmallestString(str, k));
    }
    public static String getSmallestString(String str, int k) {
        StringBuilder sb = new StringBuilder();
        int l = str.length();
        while(l > 0) {
            if (k>l) {
                sb.append(str);
                return sb.toString();
            }
            String newStr = str.substring(0, k);
            char[] c = newStr.toCharArray();
            Arrays.sort(c);
            StringBuilder temp = new StringBuilder();
            for (int i = 1; i < c.length; i++) {
                temp.append(c[i]);
            }
            str = temp + str.substring(k, l);
            sb.append(c[0]);
            l = str.length();
        }
        return sb.toString();
    }
}
