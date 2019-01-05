/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Google
 * @author SHUBHAM
 * Given an array of integers where every integer occurs three times except for one integer, which only occurs once, find and return the non-duplicated integer.
   For example, given [6, 1, 3, 3, 3, 6, 6], return 1. Given [13, 19, 13, 13], return 19.
   Do this in O(N) time and O(1) space.
 */
public class P40_NonDuplicatedInteger 
{
    public static void main(String[] args) 
    {
        int[] arr = {6,1,3,3,3,6,6};
        System.out.println(getNonDuplicatedInt(arr));
        System.out.println(getSingle(arr));
    }
    /**
     * Time = O(n) & space = O(1)
     * @param arr
     * @return 
     */
    private static int getSingle(int arr[]) 
    { 
        int ones = 0, twos = 0; 
        int common_bit_mask; 
          
        for(int i=0; i<arr.length; i++ ) 
        { 
            /*"one & arr[i]" gives the bits that are there in 
            both 'ones' and new element from arr[]. We 
            add these bits to 'twos' using bitwise OR*/
            twos = twos | (ones & arr[i]); 
  
            /*"one & arr[i]" gives the bits that are 
            there in both 'ones' and new element from arr[]. 
            We add these bits to 'twos' using bitwise OR*/
            ones = ones ^ arr[i]; 
  
            /* The common bits are those bits which appear third time 
            So these bits should not be there in both 'ones' and 'twos'. 
            common_bit_mask contains all these bits as 0, so that the bits can  
            be removed from 'ones' and 'twos'*/
            common_bit_mask = ~(ones & twos); 
                          
            /*Remove common bits (the bits that appear third time) from 'ones'*/
            ones &= common_bit_mask; 
                          
            /*Remove common bits (the bits that appear third time) from 'twos'*/
            twos &= common_bit_mask; 
        } 
        return ones; 
    } 
    /**
     * Time = O(n) & space = O( n-1/3 + 1)
     * @param arr
     * @return 
     */
    private static int getNonDuplicatedInt(int[] arr)
    {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) 
        {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        return map.entrySet().stream().filter(t->t.getValue()==1).findFirst().get().getValue();
        //return Collections.min(map.values());
    }
}
