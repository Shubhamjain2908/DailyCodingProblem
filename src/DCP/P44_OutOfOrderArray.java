/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Google
 * @author SHUBHAM
 * We can determine how "out of order" an array A is by counting the number of inversions it has. Two elements A[i] and A[j] form an inversion if A[i] > A[j] but j >  i. That is, a smaller element appears after a larger element.
 * Given an array, count the number of inversions it has. Do this faster than O(N^2) time.
 * You may assume each element in the array is distinct.
 * For example, a sorted list has zero inversions. The array [2, 4, 1, 3, 5] has three inversions: (2, 1), (4, 1), and (4, 3). The array [5, 4, 3, 2, 1] has ten inversions: every distinct pair forms an inversion.
 */
public class P44_OutOfOrderArray 
{
    public static void main(String[] args) 
    {
        //int[] arr = {2, 4, 1, 3, 5};
        int[] arr = {5, 4, 3, 2, 1};
        //System.out.println(outOfOrder(arr));
        System.out.println(countInversion(arr));
    }
    // >O(nLogn)
    private static int countInversion(int[] A)
    {
        int k = 0;
        for (int i = 1; i < A.length; i++) 
        {
            int temp = A[i];
            int j;
            for (j = i - 1; j >= 0 && temp < A[j]; j--) {
                A[j + 1] = A[j];
                k++;  // Number of inversions
            }
            A[j + 1] = temp;
        }
        return k;
    }
    
    // O(n*2^n)
    private static int outOfOrder(int[] arr)
    {
        int[] count = {0};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) 
        {
            map.put(arr[i], i);
        }
        Set<List<Integer>> subsets = getSubsets(arr);
        subsets.forEach(t -> {
            int x = t.get(0);
            int y = t.get(1);
            if (x > y) {
                count[0]++;
            }
        });
        
        return count[0];
    }
    public static Set<List<Integer>> getSubsets(int[] arr) 
    {
        Set<List<Integer>> subsets = new HashSet<>();
        int pow = (int)Math.pow(2, arr.length) -1;
        for (int i = 0; i <= pow; i++) 
        {
            String binary = Integer.toBinaryString(i);
            while(binary.length() != arr.length)
            {
                binary = "0" + binary;
            }
            List<Integer> al = new ArrayList<>();
            for (int j = 0; j < binary.length(); j++) 
            {
                if (binary.charAt(j) == '1') 
                {
                    al.add(arr[j]);
                }   
            }
            if (al.size()==2) 
            {
                subsets.add(al);
            }
        }
        return subsets;
    }
}
