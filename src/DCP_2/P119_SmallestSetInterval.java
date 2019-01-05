/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Google
 * @author SHUBHAM
 * Given a set of closed intervals, find the smallest set of numbers that covers all the intervals. If there are multiple smallest sets, return any of them.
    For example, given the intervals [0, 3], [2, 6], [3, 4], [6, 9], one set of numbers that covers all these intervals is {3, 6}.
 */
public class P119_SmallestSetInterval 
{
    public static void main(String[] args) 
    {
        List<int[]> list = new ArrayList<>();
        int[] c1 = {0,3};
        int[] c2 = {2,6};
        int[] c3 = {3,4};
        int[] c4 = {6,9};
        list.add(c1);
        list.add(c2);
        list.add(c3);
        list.add(c4);
        System.out.println(getInterval(list));
    }
    private static List<Integer> getInterval(List<int[]> list)
    {
        int[] max = {0};
        list.forEach(t -> {
            int x = t[0];
            int y = t[1];
            if(max[0] < x) {
                max[0] = x;
            }
            if(max[0] < y) {
                max[0] = y;
            }
        });
        boolean b[] = new boolean[max[0]+1];
        list.forEach(t -> {
            int x = t[0];
            int y = t[1];
            b[x] = true;
            b[y] = true;
        });
        System.out.println(Arrays.toString(b));
        return null;
    }
}