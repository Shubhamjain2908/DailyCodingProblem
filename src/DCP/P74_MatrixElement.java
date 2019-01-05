/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

/**
 *  Apple
 *  @author SHUBHAM
 *  Suppose you have a multiplication table that is N by N. That is, a 2D array where the value at the i-th row and j-th column is (i + 1) * (j + 1) (if 0-indexed) or i * j (if 1-indexed).
    Given integers N and X, write a function that returns the number of times X appears as a value in an N by N multiplication table.
    For example, given N = 6 and X = 12, you should return 4, since the multiplication table looks like this:
    | 1 | 2 | 3 | 4 | 5 | 6 |
    | 2 | 4 | 6 | 8 | 10 | 12 |
    | 3 | 6 | 9 | 12 | 15 | 18 |
    | 4 | 8 | 12 | 16 | 20 | 24 |
    | 5 | 10 | 15 | 20 | 25 | 30 |
    | 6 | 12 | 18 | 24 | 30 | 36 |
    And there are 4 12's in the table.
 */
public class P74_MatrixElement 
{
    public static void main(String[] args) 
    {
        int n = 6;
        int x = 12;
        System.out.println(noOfTimes(n, x));
    }
    private static int noOfTimes(int n, int x)
    {
        int count = 0;
        for (int i = 0; i < n; i++) 
        {
            for (int j = 0; j < n; j++) 
            {
                if (((i + 1) * (j + 1)) == x)
                    count++;
                System.out.print((i + 1) * (j + 1)+ " ");
//                if (i==j) 
//                {
//                    if (i*j == x) 
//                        count++;
//                    System.out.print((i+1)*(j+1)+ " ");
//                }
//                else 
//                {
//                    if (((i + 1) * (j + 1)) == x)
//                        count++;
//                    System.out.print((i + 1) * (j + 1)+ " ");
//                }
            }
            System.out.println("");
        }
        return count;
    }
}
