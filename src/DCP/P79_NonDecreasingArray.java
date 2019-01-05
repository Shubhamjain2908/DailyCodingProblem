/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

/**
 *  Facebook
 *  @author SHUBHAM
 *  Given an array of integers, write a function to determine whether the array could become non-decreasing by modifying at most 1 element.
    For example, given the array [10, 5, 7], you should return true, since we can modify the 10 into a 1 to make the array non-decreasing.
    Given the array [10, 5, 1], you should return false, since we can't modify any one element to get a non-decreasing array.
 */
public class P79_NonDecreasingArray 
{
    public static void main(String[] args) 
    {
        int[] arr = {10,5,7};
//        int[] arr = {10,5,1};
        System.out.println(canConvert(arr));
    }
    private static boolean canConvert(int[] arr)
    {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) 
        {
            if (arr[i] > arr[i+1]) 
            {
                count++;
            }
        }
        return count == 0 || count == 1;
    }
}
