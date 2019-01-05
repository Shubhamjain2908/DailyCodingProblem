/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author SHUBHAM
 * Pallindrome String using stack and Q
 */
public class Q_Challenge 
{
    public static void main(String[] args) 
    {
        String test = "helloolleh";
        System.out.println(isPallin(test));
    }
    public static boolean isPallin(String args) 
    {
        Stack<Character> st = new Stack<>();
        Queue<Character> q = new LinkedList<>();
        String str = args.toLowerCase();
        for (int i = 0; i < str.length(); i++) 
        {
            char c = str.charAt(i);
            if (c>='a' && c<='z') {
                st.push(c);
                q.add(c);
            }
        }
        while(!st.isEmpty()){
            if (!st.pop().equals(q.poll())) return false;
        }
        return true;
    }
}
