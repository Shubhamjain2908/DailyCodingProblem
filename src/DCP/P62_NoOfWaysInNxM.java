/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

/**
 * Facebook
 * @author SHUBHAM
 *  There is an N by M matrix of zeroes. Given N and M, write a function to count the number of ways of starting at the top-left corner and getting to the bottom-right corner. You can only move right or down.
    For example, given a 2 by 2 matrix, you should return 2, since there are two ways to get to the bottom-right:
    Right, then down
    Down, then right
    Given a 5 by 5 matrix, there are 70 ways to get to the bottom-right.
 */
public class P62_NoOfWaysInNxM 
{
    public static void main(String[] args) 
    {
        int N = 5;
        int M = 5;
        System.out.println(noOfWays_DP(N, M));
    }
    
    // Recursive Solution
    private static int noOfWays(int N, int M){
        if (M==1 || N==1) {
            return 1;
        }
        return noOfWays(N-1, M) + noOfWays(N, M-1);
    }
    
    // DP - I  = O(nm)
    private static int noOfWays_DP(int N, int M){
        int[][] mat = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            mat[i][0] = 1;
        }
        for (int i = 0; i < M; i++) {
            mat[0][i] = 1;
        }
        for (int i = 1; i < mat.length; i++) {
            for (int j = 1; j < mat[i].length; j++) {
                mat[i][j] = mat[i-1][j] + mat[i][j-1];
            }
        }
        return mat[N-1][M-1];
    }
}

