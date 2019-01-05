/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Facebook
 * @author SHUBHAM
 *  Given a multiset of integers, return whether it can be partitioned into two subsets whose sums are the same.
    For example, given the multiset {15, 5, 20, 10, 35, 15, 10}, it would return true, since we can split it up into {15, 5, 10, 15, 10} and {20, 35}, which both add up to 55.
    Given the multiset {15, 5, 20, 10, 35}, it would return false, since we can't split it up into two subsets that add up to the same sum
 */
public class P60_MultisetSum 
{
    public static void main(String[] args) 
    {
        int[] arr = {15, 5, 20, 10, 35, 15, 10};
        //System.out.println(isSumEqual(arr));
        System.out.println(findPartition(arr));
    }
    // DP
    private static boolean findPartition(int arr[]) 
    { 
        int n = arr.length;
        int sum = Arrays.stream(arr).map(e -> e).sum();
        int i, j; 

        if (sum%2 != 0) 
            return false; 
  
        boolean part[][]=new boolean[sum/2+1][n+1]; 
  
        // initialize top row as true 
        for (i = 0; i <= n; i++) 
            part[0][i] = true; 
  
        // initialize leftmost column, except part[0][0], as 0 
        for (i = 1; i <= sum/2; i++) 
            part[i][0] = false; 
  
        // Fill the partition table in botton up manner 
        for (i = 1; i <= sum/2; i++) 
        { 
            for (j = 1; j <= n; j++) 
            { 
                part[i][j] = part[i][j-1]; 
                if (i >= arr[j-1]) 
                {
                    part[i][j] = part[i][j] || part[i - arr[j-1]][j-1]; 
                }
            } 
        } 

        return part[sum/2][n]; 
    } 
    // Normal Solution 
    private static boolean isSumEqual(int[] arr)
    {
        Map<Integer, List<List<Integer>>> map = getSubsets(arr);
        
//        map.entrySet().forEach(e->{
//            System.out.println(e.getKey() + " -> ");
//            System.out.println(e.getValue());
//        });
        return !map.isEmpty();
    }
    // O(n*2^n)
    private static Map<Integer, List<List<Integer>>> getSubsets(int[] arr)
    {
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        int sum = Arrays.stream(arr).map(e -> e).sum()/2;
        int n = arr.length;
        int pow = (int) Math.pow(2, n) - 1;
        for (int i = 0; i < pow; i++) 
        {
            String binary = Integer.toBinaryString(i);
            while(binary.length() != n)
            {
                binary = "0" + binary; 
            }
            List<Integer> l = new ArrayList<>();
            for (int j = 0; j < n ; j++) 
            {
                if (binary.charAt(j) == '1') {
                    l.add(arr[j]);
                }
            }
            if (l.stream().mapToInt(e -> e).sum() == sum) {
                List<List<Integer>> l2 = new ArrayList<>();
                l2.add(l);
                if (map.containsKey(l.size())) {
                    l2.addAll(map.get(l.size()));
                }
                map.put(l.size(), l2);
            }
        }
        return map;
    }
}
