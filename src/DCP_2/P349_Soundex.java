/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP_2;

import java.util.HashMap;
import java.util.Map;

/**
 * Grammarly
 * @author SHUBHAM
 * Soundex is an algorithm used to categorize phonetically, such that two names that sound alike but are spelled differently have the same representation.
Soundex maps every name to a string consisting of one letter and three numbers, like M460.
One version of the algorithm is as follows:
  1. Remove consecutive consonants with the same sound (for example, change ck -> c).
  2. Keep the first letter. The remaining steps only apply to the rest of the string.
  3. Remove all vowels, including y, w, and h.
  4. Replace all consonants with the following digits:
    o	b, f, p, v → 1
    o	c, g, j, k, q, s, x, z → 2
    o	d, t → 3
    o	l → 4
    o	m, n → 5
    o	r → 6
  5. If you don't have three numbers yet, append zeros until you do. Keep the first three numbers.
Using this scheme, Jackson and Jaxen both map to J250.
Implement Soundex.
 */
public class P349_Soundex {
    
    private static final Map<Character, Integer> charMap = new HashMap<>();
    
    static {
        charMap.put('b', 1);
        charMap.put('f', 1);
        charMap.put('p', 1);
        charMap.put('v', 1);
        
        charMap.put('c', 2);
        charMap.put('g', 2);
        charMap.put('j', 2);
        charMap.put('k', 2);
        charMap.put('q', 2);
        charMap.put('s', 2);
        charMap.put('x', 2);
        charMap.put('z', 2);
    
        charMap.put('d', 3);
        charMap.put('t', 3);
        
        charMap.put('l', 4);
    
        charMap.put('m', 5);
        charMap.put('n', 5);
        
        charMap.put('r', 6);
    }
    
    public static void main(String[] args) {
        String str = "Jackson";
        String str2 = "Jaxen";
        System.out.println(getSoundexString(str));
        System.out.println(getSoundexString(str2));
    }
    
    public static String getSoundexString(String key) {
        key = key.toLowerCase();
        int i = hasConsecutiveConsonants(key);
        while(i != -1 && i != key.length()) {
            key = key.substring(0, i) + key.substring(i+1, key.length());
            i = hasConsecutiveConsonants(key);
        }
        key = removeVowelsYWH(key);
        key = convertInNo(key);
        if (key.length() != 4) {
            while (key.length() != 4) {                
                key += '0';
            }
        } 
        return key;
    }
    private static String convertInNo(String key) {
        StringBuilder sb = new StringBuilder();
        char[] arr = key.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                sb.append(Character.toUpperCase(arr[i]));
            } else {
                sb.append(charMap.get(arr[i]));
            }
        }
        return sb.toString();
    }
    private static boolean isVowel(char c) 
    {
        return (c == 'a') || (c == 'e') ||(c == 'i') || (c == 'o') || (c == 'u'); 
    } 
    private static int hasConsecutiveConsonants(String str) {
        char[] arr = str.toCharArray();
        int i;
        for (i = 1; i < arr.length; i++) {
            if ((!isVowel(arr[i - 1])) && (!isVowel(arr[i]))) {
                return i;
            }
        }
        return -1;
    }
    private static String removeVowelsYWH(String str) {
        char[] arr = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (!isVowel(arr[i]) && arr[i] != 'y' && arr[i] != 'w' && arr[i] != 'h') {
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }
}
