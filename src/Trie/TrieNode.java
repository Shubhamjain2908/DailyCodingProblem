/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trie;

/**
 *
 * @author SHUBHAM
 */
public class TrieNode 
{
    private static final int ALPHABET_SIZE = 26;

    TrieNode[] children = new TrieNode[ALPHABET_SIZE];
    
    boolean isEndOfWord;
    
    public TrieNode()
    {
        isEndOfWord = false;
        for (int i = 0; i < ALPHABET_SIZE; i++) 
        {
            children[i] = null;
        }
    }
}
