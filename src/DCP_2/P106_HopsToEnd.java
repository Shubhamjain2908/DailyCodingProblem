/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP_2;

/**
 * Pinterest
 * @author SHUBHAM
 * Given an integer list where each number represents the number of hops you can make, determine whether you can reach to the last index starting at index 0.
    For example, [2, 0, 1, 0] returns true while [1, 1, 0, 1] returns false.
 */
public class P106_HopsToEnd 
{
    public static void main(String[] args) 
    {
        int[] arr  = {2, 0, 1, 0};
        int[] arr2 = {1, 1, 0, 1};
        System.out.println(canMakeToEnd(arr));
        System.out.println(canMakeToEnd(arr2));
    }
    private static boolean canMakeToEnd(int[] arr)
    {
        int index = 0;
        int n = arr.length-1;
        int h = arr[index];
        while(index < n)
        {
            if (h == 0 && index != n) {
                return false;
            }
            else if (h >= n-index) 
            {
                return true;
            }
            else 
            {
                index += h;
                h = arr[index];
            }
        }
        return true;
    }
}
