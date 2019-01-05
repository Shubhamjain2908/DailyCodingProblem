/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP_2;

/**
 * Google
 * @author SHUBHAM
 * Given a string of words delimited by spaces, reverse the words in string. For example, given "hello world here", return "here world hello"
    Follow-up: given a mutable string representation, can you perform this operation in-place?
 */
public class P113_ReverseWordsInString 
{
    public static void main(String[] args) 
    {
        String str = "hello world here";
        System.out.println(reverseWords(str));
    }
    private static String reverseWords(String str)
    {
        String s[] = str.split(" ");
        String rev = "";
        for (int i = s.length-1; i >= 0; i--) 
        {
            rev += s[i] + " ";
        }
        return rev;
    }
}
