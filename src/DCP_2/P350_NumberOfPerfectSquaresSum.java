/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP_2;

import java.util.ArrayList;
import java.util.List;

/**
 * Uber
 * @author SHUBHAM
 * Write a program that determines the smallest number of perfect squares that sum up to N.
    Here are a few examples:
    •	Given N = 4, return 1 (4)
    •	Given N = 17, return 2 (16 + 1)
    •	Given N = 18, return 2 (9 + 9)
 */
public class P350_NumberOfPerfectSquaresSum {

    public static void main(String[] args) {
        int N = 4;
        int N2 = 17;
        int N3 = 18;
        System.out.println("N = " + N + " : => " + getMinSquares(N));
        System.out.println("N2 = " + N2 + " : => " + getMinSquares(N2));
        System.out.println("N3 = " + N3 + " : => " + getMinSquares(N3));
    }

    public static int getMinSquareBruteForce(int N) {
        List<Integer> list = getAllPerfectSquares(N);
        return smallestSubWithSum(list, list.size(), N);
    }

    private static int smallestSubWithSum(List<Integer> arr, int n, int x) {
        //  Initilize length of smallest subarray as n+1 
        int min_len = n + 1;

        // Pick every element as starting point 
        for (int start = 0; start < n; start++) {
            // Initialize sum starting with current start 
            int curr_sum = arr.get(start);

            // If first element itself is greater 
            if (curr_sum == x) {
                return 1;
            }

            // Try different ending points for curremt start 
            for (int end = start + 1; end < n; end++) {
                // add last element to current sum 
                curr_sum += arr.get(end);

                // If sum becomes more than x and length of 
                // this subarray is smaller than current smallest 
                // length, update the smallest length (or result) 
                if (curr_sum > x && (end - start + 1) < min_len) {
                    min_len = (end - start + 1);
                }
            }
        }
        return min_len;
    }

    private static List<Integer> getAllPerfectSquares(int N) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(N); i++) {
            int sq = i * i;
            if (sq <= N) {
                list.add(sq);
            }
        }
        return list;
    }
    
    // DP
    private static int getMinSquares(int n) {

        // We need to add a check here for n. If user enters 0 or 1 or 2 
        // the below array creation will go OutOfBounds. 
        if (n <= 3) {
            return n;
        }

        // Create a dynamic programming table 
        // to store sq 
        int dp[] = new int[n + 1];

        // getMinSquares table for base case entries 
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        // getMinSquares rest of the table using recursive 
        // formula 
        for (int i = 4; i <= n; i++) {
            // max value is i as i can always be represented 
            // as 1*1 + 1*1 + ... 
            dp[i] = i;

            // Go through all smaller numbers to 
            // to recursively find minimum 
            for (int x = 1; x <= Math.ceil(Math.sqrt(i)); x++) {
                int temp = x * x;
                if (temp > i) {
                    break;
                } else {
                    dp[i] = Math.min(dp[i], 1 + dp[i - temp]);
                }
            }
        }

        // Store result and free dp[] 
        int res = dp[n];
        return res;
    }

}
