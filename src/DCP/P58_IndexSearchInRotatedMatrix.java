/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

/**
 * Amazon
 * @author SHUBHAM
 * An sorted array of integers was rotated an unknown number of times.

    Given such an array, find the index of the element in the array in faster than linear time. If the element doesn't exist in the array, return null.

    For example, given the array [13, 18, 25, 2, 8, 10] and the element 8, return 4 (the index of 8 in the array).

    You can assume all the integers in the array are unique.
 */
public class P58_IndexSearchInRotatedMatrix 
{
    public static void main(String[] args) 
    {
        int[] arr = {13, 18, 25, 2, 8, 10};
        int e = 8;
        int i = search(arr, 0, arr.length - 1, e);
        System.out.println(i);
    }
    private static int getIndex(int[] arr, int e)
    {
        int index = 0;
        
        return index;
    }
    private static int search(int arr[], int l, int h, int key) 
    { 
        if (l > h)  
            return -1; 
        
        int mid = (l+h)/2; 
        if (arr[mid] == key) 
            return mid; 
        
        /* If arr[l...mid] is sorted */
        if (arr[l] <= arr[mid]) 
        { 
            /* As this subarray is sorted, we  
               can quickly check if key lies in  
               half or other half */
            if (key >= arr[l] && key <= arr[mid]) 
               return search(arr, l, mid-1, key); 
        
            return search(arr, mid+1, h, key); 
        } 
        
        /* If arr[l..mid] is not sorted,  
           then arr[mid... r] must be sorted*/
        if (key >= arr[mid] && key <= arr[h]) 
            return search(arr, mid+1, h, key); 
        
        return search(arr, l, mid-1, key); 
    } 
}
