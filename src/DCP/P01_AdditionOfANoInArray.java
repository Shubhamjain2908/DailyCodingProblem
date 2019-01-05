/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author SHUBHAM
 */
public class P01_AdditionOfANoInArray 
{
    public static void main(String[] args) 
    {
        int[] arr = {10,2,3,4,5};
        int k = 19;
        System.out.println(isPresent(arr, k));
    }
    public static boolean isPresent(int[] arr, int k) 
    {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) 
        {
            map.putIfAbsent(arr[i], i);
        }
        for (int i = 0; i < arr.length; i++) 
        {
            if (map.containsKey(k-arr[i])) return true;
        }
        
        return false;
    }
}
