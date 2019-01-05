/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author SHUBHAM
 */
public class P12_Staircase 
{
    public static void main(String[] args) 
    {
        System.out.println(noOfWays(18));
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        System.out.println(noOfWays_DP(18, map));
    }
    private static int noOfWays_DP(int stair, Map<Integer,Integer> map)
    {
        if (map.containsKey(stair)) return map.get(stair);
        int x = noOfWays_DP(stair-1, map) + noOfWays_DP(stair-2, map);
        map.put(stair, x);
        return map.get(stair);
    }
    private static int noOfWays(int stair) 
    {
        if (stair == 0 || stair == 1) return 1;
        int[] nums = new int[stair+1];
        nums[0] = 1;
        nums[1] = 1;
        for (int i = 2; i <= stair; i++) 
        {
            nums[i] = nums[i-1] + nums[i-2];
        }
        return nums[stair];
    }
}
