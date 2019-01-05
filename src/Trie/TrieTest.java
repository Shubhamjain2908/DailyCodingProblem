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
public class TrieTest 
{
    public static void main(String[] args) 
    {
        Trie root = new Trie();
        String keys[] = {"the", "a", "there", "answer", "any", "by", "bye", "their"}; 
        String[] s2 = {"shubham","jain","is","a","great","coder"};
//        for (String key : s2) {
//            root.insert(key);
//        }
        for (String key : keys) {
            root.insert(key);
        }
        root.display();
    }
}
