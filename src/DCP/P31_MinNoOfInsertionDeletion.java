/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

import java.util.Arrays;

/**
 *
 * @author SHUBHAM
 * The edit distance between two strings refers to the minimum number of character insertions, deletions, and substitutions required to change one string to the other. For example, the edit distance between “kitten” and “sitting” is three: substitute the “k” for “s”, substitute the “e” for “i”, and append a “g”.
 */
public class P31_MinNoOfInsertionDeletion 
{
    public static void main(String[] args) 
    {
        String s1 = "kitten";
        String s2 = "sitting";
        System.out.println(noOfOperation(s1, s2));
    }
    private static int noOfOperation(String s1, String s2) 
    {
        int n = s1.length();
        int m = s2.length();
        int[][] arr = new int[n+1][m+1];
        for (int i = 0; i < arr[0].length; i++) 
        {
            arr[0][i] = i;
        }
        for (int i = 0; i < arr.length; i++) 
        {
            arr[i][0] = i;
        }
        
        for (int i = 1; i < arr.length; i++) 
        {
            for (int j = 1; j < arr[i].length; j++) 
            {
                if (s1.charAt(i-1) == s2.charAt(j-1)) 
                {
                    arr[i][j] = arr[i-1][j-1];
                }
                else
                {
                    arr[i][j] = Math.min(Math.min(arr[i-1][j-1], arr[i-1][j]), arr[i][j-1]) + 1;
                }
            }
        }
        for (int[] a : arr) System.out.println(Arrays.toString(a));
        return arr[n][m];
    }
}
