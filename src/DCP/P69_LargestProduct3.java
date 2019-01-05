/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

import java.util.Arrays;

/**
 * Facebook
 * @author SHUBHAM
 * Given a list of integers, return the largest product that can be made by multiplying any three integers.

For example, if the list is [-10, -10, 5, 2], we should return 500, since that's -10 * -10 * 5.

You can assume the list has at least three integers.
 */
public class P69_LargestProduct3 
{
    public static void main(String[] args) 
    {
        int[] arr = {-10,-10,5,2};
        int[] arr2 = {-3,-2,-1,0,1,2,3};
        P69_LargestProduct3 p = new P69_LargestProduct3();
        System.out.println(p.largestSum3(arr2));
    }
    
    // O(n) Time, O(1) Space
    private int largestSum3(int[] arr) 
    {
        int n = arr.length;
        
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int thirdMax = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) 
        {
            // Min
            if (arr[i] < min) {
                secondMin = min;
                min = arr[i];
            }
            else if (arr[i] < secondMin) {
                secondMin = arr[i];
                
            }
            
            // Max
            if (arr[i] > max) {
                thirdMax = secondMax;
                secondMax = max;
                max = arr[i];
            }
            else if (arr[i] > secondMax) {
                thirdMax = secondMax;
                secondMax = arr[i];
            }
            else if (arr[i] > thirdMax){
                thirdMax = arr[i];
            }
        }
        return Math.max(max*secondMax*thirdMax, min*secondMin*max);
    }
    
    // O(nlogn) Time, O(1) Space
    private int largestSum2(int[] arr)
    {
        int max = 0;
        int n = arr.length;
        Arrays.sort(arr);
        max = Math.max(arr[0] * arr[1] * arr[n-1], arr[n-1] * arr[n-2] * arr[n-3]);
        return max;
    }
    
    // O(n*2^n)
    private int largestSum(int[] arr)
    {
        int max = 0;
        int n = arr.length;
        int pow = (int)Math.pow(2, n) - 1;
        for (int i = 0; i < pow; i++) 
        {
            String binary = Integer.toBinaryString(i);
            while(binary.length() != n)
            {
                binary = "0" + binary;
            }
            int count = 0;
            for (int j = 0; j < n; j++) 
            {
                if (binary.charAt(j) == '1') 
                {
                    count++;
                }
            }
            if (count == 3) 
            {
                int product = 1;
                for (int j = 0; j < n; j++) 
                {
                    if (binary.charAt(j) == '1') 
                    {
                        product = product * arr[j];
                    }
                }
                if (product >= max) {
                    max = product;
                }
            }
        }
        return max;
    }
}
