/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

/**
 *
 * @author SHUBHAM
 */
public class P07_WaysToDecodeMessage 
{
    public static void main(String[] args) 
    {
        System.out.println(noOfWays("12133"));
    }
    
    private static int noOfWays(String N) 
    {
        int[] memo = new int[N.length() + 1];
        return helper_dp(N, N.length(), memo);
    }
    /*
    private static int helper(String data, int k) 
    {
        if(k ==0) return 1;
        
        int s = data.length() - k;
        
        if(data.charAt(s) == '0') return 0;
        
        int result = helper(data, k-1);
        
        if (k >= 2 && Integer.valueOf(data.substring(s, s+2)) <= 26) {
            result += helper(data, k-2);
        }
        return result;
    }*/
    private static int helper_dp(String data, int k, int[] memo)
    {
        if(k==0) return 1;
        
        int s = data.length() - k;
        
        if(data.charAt(s) == '0') return 0;
        
        if(memo[k] != 0) return memo[k];
        
        int result = helper_dp(data, k-1, memo);
        if (k >= 2 && Integer.valueOf(data.substring(s, s+2)) <= 26) {
            result += helper_dp(data, k-2, memo);
        }
        memo[k] = result;
        
        return result;
    }
}
