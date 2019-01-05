/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Google
 * @author SHUBHAM
 * Given a list of integers S and a target number k, write a function that returns a subset of S that adds up to k. If such a subset cannot be made, then return null.
    Integers can appear more than once in the list. You may assume all numbers in the list are positive.
    For example, given S = [12, 1, 61, 5, 9, 2] and k = 24, return [12, 9, 2, 1] since it sums up to 24.
 */
public class P42_SubsetSumK 
{
    public static void main(String[] args) 
    {
        int[] arr = {12, 1, 61, 5, 9, 2, 12};
        int k = 24;
        int[] arr2 = {2,3,7,8,10};
        int k2 = 11;
//        Set<int[]> subSet = getSubsetsOfSumK(arr2, k2);
//        subSet.forEach(s -> System.out.println(Arrays.toString(s)));
        System.out.println(getSubsetsOfSumK_DP(arr, k));
        System.out.println(getSubsetsOfSumK_DP(arr2, k2));
    }
    private static boolean getSubsetsOfSumK_DP(int[] inputArray, int k)
    {
        boolean[][] T = new boolean[inputArray.length+1][k+1];
        
        for (int i = 0; i <= inputArray.length; i++) {
            T[i][0] = true;
        }
        
        for (int i = 1; i <= inputArray.length; i++) {
            for (int j = 1; j <= k; j++) {
                if (j - inputArray[i - 1] >= 0) {
                    T[i][j] = T[i - 1][j] || T[i - 1][j - inputArray[i - 1]];
                } else {
                    T[i][j] = T[i-1][j];
                }
            }
        }
        
        for (boolean[] a : T) {
            System.out.println(Arrays.toString(a));
        }
        
        return T[inputArray.length][k];
    }
    
    // Not efficient
    private static Set<int[]> getSubsetsOfSumK(int[] inputArray, int k)
    {   
        Set<int[]> set = new HashSet<>();
        int n = inputArray.length;
        int pow = (int) Math.pow(2, n)-1;
        for (int i = 1; i <= pow; i++) 
        {
            String binary = Integer.toBinaryString(i);
            while(binary.length() != n){
                binary = "0" + binary;
            }
            StringBuilder sb = new StringBuilder();
            int sum = 0;
            for (int j = 0; j < binary.length(); j++) 
            {
                if (binary.charAt(j) == '1') {
                    sum += inputArray[j];
                    sb.append(inputArray[j]).append(",");
                }
            }
            if (sum == k) {
                String[] str = sb.toString().split(",");
                int[] ik = new int[str.length];
                for (int j = 0; j < str.length; j++) 
                {
                    ik[j] = Integer.valueOf(str[j]);
                }
                set.add(ik);
            }
        }
        return set;
    }
}
