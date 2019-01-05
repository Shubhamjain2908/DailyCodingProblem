/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP_2;

import java.util.ArrayList;
import java.util.List;

/**
 * Google
 * @author SHUBHAM
 * You are in an infinite 2D grid where you can move in any of the 8 directions:
    (x,y) to
    (x+1, y),
    (x - 1, y),
    (x, y+1),
    (x, y-1),
    (x-1, y-1),
    (x+1,y+1),
    (x-1,y+1),
    (x+1,y-1)

   You are given a sequence of points and the order in which you need to cover the points. Give the minimum number of steps in which you can achieve it. You start from the first point.
   Example:
   Input: [(0, 0), (1, 1), (1, 2)]
   Output: 2

   It takes 1 step to move from (0, 0) to (1, 1). It takes one more step to move from (1, 1) to (1, 2).
 */
public class P100_2DGrid 
{
    public static void main(String[] args) 
    {
        List<int[]> seq = new ArrayList<>();
        int[] c1 = {0,0};
        int[] c2 = {1,1};
        int[] c3 = {1,2};
        seq.add(c1);
        seq.add(c2);
        seq.add(c3);
        System.out.println(noOfSteps(seq));
    }
    private static int noOfSteps(List<int[]> sequence)
    {
        int count = 0;
        for (int i = 0; i < sequence.size()-1; i++) 
        {
            int[] c1 = sequence.get(i);
            int[] c2 = sequence.get(i+1);
            count += Math.max(c2[0]-c1[0], c2[1]-c1[1]);
        }
        return count;
    }
}
