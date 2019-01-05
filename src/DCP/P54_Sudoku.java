/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  Dropbox
 *  @author SHUBHAM
 *  Sudoku is a puzzle where you're given a partially-filled 9 by 9 grid with digits. The objective is to fill the grid with the constraint that every row, column, and box (3 by 3 subgrid) must contain all of the digits from 1 to 9.
 *  Implement an efficient sudoku solver.
 */
public class P54_Sudoku 
{
    private final int sudoku[][];
    private static final int N = 9;
    
    private final List<int[]> coordinates;
    private static final int[] options = {1,2,3,4,5,6,7,8,9};
    
    public P54_Sudoku(int[][] sudoku)
    {
        this.sudoku = sudoku;
        this.coordinates = new ArrayList<>();
    }
    
    public static void main(String[] args) 
    {
        int[][] game = {
            {3, 0, 6, 5, 0, 8, 4, 0, 0},
            {5, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 8, 7, 0, 0, 0, 0, 3, 1},
            {0, 0, 3, 0, 1, 0, 0, 8, 0},
            {9, 0, 0, 8, 6, 3, 0, 0, 5},
            {0, 5, 0, 0, 9, 0, 6, 0, 0},
            {1, 3, 0, 0, 0, 0, 2, 5, 0},
            {0, 0, 0, 0, 0, 0, 0, 7, 4},
            {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };
        int[][] game2 = {
            { 8, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 3, 6, 0, 0, 0, 0, 0 },
            { 0, 7, 0, 0, 9, 0, 2, 0, 0 },
            { 0, 5, 0, 0, 0, 7, 0, 0, 0 },
            { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
            { 0, 0, 0, 1, 0, 0, 0, 3, 0 },
            { 0, 0, 1, 0, 0, 0, 0, 6, 8 },
            { 0, 0, 8, 5, 0, 0, 0, 1, 0 },
            { 0, 9, 0, 0, 0, 0, 4, 0, 0 } 
        };
        P54_Sudoku g1 = new P54_Sudoku(game);
        g1.solve();
        P54_Sudoku g2 = new P54_Sudoku(game2);
        g2.solve();
    }
    
    // Not efficient
    private boolean solve()
    {
        findEmptyCoordinates();
        if (backTrack(0, 0)) 
        {
            System.out.println("Solved!!!");
            printGame();
            return true;
        }
        System.out.println("Cannot be solved");
        return false;
        
    }
    
    private boolean backTrack(int nodeIndex, int optionIndex)
    {   
        while(optionIndex < N)
        {
            int x = coordinates.get(nodeIndex)[0];
            int y = coordinates.get(nodeIndex)[1];
            int num = options[optionIndex];
            if (!isPossible(x, y, num)) {
                optionIndex += 1;
            }
            else
            {
                sudoku[x][y] = num;
                if (nodeIndex == coordinates.size()-1) 
                {
                    return true;
                }
                else
                {
                    if (backTrack(nodeIndex+1, 0)) 
                    {
                        return true;
                    } 
                    else
                    {
                        sudoku[x][y] = 0;
                        optionIndex += 1;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean isPossible(int row, int col, int num)
    {
        for (int i = 0; i < 9; i++) 
        {
            if (sudoku[row][i] == num) 
            {
                return false;
            }
            if (sudoku[i][col] == num) 
            {
                return false;
            }
        }
        
        int boxRow = row - row % 3;
        int boxColumn = col - col % 3;

        for (int i = 0; i < 3; i++) 
        {
            for (int j = 0; j < 3; j++) 
            {
                if (sudoku[boxRow + i][boxColumn + j] == num) 
                {
                    return false;
                }
            }
        }
        return true;
    }
    
    private void findEmptyCoordinates()
    {
        for (int i = 0; i < sudoku.length; i++) 
        {
            for (int j = 0; j < sudoku[i].length; j++) 
            {
                if (sudoku[i][j] == 0) 
                {
                    int[] c = {i,j};
                    coordinates.add(c);
                }
            }
        }
    }
    
    private void printGame()
    {
        for (int[] sudoku1 : sudoku) 
        {
            System.out.println(Arrays.toString(sudoku1));
        }
    }
}