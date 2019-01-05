/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

import java.util.HashSet;
import java.util.Set;

/**
 * Amazon
 * @author SHUBHAM
 * Given a string, find the longest palindromic contiguous substring. If there are more than one with the maximum length, return any one.
For example, the longest palindromic substring of "aabcdcb" is "bcdcb". The longest palindromic substring of "bananas" is "anana".
 */
public class P46_LongestPallindrome 
{
    public static void main(String[] args) 
    {
        String str = "aabcdcb";
        String str2 = "bananas";
        //System.out.println(longestPalin(str));
        System.out.println(longestPalSubstr(str));
    }
    // A utility function to print a substring str[low..high] 
    static void printSubStr(String str, int low, int high) { 
        System.out.println(str.substring(low, high + 1)); 
    } 
  
    // This function prints the longest palindrome substring  
    // (LPS) of str[]. It also returns the length of the   
    // longest palindrome  
    static int longestPalSubstr(String str) { 
        int maxLength = 1; // The result (length of LPS) 
  
        int start = 0; 
        int len = str.length(); 
  
        int low, high; 
  
        // One by one consider every character as center 
        // point of even and length palindromes 
        for (int i = 1; i < len; ++i)  
        { 
            // Find the longest even length palindrome with  
            // center points as i-1 and i. 
            low = i - 1; 
            high = i; 
            while (low >= 0 && high < len 
                    && str.charAt(low) == str.charAt(high)) { 
                if (high - low + 1 > maxLength) { 
                    start = low; 
                    maxLength = high - low + 1; 
                } 
                --low; 
                ++high; 
            } 
  
            // Find the longest odd length palindrome with  
            // center point as i 
            low = i - 1; 
            high = i + 1; 
            while (low >= 0 && high < len 
                    && str.charAt(low) == str.charAt(high)) { 
                if (high - low + 1 > maxLength) { 
                    start = low; 
                    maxLength = high - low + 1; 
                } 
                --low; 
                ++high; 
            } 
        } 
  
        System.out.print("Longest palindrome substring is: "); 
        printSubStr(str, start, start + maxLength - 1); 
  
        return maxLength; 
    } 
    // Bad solution
    // O(2n^2)
    private static String longestPalin(String str)
    {
        Set<String> set = getSubstring(str);
        int[] maxL = {0};
        String[] longestString = {""}; 
        set.forEach(t -> {
            if (t.length() >= maxL[0]) 
            {
                maxL[0] = t.length();
                longestString[0] = t;
            }
        });
        return longestString[0];
    }
    private static Set<String> getSubstring(String str)
    {
        Set<String> set = new HashSet<>();
        int n = str.length();
        int pow = (int)Math.pow(2, n) - 1;
        for (int i = 1; i < pow; i++) 
        {
            String binary = Integer.toBinaryString(i);
            while(binary.length() != n)
            {
                binary = "0" + binary;
            }
            String s = "";
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) 
            {
                if (binary.charAt(j) == '1') 
                {
                    s = s + String.valueOf(str.charAt(j));
                    sb.append(str.charAt(j));
                }
            }
            if (sb.reverse().toString().equals(s)) 
            {
                set.add(s);
            }
        }
        return set;
    }
}
