/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

/**
 * Google
 * @author SHUBHAM
 *  A knight's tour is a sequence of moves by a knight on a chessboard such that all squares are visited once.
    Given N, write a function to return the number of knight's tours on an N by N chessboard.
 */
public class P64_KnightsTour 
{
    private static int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
    private static int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};
    private static int N = 8;
    private static int[][] sol = new int[N][N];
    
    public static void main(String[] args) 
    {
        solve();
        printSolution();
    }
    private static boolean solve()
    {

        /* Initialization of solution matrix */
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                sol[x][y] = -1;
            }
        }
        sol[0][0] = 0;
        if (backtrack(0, 0, 1)) 
        {
            System.out.println("Solved!!!");
            return true;
        }
        System.out.println("Cannot be solved!");
        return false;
    }
    private static boolean backtrack(int x, int y, int moveI)
    {
        if (moveI == N*N) 
        {
            return true;
        }
        
        int k=0;
        while(k < yMove.length)
        {
            int nextX = x + xMove[k];
            int nextY = y + yMove[k];
            if (isSafe(nextX, nextY)) 
            {
                sol[nextX][nextY] = moveI;
                if (backtrack(nextX, nextY, moveI+1)) 
                {
                    return true;
                }
                else 
                {
                    sol[nextX][nextY] = -1;
                }
            }
            k++;
        }
        return false;
    }
    
    private static boolean isSafe(int x, int y) 
    {
        return (x >= 0 && x < N && y >= 0
                && y < N && sol[x][y] == -1);
    }
    
    private static void printSolution()
    {
        for (int i = 0; i < N; i++) 
        {
            for (int j = 0; j < N; j++) 
            {
                System.out.print(sol[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
