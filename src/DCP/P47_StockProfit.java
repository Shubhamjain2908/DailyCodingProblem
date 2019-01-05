/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

/**
 * Facebook
 * @author SHUBHAM
 * Given a array of numbers representing the stock prices of a company in chronological order, write a function that calculates the maximum profit you could have made from buying and selling that stock once. You must buy before you can sell it.
For example, given [9, 11, 8, 5, 7, 10], you should return 5, since you could buy the stock at 5 dollars and sell it at 10 dollars.
 */
public class P47_StockProfit 
{
    public static void main(String[] args) 
    {
        int[] arr = {9, 11, 8, 5, 7, 10};
        System.out.println(maxProfit(arr));
    }
    private static int maxProfit(int[] arr)
    {
        int maxProfit = -1;
        int buyPrice = 0;
        int sellPrice = 0;

        boolean changeBuyPrice = true;

        for (int i = 0; i < arr.length-1; i++) 
        {
            if (changeBuyPrice)
            {
                buyPrice = arr[i];
            }
            sellPrice = arr[i + 1];

            if (sellPrice < buyPrice) 
            {
                changeBuyPrice = true;
            }
            else 
            {
                int tempProfit = sellPrice - buyPrice;
                if (tempProfit > maxProfit)
                {
                    maxProfit = tempProfit;
                }
                changeBuyPrice = false;
            }
        }
        return maxProfit;
    } 
}
