/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP_2;

/**
 * Google
 * @author SHUBHAM
 * Given a word W and a string S, find all starting indices in S which are anagrams of W.
    For example, given that W is "ab", and S is "abxaba", return 0, 3, and 4.
 */
public class P111_AnagramIndices 
{
    public static void main(String[] args) 
    {
        String S = "abxaba";
        String W = "ab"; 
        search(W, S);
    }
    static boolean compare(char arr1[], char arr2[]) 
    {
        for (int i = 0; i < 256; i++) 
            if (arr1[i] != arr2[i]) 
                return false; 
        return true; 
    } 
  
    // This function search for all permutations 
    // of pat[] in txt[] 
    static void search(String pat, String txt) 
    { 
        int M = pat.length(); 
        int N = txt.length(); 
    
        // countP[]:  Store count of all  
        // characters of pattern 
        // countTW[]: Store count of current 
        // window of text 
        char[] countP = new char[256]; 
        char[] countTW = new char[256]; 
        for (int i = 0; i < M; i++) 
        { 
            (countP[pat.charAt(i)])++; 
            (countTW[txt.charAt(i)])++; 
        } 
        
        // Traverse through remaining characters 
        // of pattern 
        for (int i = M; i < N; i++) 
        { 
            // Compare counts of current window 
            // of text with counts of pattern[] 
            if (compare(countP, countTW)) 
                System.out.println("Found at Index " + 
                                          (i - M)); 
              
            // Add current character to current  
            // window 
            (countTW[txt.charAt(i)])++; 
  
            // Remove the first character of previous 
            // window 
            countTW[txt.charAt(i-M)]--; 
        } 
        
        // Check for the last window in text 
        if (compare(countP, countTW)) 
            System.out.println("Found at Index " +  
                                       (N - M)); 
        
    }
}
