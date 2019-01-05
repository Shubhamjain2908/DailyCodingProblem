/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Google
 * @author SHUBHAM
 * Given an integer n and a list of integers l, write a function that randomly generates a number from 0 to n-1 that isn't in l (uniform).
 */
public class P90_RandomInN 
{
    public static void main(String[] args) 
    {
        int[] l = {3,6,8,9};
        int n = 20;
        generate(l, n);
    }
    private static void generate(int[] l, int n)
    {
        Random rand = new Random();
        int[] arr = new int[n];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) 
        {
            if (i >= l.length) 
            {
                if (arr[i] != i+1) {
                    list.add(i);
                }
            } else {
                list.add(i);
            }
        }
        System.out.println(list);
    }
}
