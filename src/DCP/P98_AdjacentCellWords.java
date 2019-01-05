/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

/**
 * Coursera
 * @author SHUBHAM
 * Given a 2D board of characters and a word, find if the word exists in the grid.
    The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
    For example, given the following board:
    [
      ['A','B','C','E'],
      ['S','F','C','S'],
      ['A','D','E','E']
    ]
    exists(board, "ABCCED") returns true, exists(board, "SEE") returns true, exists(board, "ABCB") returns false.
 */
public class P98_AdjacentCellWords 
{    
    public static void main(String[] args) 
    {
        char[][] board = {{'A','B','C','E'},
                          {'S','F','C','S'},
                          {'A','D','E','E'}};
        System.out.println(exists(board, "ABCCED"));
        System.out.println(exists(board, "SEE"));
        System.out.println(exists(board, "ABCB"));
    }
    private static boolean exists(char[][] board, String word)
    {
        int rowCount = board.length;
        int colCount = board[0].length;
        boolean[][] bb = new boolean[rowCount][colCount];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backtrack(board, word, bb, 0, i, j, rowCount, colCount)) {
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean backtrack(char[][] board, String word, boolean[][] memo, int findIndex, int i, int j, int rowCount, int colCount)
    {
        if (findIndex == word.length())
        {
            return true;
        }
        else
        {
            if (i < rowCount && j < colCount && i >= 0 && j >= 0)
            {
                // memo[i,j] is false means that index is not covered yet.
                if (memo[i][j] == false && board[i][j] == word.charAt(findIndex))
                {
                    // mark it as covered
                    memo[i][j] = true;

                    // find next character at same row next column
                    if (backtrack(board, word, memo, findIndex + 1, i, j + 1, rowCount, colCount))
                    {
                        return true;
                    }
                    // find next character at next row same column
                    else if (backtrack(board, word, memo, findIndex + 1, i + 1, j, rowCount, colCount))
                    {
                        return true;
                    }
                    // find next character at same row previous column
                    else if (backtrack(board, word, memo, findIndex + 1, i, j - 1, rowCount, colCount))
                    {
                        return true;
                    }
                    // find next character at previous row same column
                    else if (backtrack(board, word, memo, findIndex + 1, i - 1, j, rowCount, colCount))
                    {
                        return true;
                    }
                    else
                    {
                        memo[i][j] = false; // mark it as uncovered.
                    }
                }
                else
                {
                    return false;
                }
            }
        }
        return false;
    }
}
