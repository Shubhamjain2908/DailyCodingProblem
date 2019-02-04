/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP_2;

import java.util.Arrays;

/**
 * Facebook
 * @author SHUBHAM
 * Given an array of numbers representing the stock prices of a company in chronological order and an integer k, return the maximum profit you can make from k buys and sells. You must buy the stock before you can sell it, and you must sell the stock before you can buy it again.
    For example, given k = 2 and the array [5, 2, 4, 0, 1], you should return 3.
 */
public class P130_MaximumProfitUsingKTrans 
{
    public static void main(String[] args) 
    {
        int[] stock = {5, 2, 4, 0, 1};
        int k = 2;
        System.out.println(maxProfit(stock, k));
    }
    private static int maxProfit(int[] price, int k)
    {
        int n = price.length;
        int[][] profit = new int[k+1][n+1];
        for (int j = 0; j <= n; j++) 
        {
            profit[0][j] = 0; 
        } 
        for (int i = 1; i <= k; i++)  
        { 
            for (int j = 1; j < n; j++) 
            { 
                int max_so_far = 0; 
                for (int m = 0; m < j; m++) 
                {
                    max_so_far = Math.max(max_so_far, price[j] - price[m] + profit[i - 1][m]); 
                    profit[i][j] = Math.max(profit[i] [j - 1], max_so_far); 
                }
            } 
        } 
        for (int[] profit1 : profit) {
            System.out.println(Arrays.toString(profit1));
        }
        return profit[k][n-1];
    }
}
