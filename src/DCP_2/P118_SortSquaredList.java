/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Google
 * @author SHUBHAM
 * Given a sorted list of integers, square the elements and give the output in sorted order.
    For example, given [-9, -2, 0, 2, 3], return [0, 4, 4, 9, 81].
 */
public class P118_SortSquaredList 
{
    public static void main(String[] args) 
    {
        Integer[] arr = {-9, -2, 0, 2, 3};
        int[] arr2 = {-9, -2, 0, 2, 3};
        List<Integer> list = new ArrayList<>(Arrays.asList(arr));
        System.out.println(getSortedArr(list));
        System.out.println(Arrays.toString(sortSquares(arr2)));
    }
    
    private static List<Integer> getSortedArr(List<Integer> list)
    {
        return list.stream().mapToInt(i -> i*i).boxed().sorted().collect(Collectors.toList());
    }
    
    // Merge Sort
    public static int[] sortSquares(int arr[]) 
    { 
        int n = arr.length; 
       // first dived array into part negative and positive 
       int k; 
       for(k = 0; k < n; k++) 
       { 
           if(arr[k] >= 0) 
             break; 
       } 
          
        // Now do the same process that we learn 
        // in merge sort to merge to two sorted array 
        // here both two half are sorted and we traverse 
        // first half in reverse meaner because 
        // first half contain negative element 
        int i = k-1; // Initial index of first half 
        int j = k; // Initial index of second half 
        int ind = 0; // Initial index of temp array 
          
        int[] temp = new int[n]; 
        while(i >= 0 && j < n)  
        { 
            if(arr[i] * arr[i] < arr[j] * arr[j]) 
            { 
                temp[ind] = arr[i] * arr[i]; 
                i--; 
            } 
            else{ 
                  
                temp[ind] = arr[j] * arr[j]; 
                j++; 
                  
            } 
            ind++; 
        } 
          
        while(i >= 0) 
        { 
            temp[ind++] = arr[i] * arr[i]; 
            i--; 
        } 
        while(j < n) 
        { 
            temp[ind++] = arr[j] * arr[j]; 
            j++; 
        } 
          
        // copy 'temp' array into original array
        System.arraycopy(temp, 0, arr, 0, n); 
        
        return arr;
    } 
}
