/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

/**
 * Quora
 * @author SHUBHAM
 *  Given a string, find the palindrome that can be made by inserting the fewest number of characters as possible anywhere in the word. If there is more than one palindrome of minimum length that can be made, return the lexicographically earliest one (the first one alphabetically).
    For example, given the string "race", you should return "ecarace", since we can add three letters to it (which is the smallest amount to make a palindrome). There are seven other palindromes that can be made from "race" by adding three letters, but "ecarace" comes first alphabetically.
    As another example, given the string "google", you should return "elgoogle".
 */
public class P34_MinNoToPallindromeString 
{
    public static void main(String[] args) 
    {
        String s1 = "race";
        String s2 = "google";
        System.out.println(getNo(s1));
        System.out.println(getNo(s2));
    }
    
    private static int getNo(String s1)
    {
        int n = s1.length();
        String s2 = new StringBuilder(s1).reverse().toString();
        int l = LCS(s1, s2);
        return n - l;
    }
    private static int LCS(String s1, String s2)
    {
        int n = s1.length();
        int m = s2.length();
        int[][] lcs = new int[n+1][m+1];
        for (int i = 0; i < n+1; i++) 
        {
            for (int j = 0; j < m+1; j++) 
            {
                if (i == 0 || j==0) {
                    lcs[i][j] = 0;
                }
                else if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i][j-1], lcs[i-1][j]);
                }
            }
        }
        return lcs[n][m];
    }
}
