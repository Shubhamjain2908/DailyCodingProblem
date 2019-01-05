/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

import java.util.*;
/**
 *
 * @author SHUBHAM
 */
public class P03_MissingInt 
{
    public static void main(String[] args) 
    {
        int[] arr = {0,2,1,3,4,5,6,7,8,9};
        System.out.println(missingInt(arr));
    }
    public static int missingInt(int[] arr) 
    {
        Map<Integer, Boolean> map = new TreeMap<>();
        for (int i = 0; i < arr.length+1; i++) 
        {
            map.put(i, false);
        }
        for (int i = 0; i < arr.length; i++) 
        {
            if (map.containsKey(arr[i])) 
            {
                map.put(i, true);
            }
        }
        final int[] a = {0};
        map.entrySet().forEach(e -> {
            if (!e.getValue()) {
                a[0] = e.getKey();
            }
        });
        return a[0];
    }
}
