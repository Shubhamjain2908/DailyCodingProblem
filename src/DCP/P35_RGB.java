/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author SHUBHAM
 * Given an array of strictly the characters 'R', 'G', and 'B', segregate the values of the array so that all the Rs come first, the Gs come second, and the Bs come last. You can only swap elements of the array.
Do this in linear time and in-place.
For example, given the array ['G', 'B', 'R', 'R', 'B', 'R', 'G'], it should become ['R', 'R', 'R', 'G', 'G', 'B', 'B'].
 */
public class P35_RGB 
{
    public static void main(String[] args) 
    {
        char[] arr = {'G', 'B', 'R', 'R', 'B', 'R', 'G'};
        char[] a2 = rgbArray(arr);
        System.out.println(Arrays.toString(a2));
    }
    public static char[] rgbArray(char[] arr) 
    {
        char[] r = new char[arr.length];
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) 
        {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
//        map.entrySet().forEach(e->System.out.println(e.getKey() + " -> " + e.getValue()));
        if (map.containsKey('R')) 
        {
            int x = 0;
            for (int i = 0; i < r.length; i++) 
            {
                if ((int)r[i] == 0) {
                    x = i;
                    break;
                }
            }
            for (int i = x; i < map.get('R'); i++) 
            {
                r[i] = 'R';
            }
        }
        if (map.containsKey('G')) 
        {
            int x = 0;
            for (int i = 0; i < r.length; i++) 
            {
                if ((int)r[i] == 0) {
                    x = i;
                    break;
                }
            }
            for (int i = x; i < x + map.get('G'); i++) 
            {
                r[i] = 'G';
            }
        }
        if (map.containsKey('B')) 
        {
            int x = 0;
            for (int i = 0; i < r.length; i++) 
            {
                if ((int)r[i] == 0) {
                    x = i;
                    break;
                }
            }
            for (int i = x; i < x + map.get('B'); i++) 
            {
                r[i] = 'B';
            }
        }
        return r;
    }
}
