/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

import java.util.ArrayList;
import java.util.List;
/**
 *Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.
 * @author SHUBHAM
 */
public class P02_ExclusiveProduct 
{
    public static void main(String[] args) 
    {
        int[] arr = {1,2,3,4,5};
        //int[] newArr = productArrayWithoutDivision(arr);
        int[] newArr = productArrayWithDivision(arr);
        for (int i = 0; i < newArr.length; i++) 
        {
            System.out.println(newArr[i]);
        }
    }
    private static int[] productArrayWithDivision(int[] arr)
    {
        int[] newArr = new int[arr.length];
        int p=1;
        for (int i = 0; i < arr.length; i++) 
        {
            p = p*arr[i];
        }
        for (int i = 0; i < newArr.length; i++) 
        {
            newArr[i] = p/arr[i];
        }
        return newArr;
    }
    private static int[] productArrayWithoutDivision(int[] arr)
    {
        int[] newArr = new int[arr.length];
        List<Integer> list = getList(arr);
        for (int i = 0; i < arr.length; i++) 
        {
            List<Integer> l2 = new ArrayList<>(list);   
            l2.remove(i);
            newArr[i] = productOfAll(l2);
        }
        return newArr;
    }
    private static int productOfAll(List<Integer> list)
    {
        int p = 1;
        for (int i = 0; i < list.size(); i++) 
        {
            p = p * list.get(i);
        }
        return p;
    }
    private static List<Integer> getList(int[] arr)
    {
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) 
        {
            l.add(arr[i]);
        }
        return l;
    }
}
