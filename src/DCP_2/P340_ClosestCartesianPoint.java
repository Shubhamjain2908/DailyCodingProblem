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
 * Given a set of points (x, y) on a 2D cartesian plane, find the two closest points. 
 * For example, given the points [(1, 1), (-1, -1), (3, 4), (6, 1), (-1, -6), (-4, -3)], return [(-1, -1), (1, 1)].
 */
public class P340_ClosestCartesianPoint {
    public static void main(String[] args) {
        List<int[]> points = new ArrayList<>();
        points.add(new int[]{1,1});
        points.add(new int[]{-1,-1});
        points.add(new int[]{3,4});
        points.add(new int[]{6,1});
        points.add(new int[]{-1,-6});
        points.add(new int[]{-4,-3});
        closestPoints(points).forEach(e -> System.out.println(Arrays.toString(e)));
    }
    
    // Brute Force
    public static List<int[]> closestPoints(List<int[]> points) {
        List<int[]> closestPoints = new ArrayList<>();
        double min = Integer.MAX_VALUE;
        for (int i = 0; i < points.size(); i++) {
            int[] c1 = points.get(i);
            for (int j = 0; j < points.size() && j != i; j++) {
                int[] c2 = points.get(j);
                double dis = Math.sqrt(Math.pow(c1[0] - c2[0], 2) + Math.pow(c1[1] - c2[1], 2));
                if (dis < min) {
                    closestPoints.clear();
                    closestPoints.add(c1);
                    closestPoints.add(c2);
                    min = dis;
                }
            }
        }
        return closestPoints;
    }
}
