/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP_2;

/**
 * Zillow
 * @author lenovo
 * You are given a 2-d matrix where each cell represents number of coins in that cell. Assuming we start at matrix[0][0], and can only move right or down, find the maximum number of coins you can collect by the bottom right corner.
    For example, in this matrix
    0 3 1 1
    2 0 0 4
    1 5 3 1
    The most we can collect is 0 + 2 + 1 + 5 + 3 + 1 = 12 coins.

 */
public class P122_MaxCoinsInMatrix 
{
    public static void main(String[] args) 
    {
        int[][] mat = {
            {0,3,1,1},
            {2,0,0,4},
            {1,5,3,1}
        };
        int m = 3;
        int n = 4;
        System.out.println(maxCoins(mat, m-1, n-1));
    }
    private static int maxCoins(int[][] mat, int m, int n)
    {
        if (m<0 || n<0) {
            return Integer.MIN_VALUE;
        }
        if (m==0 && n==0) {
            return mat[m][n];
        }
        else {
            return Math.max(maxCoins(mat, m-1, n), maxCoins(mat, m, n-1)) + mat[m][n];
        }
    }
    
}
