/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP_2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Facebook
 * @author SHUBHAM
 * Write a function that rotates a list by k elements. For example, [1, 2, 3, 4, 5, 6] rotated by two becomes [3, 4, 5, 6, 1, 2]. Try solving this without creating a copy of the list. How many swap or move operations do you need?
 */
public class P126_RotateList 
{
    public static void main(String[] args) 
    {
        Queue<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        int k = 2;
        System.out.println(getRotatedList(list, k));
    }
    private static Queue<Integer> getRotatedList(Queue<Integer> list, int k)
    {
        for (int i = 0; i < k; i++) 
        {
            int x = list.poll();
            list.add(x);
        }
        return list;
    }
    
    void leftRotate(int arr[], int d, int n) 
    { 
        int i, j, k, temp; 
        for (i = 0; i < gcd(d, n); i++) { 
            /* move i-th values of blocks */
            temp = arr[i]; 
            j = i; 
            while (true) { 
                k = j + d; 
                if (k >= n) 
                    k = k - n; 
                if (k == i) 
                    break; 
                arr[j] = arr[k]; 
                j = k; 
            } 
            arr[j] = temp; 
        } 
    } 
  
    /*Fuction to get gcd of a and b*/
    int gcd(int a, int b) 
    { 
        if (b == 0) 
            return a; 
        else
            return gcd(b, a % b); 
    } 
}
