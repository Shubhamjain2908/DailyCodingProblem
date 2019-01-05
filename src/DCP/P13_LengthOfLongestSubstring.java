/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

import java.util.HashMap;
import java.util.Map;

/**
 * Amazon
 * @author SHUBHAM
 * Given an integer k and a string s, find the length of the longest substring that contains at most k distinct characters.
For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb".
 */
public class P13_LengthOfLongestSubstring 
{
    public static void main(String[] args) 
    {
        String test = "abcba";
        System.out.println(lenghtOfLongestSubstring(test, 2));
    }
    private static int lenghtOfLongestSubstring(String s, int k)
    {
        if(k==0 || s==null || s.length()==0) return 0;
 
        if(s.length()<k) return s.length();
        
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = k;
        int left = 0;
        for (int i = 0; i < s.length(); i++) 
        {
            char c = s.charAt(i);
            if (map.containsKey(c)) map.put(c, map.get(c)+1);
            else
            {
                map.put(c, 1);
            }
            
            if (map.size()>k) 
            {
                maxLen = Math.max(maxLen, i-left);
                
                while(map.size()>k)
                {
                    char fc = s.charAt(left);
                    if (map.get(fc) == 1) 
                    {
                        map.remove(fc);
                    }
                    else 
                    {
                        map.put(fc, map.get(fc) - 1);
                    }
                    left++;
                }
            }
        }
        maxLen = Math.max(maxLen, s.length()-left);
        return maxLen;
    }
}
