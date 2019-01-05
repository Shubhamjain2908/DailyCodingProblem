/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

/**
 *  Amazon
 * @author SHUBHAM 
 * Run-length encoding is a fast and simple method of encoding
 * strings. The basic idea is to represent repeated successive characters as a
 * single count and character. For example, the string "AAAABBBCCDAA" would be
 * encoded as "4A3B2C1D2A".
 */

public class P29_RunLength {

    public static void main(String[] args) {
        String str = "AAAABBBCCDAA";
        String e = compresString(str);
        System.out.println("Encode = " + e);
        String d = decode(e);
        System.out.println("Decoded = " + d);
    }

    public static String compresString(String text) {
        int length = text.length();
        /*
	*  Compression makes sense at length of larger than or equal to 3.
	*  For instance: "aaa" -> "a3"
         */
        if (length > 2) {
            String compressedText = "";
            char lastChar = text.charAt(0);
            int charCount = 1;
            for (int i = 1; i < length; i++) 
            {
                if (text.charAt(i) == lastChar) 
                {
                    charCount++;
                }
                else 
                {
                    compressedText += charCount + Character.toString(lastChar);
                    lastChar = text.charAt(i);
                    charCount = 1;
                }
            }
            compressedText += charCount + Character.toString(lastChar);
            if (compressedText.length() < length) 
            {
                return compressedText;
            }
        }
        return text;
    }

    public static String decode(String str) 
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i += 2) 
        {
            for (int j = 0; j < Integer.valueOf(String.valueOf(str.charAt(i))); j++) 
            {
                sb.append(str.charAt(i + 1));
            }
        }
        return sb.toString();
    }
}
