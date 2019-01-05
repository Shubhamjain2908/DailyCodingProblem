/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

/**
 *  Google
 *  @author SHUBHAM
 *  You are given an N by M 2D matrix of lowercase letters. Determine the minimum number of columns that can be removed to ensure that each row is ordered from top to bottom lexicographically. That is, the letter at each column is lexicographically later as you go down each row. It does not matter whether each row itself is ordered lexicographically.
    For example, given the following table:
    cba
    daf
    ghi

    This is not ordered because of the a in the center. We can remove the second column to make it ordered:
    ca
    df
    gi

    So your function should return 1, since we only needed to remove 1 column.
    As another example, given the following table:
    abcdef

    Your function should return 0, since the rows are already ordered (there's only one row).
    As another example, given the following table:
    zyx
    wvu
    tsr

    Your function should return 3, since we would need to remove all the columns to order it.
 */
public class P76_lexicographicalMatrix 
{
    public static void main(String[] args) 
    {
        char[][] arr  = {{'c','b','a'},
                         {'d','a','f'},
                         {'g','h','i'}};
        char[][] arr2 = {{'a','b','c','d','e','f'}};
        char[][] arr3 = {{'z','y','x'},
                         {'w','v','u'},
                         {'t','s','r'}};
        System.out.println(removeColumns(arr));
        System.out.println(removeColumns(arr2));
        System.out.println(removeColumns(arr3));
    }
    private static int removeColumns(char[][] arr)
    {
        int count = 0;
        int n = arr.length;
        int m = arr[0].length;
        if (n == 1) 
        {
            return 0;
        }
        for (int i = 0; i < m; i++) 
        {
            for (int j = 0; j < n-1; j++) 
            {
                if (arr[j][i] > arr[j+1][i]) 
                {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}