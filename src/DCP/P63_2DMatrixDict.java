/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

/**
 * Microsoft
 * @author SHUBHAM
 * Given a 2D matrix of characters and a target word, write a function that returns whether the word can be found in the matrix by going left-to-right, or up-to-down.

For example, given the following matrix:

[['F', 'A', 'C', 'I'],
 ['O', 'B', 'Q', 'P'],
 ['A', 'N', 'O', 'B'],
 ['M', 'A', 'S', 'S']]
and the target word 'FOAM', you should return true, since it's the leftmost column. Similarly, given the target word 'MASS', you should return true, since it's the last row.
 */
public class P63_2DMatrixDict 
{
    public static void main(String[] args) 
    {
        char[][] mat = {{'F', 'A', 'C', 'I'},
                        {'O', 'B', 'Q', 'P'},
                        {'A', 'N', 'O', 'B'},
                        {'M', 'A', 'S', 'S'}};
        String word = "FOAM";
        String word2 = "MASS";
        System.out.println(isPresent(mat, word));
        System.out.println(isPresent(mat, word2));
    }
    private static boolean isPresent(char[][] mat, String word)
    {
        for (int i = 0; i < mat.length; i++) {
            String s1 = "";
            String s2 = "";
            for (int j = 0; j < mat[i].length; j++) {
                s1 += String.valueOf(mat[i][j]);
                s2 += String.valueOf(mat[j][i]);
            }
            if (s1.equals(word) || s2.equals(word)) {
                return true;
            }
        }
        return false;
    }
}
