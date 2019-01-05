/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

import java.util.Arrays;

/**
 * Stripe
 * @author SHUBHAM
 * Given an array of integers, find the first missing positive integer in linear time and constant space. In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.

    For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
 */
public class P04_MissingPositiveInt 
{
    public static void main(String[] args) 
    {
        int[] arr  = {3,4,-1,1};
        int[] arr2 = {1,2,0};
        System.out.println(getLeastInt(arr2));
    }
    private static int getLeastInt(int[] arr)
    {
        int max = Arrays.stream(arr).max().getAsInt();
        boolean[] b = new boolean[max+1];
        b[0] = true;
        for (int i = 0; i < arr.length; i++) 
        {
            if (arr[i] >= 0) {
                b[arr[i]] = true;
            }
            
        }
        
        for (int i=0;i<b.length;i++) {
            if (!b[i]) {
                return i;
            }
        }
        return max+1;
    }
}
