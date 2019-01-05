/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP_2;

/**
 * Google
 * @author SHUBHAM
 * Given a string which we can delete at most k, return whether you can make a palindrome.
    For example, given 'waterrfetawx' and a k of 2, you could delete f and x to get 'waterretaw'.
 */
public class P121_K2PallindormeString 
{
    public static void main(String[] args) 
    {
        String s = "waterrfetawx";
        int k = 2;
        System.out.println(canPallin(s, k));
    }
    private static boolean canPallin(String str, int k)
    {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        System.out.println(str);
        System.out.println(sb);
        int X = LCS(str, sb.toString());
        return (str.length() - X) <= 2;
    }
    private static int LCS(String A, String B)
    {
        int n = A.length();
        int m = B.length();
        int[][] lcs = new int[n+1][m+1];
        for (int i = 0; i <= n; i++) 
        {
            for (int j = 0; j <= m; j++) 
            {
                if (i == 0 || j==0) {
                    lcs[i][j] = 0;
                }
                else if (A.charAt(i-1) == B.charAt(j-1)) {
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i][j-1], lcs[i-1][j]);
                }
            }
        }
        return lcs[n][m];
    }
}
