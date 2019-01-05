/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Yelp
 * @author SHUBHAM
 * Given a mapping of digits to letters (as in a phone number), and a digit string, return all possible letters the number could represent. You can assume each valid number in the mapping is a single digit.
For example if {“2”: [“a”, “b”, “c”], 3: [“d”, “e”, “f”], …} then “23” should return [“ad”, “ae”, “af”, “bd”, “be”, “bf”, “cd”, “ce”, “cf"].
 */
public class P81_NumberDictionary 
{
    static Map<Integer, String[]> map;
    public static void main(String[] args) 
    {
        loadMap();
        String str = "90";
        System.out.println(getMappings(str));
    }
    private static Set<String> getMappings(String str)
    {
        Set<String> sets = new HashSet<>();
        
        // For a 2 digit number
        int x = Integer.valueOf(String.valueOf(str.charAt(0)));
        int y = Integer.valueOf(String.valueOf(str.charAt(1)));
        sets.addAll(getCombinations(map.get(x), map.get(y)));
        
        return sets;
    }
    private static Set<String> getCombinations(String[] s1, String[] s2)
    {
        Set<String> sets = new HashSet<>();
        for (String x : s1) {
            for (String y : s2) {
                sets.add(x + y);
            }
        }
        return sets;
    }
    private static List<Integer> getStringSubsets(String str)
    {
        List<Integer> list = new ArrayList<>();
        int n = str.length();
        
        return list;
    }
    private static void loadMap()
    {
        map = new HashMap<>();
        String[] s0 = {"a","b","c"};
        String[] s1 = {"e","f","g"};
        String[] s2 = {"i","j","k"};
        String[] s3 = {"l","m","n"};
        String[] s4 = {"o","p","q"};
        String[] s5 = {"r","s","t"};
        String[] s6 = {"u","d"};
        String[] s7 = {"v","w"};
        String[] s8 = {"x","y"};
        String[] s9 = {"z","h"};
        map.put(0, s0);
        map.put(1, s1);
        map.put(2, s2);
        map.put(3, s3);
        map.put(4, s4);
        map.put(5, s5);
        map.put(6, s6);
        map.put(7, s7);
        map.put(8, s8);
        map.put(9, s9);
    }
}
