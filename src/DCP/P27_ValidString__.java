/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;
import java.util.Stack;
/**
 * Facebook
 * @author SHUBHAM
 * Given a string of round, curly, and square open and closing brackets, return whether the brackets are balanced (well-formed).
    For example, given the string "([])[]({})", you should return true.
    Given the string "([)]" or "((()", you should return false.
 */
public class P27_ValidString__ 
{
    public static void main(String[] args) 
    {
        String s1 = "([])[]({})";
        String s2 = "([)]";
        String s3 = "((()";
        System.out.println(isValid(s1));
        System.out.println(isValid(s2));
        System.out.println(isValid(s3));
    }
    private static boolean isValid(String str)
    {
        int l = str.length();
        if(l%2!=0) return false;
        Stack<String> st = new Stack<>();
        String first = String.valueOf(str.charAt(0));
        if (first.equals("}") || first.equals(")") || first.equals("]")) return false;
        st.push(first);
        for (int i = 1; i < l; i++) 
        {
            String s = String.valueOf(str.charAt(i));
            
            if (s.equals("{") || s.equals("(") || s.equals("[")) st.push(s);
            if (s.equals("}") && st.peek().equals("{") || s.equals(")") && st.peek().equals("(") || s.equals("]") && st.peek().equals("[")) st.pop();
        }
        return st.isEmpty();
    } 
}
