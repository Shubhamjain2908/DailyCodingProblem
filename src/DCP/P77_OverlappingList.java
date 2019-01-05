/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  Snapchat
 *  @author SHUBHAM
 *  Given a list of possibly overlapping intervals, return a new list of intervals where all overlapping intervals have been merged.
    The input list is not necessarily ordered in any way.
    For example, given [(1, 3), (5, 8), (4, 10), (20, 25)], you should return [(1, 3), (4, 10), (20, 25)].
 */
public class P77_OverlappingList 
{
    public static void main(String[] args) 
    {
        List<int[]> list = new ArrayList<>();
        int[] c1 = {1,3};
        int[] c2 = {5,8};
        int[] c3 = {4,10};
        int[] c4 = {20,25};
        
//        int[] c1 = {6,8};
//        int[] c2 = {1,9};
//        int[] c3 = {2,4};
//        int[] c4 = {4,7};

        list.add(c1);
        list.add(c2);
        list.add(c3);
        list.add(c4);
        overlappedList(list).forEach(t->System.out.println(Arrays.toString(t)));
    }
    private static List<int[]> overlappedList(List<int[]> list)
    {
        List<int[]> ol = new ArrayList<>();
        int min[] = {Integer.MAX_VALUE};
        int max[] = {Integer.MIN_VALUE};
        list.forEach(t->{
            int x = t[0];
            int y = t[1];
            if (x > y) 
            {
                if (x > max[0]) 
                {
                    max[0] = x;
                }
                if (y < min[0]) {
                    min[0] = y;
                }
            }
            else 
            {
                if (y > max[0]) 
                {
                    max[0] = y;
                }
                if (x < min[0]) {
                    min[0] = x;
                }
            }
        });
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = min[0]; i <= max[0]; i++) 
        {
            map.put(i, 1);
        }
        list.forEach(t->{
            int x = t[0];
            int y = t[1];
            for (int i = x+1; i < y; i++) 
            {
                if (map.get(i) == 1) {
                    map.put(i,0); 
                }
            }
        });
        list.forEach(t->{
            int x = t[0];
            int y = t[1];
            if (map.get(x) == 1 && map.get(y) == 1) {
                ol.add(t);
            }
        });
        return ol;
    }
}
