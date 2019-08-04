/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP_2;

import Trie.Trie;
import Trie.TrieNode;

/**
 * Google
 * @author SHUBHAM
 * You are given an N by N matrix of random letters and a dictionary of words. Find the maximum number of words that can be packed on the board from the given dictionary.
A word is considered to be able to be packed on the board if:
•	It can be found in the dictionary
•	It can be constructed from untaken letters by other words found so far on the board
•	The letters are adjacent to each other (vertically and horizontally, not diagonally).
Each tile can be visited only once by any word.
For example, given the following dictionary:
{ 'eat', 'rain', 'in', 'rat' }
and matrix:
[['e', 'a', 'n'],
 ['t', 't', 'i'],
 ['a', 'r', 'a']]
Your function should return 3, since we can make the words 'eat', 'in', and 'rat' without them touching each other. We could have alternatively made 'eat' and 'rain', but that would be incorrect since that's only 2 words.

 */
public class P341_BoggleWordsSearch {
    
    // Alphabet size 
    static final int SIZE = 26; 
    
    static final int M = 3; 
    static final int N = 3; 
    
    public static void main(String[] args) {
        String dictionary[] = { "eat", "rain", "in", "rat" }; 
        char boggle[][] = {{'e', 'a', 'n'},
                          {'t', 't', 'i'},
                          {'a', 'r', 'a'}}; 
    
        Trie t = new Trie();
        for (String d : dictionary) {
            t.insert(d);
        }
        findWords(boggle, Trie.getRoot());
    }
    
    private static boolean isSafe(int i, int j, boolean visited[][]) { 
        return (i >=0 && i < N && j >=0 && j < M && !visited[i][j]); 
    } 
    
    // Prints all words present in dictionary. 
    public static void findWords(char boggle[][], TrieNode root) 
    { 
        // Mark all characters as not visited 
        boolean[][] visited = new boolean[N][M]; 
        TrieNode pChild = root ; 
       
        String str = ""; 
       
        // traverse all matrix elements 
        for (int i = 0 ; i < M; i++) 
        { 
            for (int j = 0 ; j < N ; j++) 
            { 
                // we start searching for word in dictionary 
                // if we found a character which is child 
                // of Trie root 
                if (pChild.children[(boggle[i][j]) - 'a'] != null) 
                { 
                    str = str+boggle[i][j]; 
                    searchWord(pChild.children[(boggle[i][j]) - 'a'],boggle, i, j, visited, str); 
                    str = ""; 
                } 
            } 
        } 
    } 

    private static void searchWord(TrieNode root, char[][] boggle, int i, int j, boolean[][] visited, String str) {
        // if we found word in trie / dictionary 
        if (root.isEndOfWord == true) 
           System.out.println(str); 
          
        // If both I and j in  range and we visited 
        // that element of matrix first time 
        if (isSafe(i, j, visited)) 
        { 
            // make it visited 
            visited[i][j] = true; 
       
            // traverse all child of current root 
            for (int K =0; K < SIZE; K++) 
            { 
                if (root.children[K] != null) 
                { 
                    // current character 
                    char ch = (char) (K + 'a') ; 
       
                    // Recursively search reaming character of word 
                    // in trie for all 8 adjacent cells of  
                    // boggle[i][j] 
                    if (isSafe(i+1,j+1,visited) && boggle[i+1][j+1] == ch) 
                        searchWord(root.children[K], boggle, i+1, j+1, visited, str+ch); 
                    if (isSafe(i, j+1,visited) && boggle[i][j+1] == ch) 
                        searchWord(root.children[K], boggle, i, j+1, visited, str+ch); 
                    if (isSafe(i-1, j+1, visited) && boggle[i-1][j+1] == ch) 
                        searchWord(root.children[K], boggle, i-1, j+1, visited, str+ch); 
                    if (isSafe(i+1, j, visited) && boggle[i+1][j] == ch) 
                        searchWord(root.children[K], boggle, i+1, j, visited, str+ch); 
                    if (isSafe(i+1, j-1, visited) && boggle[i+1][j-1] == ch) 
                        searchWord(root.children[K], boggle, i+1, j-1, visited, str+ch); 
                    if (isSafe(i, j-1, visited)&& boggle[i][j-1] == ch) 
                        searchWord(root.children[K], boggle, i, j-1, visited, str+ch); 
                    if (isSafe(i-1, j-1, visited) && boggle[i-1][j-1] == ch) 
                        searchWord(root.children[K], boggle, i-1, j-1, visited, str+ch); 
                    if (isSafe(i-1, j, visited) && boggle[i-1][j] == ch) 
                        searchWord(root.children[K], boggle, i-1, j, visited, str+ch); 
                }
            } 
       
            // make current element unvisited 
            visited[i][j] = false; 
        } 
    }
}
