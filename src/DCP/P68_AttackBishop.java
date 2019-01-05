/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

import java.util.ArrayList;
import java.util.List;

/**
 * Google
 * @author SHUBHAM
 * On our special chessboard, two bishops attack each other if they share the same diagonal. This includes bishops that have another bishop located between them, i.e. bishops can attack through pieces.
    You are given N bishops, represented as (row, column) tuples on a M by M chessboard. Write a function to count the number of pairs of bishops that attack each other. The ordering of the pair doesn't matter: (1, 2) is considered the same as (2, 1).
    For example, given M = 5 and the list of bishops:
    (0, 0)
    (1, 2)
    (2, 2)
    (4, 0)
    The board would look like this:
    [b 0 0 0 0]
    [0 0 b 0 0]
    [0 0 b 0 0]
    [0 0 0 0 0]
    [b 0 0 0 0]

    You should return 2, since bishops 1 and 3 attack each other, as well as bishops 3 and 4.
 */
public class P68_AttackBishop 
{
    private static int[][] board;
    
    public static void main(String[] args) 
    {
        int M = 5;
        List<int[]> bis = new ArrayList<>();
        int[] b1 = {0,0};
        int[] b2 = {1,2};
        int[] b3 = {2,2};
        int[] b4 = {4,0};
        bis.add(b1);
        bis.add(b2);
        bis.add(b3);
        bis.add(b4);
        System.out.println(attackedBishop(M, bis));
    }
    private static int attackedBishop(int M, List<int[]> bishops)
    {
        board = new int[M][M];
        bishops.forEach(t -> {
            board[t[0]][t[1]] = 1;
        });
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
        int count = 0;
        System.out.println(traverseDiagonal(bishops.get(0)));
        System.out.println(traverseDiagonal(bishops.get(1)));
        System.out.println(traverseDiagonal(bishops.get(2)));
        System.out.println(traverseDiagonal(bishops.get(3)));
//        for (int i = 0; i < bishops.size(); i++) 
//        {
//            count += traverseDiagonal(bishops.get(i));
//        }
        return count;
    }
    private static int traverseDiagonal(int[] c)
    {
        int count = 0;
        int x = c[0];
        int y = c[1];
        
        // Checking diagonal Upper 
        for (int i = x, j=y ; i >= 0 && j>=0; i--, j--) {
            if (board[i][j] == 1) {
                count++;
            }
        }
        
        //Checking diagonal Lower  
        for (int i = x, j=y; j >= 0 && i<board.length; j--) {
            if (board[i][j] == 1) {
                count++;
            }
        }
        return count-1;
    }
}
