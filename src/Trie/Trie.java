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
public class Trie 
{
    private static TrieNode root;

    public static TrieNode getRoot() {
        return root;
    }
    
    public Trie()
    {
        root = new TrieNode();
    }
    
    public void insert(String key)
    {
        int length = key.length();
        int index;
        int level;
        
        TrieNode pCrawl = root;
        
        for (level = 0; level < length; level++) 
        {
            index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null) {
                pCrawl.children[index] = new TrieNode();
            }
            pCrawl = pCrawl.children[index];
        }
        
        pCrawl.isEndOfWord = true;
    }
    
    public boolean search(String key)
    {
        int length = key.length();
        int index;
        int level;
        
        TrieNode pCrawl = root;
        
        for (level = 0; level < length; level++) 
        {
            index = key.charAt(level) - 'a';
            
            if (pCrawl.children[index] == null) {
                return false;
            }
            
            pCrawl = pCrawl.children[index];
        }
        
        return (pCrawl != null && pCrawl.isEndOfWord);
    }
    
    public void display()
    {
        if (root != null) {
            char[] str = new char[26];
            show(root, str, 0);
        }
    }
    private void show(TrieNode root, char[] str, int level)
    {
        if (root.isEndOfWord != false) {
            str[level] = '\0';
            System.out.println(new String(str));
        }
        
        for (int i = 0; i < 26; i++)
        {
            if (root.children[i] != null) {
                //System.out.println("cc :-> " + (char) (i + 'a'));
                str[level] = (char) (i + 'a');
                show(root.children[i], str, level+1);
            }
        }
    }
}
