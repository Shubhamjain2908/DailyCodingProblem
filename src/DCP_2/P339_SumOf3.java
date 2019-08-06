/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP_2;

import java.util.HashSet;
import java.util.Set;

/**
 * Microsoft
 *
 * @author SHUBHAM 
 * Given an array of numbers and a number k, determine if there
 * are three entries in the array which add up to the specified number k. 
 * For example, given [20, 303, 3, 4, 25] and k = 49, return true as 20 + 4 + 25 = 49.
 */
public class P339_SumOf3 {

    public static void main(String[] args) {
        int[] arr = {20, 303, 3, 4, 25};
        int k = 49;
        System.out.println(find3Numbers(arr, arr.length, k));
    }

    private static boolean find3Numbers(int A[], int arr_size, int sum) {
        // Fix the first element as A[i] 
        for (int i = 0; i < arr_size - 2; i++) {
            // Find pair in subarray A[i+1..n-1] 
            // with sum equal to sum - A[i] 
            Set<Integer> s = new HashSet<>();
            int curr_sum = sum - A[i];
            for (int j = i + 1; j < arr_size; j++) {
                if (s.contains(curr_sum - A[j]) && curr_sum - A[j] != (int) s.toArray()[s.size() - 1]) {
                    System.out.printf("Triplet is %d, %d, %d", A[i], A[j], curr_sum - A[j]);
                    return true;
                }
                s.add(A[j]);
            }
        }
        // If we reach here, then no triplet was found 
        return false;
    }

}
