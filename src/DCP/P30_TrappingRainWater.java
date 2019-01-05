/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

/**
 * Facebook
 * @author SHUBHAM
 * You are given an array of non-negative integers that represents a two-dimensional elevation map where each element is unit-width wall and the integer is the height. Suppose it will rain and all spots between two walls get filled up.

    Compute how many units of water remain trapped on the map in O(N) time and O(1) space.

    For example, given the input [2, 1, 2], we can hold 1 unit of water in the middle.

    Given the input [3, 0, 1, 3, 0, 5], we can hold 3 units in the first index, 2 in the second, and 3 in the fourth index (we cannot hold 5 since it would run off to the left), so we can trap 8 units of water.
 */
public class P30_TrappingRainWater 
{
    public static void main(String[] args) 
    {
        int[] a1 = {2,1,2}; // 1
        int[] a2 = {3, 0, 1, 3, 0, 5}; // 8
        System.out.println(getWater(a2));
    }
    private static int getWater(int[] arr)
    {
        int n = arr.length;
        // initialize output 
        int result = 0; 
           
        // maximum element on left and right 
        int left_max = 0, right_max = 0; 
           
        // indices to traverse the array 
        int lo = 0, hi = n-1; 
           
        while(lo <= hi)  
        { 
            if(arr[lo] < arr[hi]) 
            { 
                if(arr[lo] > left_max) 
      
                // update max in left 
                left_max = arr[lo]; 
                else
      
                // water on curr element =  
                // max - curr 
                result += left_max - arr[lo]; 
                lo++; 
            } 
            else
            { 
                if(arr[hi] > right_max) 
                  
                // update right maximum 
                right_max = arr[hi]; 
                  
                else
                result += right_max - arr[hi]; 
                hi--; 
            } 
        } 
           
        return result; 
    }
}
