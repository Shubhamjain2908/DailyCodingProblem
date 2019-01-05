/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Microsoft
 * @author SHUBHAM
 * Given a dictionary of words and a string made up of those words (no spaces), return the original sentence in a list. If there is more than one possible reconstruction, return any of them. If there is no possible reconstruction, then return null.
 * For example, given the set of words 'quick', 'brown', 'the', 'fox', and the string "thequickbrownfox", you should return ['the', 'quick', 'brown', 'fox'].
 * Given the set of words 'bed', 'bath', 'bedbath', 'and', 'beyond', and the string "bedbathandbeyond", return either ['bed', 'bath', 'and', 'beyond] or ['bedbath', 'and', 'beyond'].
 */
public class P22_DictionaryWords 
{
    public static void main(String[] args) 
    {
//        String str = "thequickbrownfox";
//        String[] dictionary = {"quick", "brown", "the", "fox"};
        String str = "bedbathandbeyond";
        String[] dictionary = {"bed", "bath", "bedbath", "and", "beyond"};
        List<String> words = findWords(dictionary, str);
        System.out.println(words);
    }
    public static List<String> findWords(String[] dict, String str) 
    {
        List<String> words = new ArrayList<>();
        for (String st : dict) 
        {
            if (str.contains(st)) 
            {
                words.add(st);
            }
            str = str.replace(st,"");
        }
        return words;
    }
}
