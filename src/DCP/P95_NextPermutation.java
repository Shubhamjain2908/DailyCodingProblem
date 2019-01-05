/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

import java.util.Arrays;

/**
 * Palantir
 * @author SHUBHAM
 * Given a number represented by a list of digits, find the next greater permutation of a number, in terms of lexicographic ordering. If there is not greater permutation possible, return the permutation with the lowest value/ordering.
For example, the list [1,2,3] should return [1,3,2]. The list [1,3,2] should return [2,1,3]. The list [3,2,1] should return [1,2,3].
 */
public class P95_NextPermutation 
{
    public static void main(String[] args) 
    {
        int[] arr  = {1,2,3};
        int[] arr2 = {1,3,2};
        int[] arr3 = {3,2,1};
        System.out.println(Arrays.toString(getNextNo(arr)));
        System.out.println(Arrays.toString(getNextNo(arr2)));
        System.out.println(Arrays.toString(getNextNo(arr3)));
    }
    private static int[] getNextNo(int[] arr)
    {
        int i, n = arr.length;
        for (i = n-1; i > 0; i--) 
        {
            if (arr[i] > arr[i-1]) {
                break;
            }
        }
        if (i==0) {
            Arrays.sort(arr);
            return arr;
        }
        int x = arr[i-1], min = 1;
        for (int j = i+1; j < n; j++) 
        {
            if (arr[j] > x && arr[j] < arr[min])  
            { 
                min = j; 
            } 
        }
        arr = swap(arr, i-1, min);
        Arrays.sort(arr,i, n);
        return arr;
    }
    static int[] swap(int ar[], int i, int j)  
    { 
        int temp = ar[i]; 
        ar[i] = ar[j]; 
        ar[j] = temp; 
        return ar;
    } 
}
