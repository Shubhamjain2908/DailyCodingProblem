/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *  Amazon
 *  @author SHUBHAM
 *  Given a string s and an integer k, break up the string into multiple texts such that each text has a length of k or less. You must break it up so that words don't break across lines. If there's no way to break the text up, then return null.
    You can assume that there are no spaces at the ends of the string and that there is exactly one space between each word.
    For example, given the string "the quick brown fox jumps over the lazy dog" and k = 10, you should return: ["the quick", "brown fox", "jumps over", "the lazy", "dog"]. No string in the list has a length of more than 10.
 */
public class P57_BreakStringInK 
{
    public static void main(String[] args) 
    {
        String str = "the quick brown fox jumps over the lazy dog";
        String str2 = "The trim() method will remove both leading and trailing whitespace from a string and return the result.";
        int k = 10;
        System.out.println(addLinebreaks(str2, k));
    }
    private static List<String> addLinebreaks(String input, int maxLineLength) 
    {    
        StringTokenizer tok = new StringTokenizer(input, " ");
        StringBuilder output = new StringBuilder();
        int count = 0;
        while (tok.hasMoreTokens()) {
            String word = tok.nextToken();

            if (count + word.length() > maxLineLength) {
                output.append("\n");
                count = 0;
            }
            output.append(word).append(" ");
            count += word.length() + 1;
        }
        String[] p = output.toString().split("\n");
        List<String> list = new ArrayList<>();
        for (String l: p) {
            list.add(l.trim());
        }
        return list;
    }
}
