/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP_2;

import java.util.ArrayList;
import java.util.List;

/**
 * Google
 * @author SHUBHAM
 * Given two strings A and B, return whether or not A can be shifted some number of times to get B.
    For example, if A is abcde and B is cdeab, return true. If A is abc and B is acb, return false.
 */
public class P108_PivotString 
{
    public static void main(String[] args) 
    {
        String A = "abcde";
        String B = "cdeab";
        
        String C = "abc";
        String D = "acb";
        
        System.out.println(canShift(A, B));
        System.out.println(canShift(C, D));
        System.out.println(canShift("aaabcad", "bcadaaa"));
    }
    private static boolean canShift(String A, String B)
    {
        if (A.length() != B.length()) 
        {
            return false;
        }
        char first = A.charAt(0);
        List<Integer> pivotedIndex = new ArrayList<>();
        for (int i = 0; i < B.length(); i++) 
        {
            if (first == B.charAt(i)) 
            {
                pivotedIndex.add(i);
            }
        }
        for (int i = 0; i < pivotedIndex.size(); i++) 
        {
            int index = pivotedIndex.get(i);
            StringBuilder str = new StringBuilder();
            for (int j = index; j < A.length(); j++) 
            {
                str.append(B.charAt(j));
            }
            for (int j = 0; j < index; j++) 
            {
                str.append(B.charAt(j));
            }
            if (str.toString().equals(A) || str.reverse().toString().equals(A)) 
            {
                return true;
            }
        }
        return false;
    }
}
