/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP_2;

import java.util.Arrays;

/**
 * Lyft
 * @author SHUBHAM
 * Given a list of integers and a number K, return which contiguous elements of the list sum to K.
    For example, if the list is [1, 2, 3, 4, 5] and K is 9, then it should return [2, 3, 4].
 */
public class P102_ContiguousElementsSumK 
{
    public static void main(String[] args) 
    {
        int[] arr = {1, 2, 3, 4, 5};
        int K = 9;
        System.out.println(Arrays.toString(getContiguousElements(arr, K)));
    }
    private static int[] getContiguousElements(int[] arr, int K)
    {
        int p1 = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) 
        {
            int a = arr[i];
            if (sum + a <= K) 
            {
                sum += a;
                if (sum == K) 
                {
                    return Arrays.copyOfRange(arr, p1, i+1);
                }
            }
            else 
            {
                while(sum + a > K)
                {
                    sum = sum - arr[p1];
                    p1++;
                }
                sum += a;
                if (sum == K) 
                {
                    return Arrays.copyOfRange(arr, p1, i+1);
                }
            }
        }
        return null;
    }
}
