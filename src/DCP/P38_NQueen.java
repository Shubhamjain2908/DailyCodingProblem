/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

/**
 * Microsoft
 * @author SHUBHAM
 * You have an N by N board. Write a function that, given N, returns the number of possible arrangements of the board where N queens can be placed on the board without threatening each other, i.e. no two queens share the same row, column, or diagonal.
 */
public class P38_NQueen 
{
    public static void main(String[] args) 
    {
        int n=5;
        isSolvable(n);
    }
    private static boolean isSolvable(int N)
    {
        if (N<=3) {
            System.out.println("Cannot be solved");
            return false;
        }
        int[][] board = new int[N][N];
        if (!backTrack(board, 0)) {
            System.out.println("Board cannot be solved");
            return false;
        }
        
        printBoard(board);
        return true;
    }
    private static boolean backTrack(int[][] board, int col)
    {
        int N = board.length;
        // Base case
        if (col>=N) {
            return true;
        }
        for (int i = 0; i < N; i++) 
        {
            if (isSafe(board, i, col))
            {
                board[i][col] = 1;
                
                if (backTrack(board, col+1)) {
                    return true;
                }
                
                board[i][col] = 0;
            }
        }
        return false;
    }
    private static void printBoard(int[][] board)
    {
        for (int[] board1 : board) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(" " + board1[j] + " ");
            }
            System.out.println(" ");
        }
    }
    private static boolean isSafe(int[][] board, int row, int col)
    {
        // Checking row
        for (int i = 0; i < board.length; i++)
        {
            if (board[row][i] == 1) {
                return false;
            }
        }
        
        // Checking column
        for (int i = 0; i < board.length; i++)
        {
            if (board[i][col] == 1) {
                return false;
            }
        }
        
        // Checking diagonal Upper 
        for (int i = row, j=col ; i >= 0 && j>=0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        
        //Checking diagonal Lower  
        for (int i = row, j=col; j >= 0 && i<board.length; j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
}
