/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

/**
 * Amazon
 * @author SHUBHAM
 *  Given an array of numbers, find the maximum sum of any contiguous subarray of the array.
    For example, given the array [34, -50, 42, 14, -5, 86], the maximum sum would be 137, since we would take elements 42, 14, -5, and 86.
    Given the array [-5, -1, -8, -9], the maximum sum would be 0, since we would not take any elements.
    Do this in O(N) time.
 */
public class P49_MaxContiguiousSubArr 
{
    public static void main(String[] args) 
    {
        int[] arr = {34, -50, 42, 14, -5, 86};
        //int[] arr = {-5, -1, -8, -9};
        System.out.println(maxSubArraySum(arr));
        System.out.println(maxSubArraySum2(arr));
        System.out.println(maxSubArraySum_DP(arr));
    }
    // Kadane
    private static int maxSubArraySum(int a[]) 
    { 
        int size = a.length; 
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0; 
  
        for (int i = 0; i < size; i++) 
        { 
            max_ending_here = max_ending_here + a[i]; 
            if (max_so_far < max_ending_here) 
                max_so_far = max_ending_here; 
            if (max_ending_here < 0) 
                max_ending_here = 0; 
        } 
        return max_so_far > 0 ? max_so_far : 0; 
    } 
    private static int maxSubArraySum2(int a[]) 
    { 
        int size = a.length;
        int max_so_far = 0, max_ending_here = 0; 
        for (int i = 0; i < size; i++) 
        { 
            max_ending_here = max_ending_here + a[i]; 
            if (max_ending_here < 0) 
                max_ending_here = 0; 

            /* Do not compare for all elements. Compare only    
               when  max_ending_here > 0 */
            else if (max_so_far < max_ending_here) 
                max_so_far = max_ending_here; 
        } 
        return max_so_far; 
    } 
    // DP
    static int maxSubArraySum_DP(int a[]) 
    { 
        int size = a.length;
        int max_so_far = a[0]; // Max
        int curr_max = a[0]; 

        for (int i = 1; i < size; i++) 
        { 
            curr_max = Math.max(a[i], curr_max+a[i]); 
            max_so_far = Math.max(max_so_far, curr_max); 
        } 
        return max_so_far; 
    } 
}
