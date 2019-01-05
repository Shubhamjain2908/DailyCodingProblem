/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Snapchat
 * @author SHUBHAM
 * Given an array of time intervals (start, end) for classroom lectures (possibly overlapping), find the minimum number of rooms required.
   For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.
 */
public class P21_NoOfClassroom 
{
    public static void main(String[] args) 
    {
        List<int[]> list = new ArrayList<>();

        int[] c1 = {30,45};
        int[] c2 = {0,50};
        int[] c3 = {60,150};
        
        list.add(c1);
        list.add(c2);
        list.add(c3);
        System.out.println(noOfClasses(list));
    }
    public static int noOfClasses(List<int[]> list) 
    {
        int cls[] = {0};
        
        int[] max = {Integer.MIN_VALUE};
        int[] min = {Integer.MAX_VALUE};
        
        Map<Integer, Integer> map = new TreeMap<>();
        
        list.forEach(t -> {
            int x = t[0];
            int y = t[1];
            if (y > max[0]) 
            {
                max[0] = y;
            }
            if (x < min[0]) {
                min[0] = x;
            } 
        });
        for (int i = min[0]; i <= max[0]; i++) 
        {
            map.put(i, -1);
        }
        list.forEach(t -> {
            int x = t[0];
            int y = t[1];
            map.put(x, 1);
            map.put(y, 1);
            for (int i = x+1; i < y; i++) {
                map.put(i, 0);
            }
        });
//        map.entrySet().forEach(e->System.out.println(e.getKey() + " -> " + e.getValue())); 
        list.forEach(t -> {
            int x = t[0];
            int y = t[1];
            if (map.get(x) == 0 || map.get(y) == 0) {
                cls[0]++;
            }
        });
        return cls[0]+1;
    }
}
