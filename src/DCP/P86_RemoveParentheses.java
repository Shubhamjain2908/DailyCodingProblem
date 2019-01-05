/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Google
 * @author SHUBHAM
 * Given a string of parentheses, write a function to compute the minimum number of parentheses to be removed to make the string valid (i.e. each open parenthesis is eventually closed).
For example, given the string "()())()", you should return 1. Given the string ")(", you should return 2, since we must remove all of them.
 */
public class P86_RemoveParentheses 
{
    public static void main(String[] args) 
    {
        String s1 = "()())()";
        String s2 = ")(";
        String s3 = "()()(()))()((";
        String s4 = ")))((()";
        System.out.println(removeExtraParentheses(s1));
        System.out.println(removeExtraParentheses(s2));
        System.out.println(removeExtraParentheses(s3));
        System.out.println(removeExtraParentheses(s4));
    }
    private static int removeExtraParentheses(String str)
    {
        int min = 0;
        Deque<String> st = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) 
        {
            String c = String.valueOf(str.charAt(i));
            if (")".equals(c) && "(".equals(st.peekFirst())) 
            {
                st.pop();
            } 
            else if ("(".equals(c)) 
            {
                st.push(c);
            }
            else 
            {
                min++;
            }
        }
        return min + st.size();
    }
}
