/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Alibaba
 * @author SHUBHAM
 * Given an even number (greater than 2), return two prime numbers whose sum will be equal to the given number.
    A solution will always exist. See Goldbach’s conjecture.
    Example:
    Input: 4
    Output: 2 + 2 = 4

    If there are more than one solution possible, return the lexicographically smaller solution.
    If [a, b] is one solution with a <= b, and [c, d] is another solution with c <= d, then
    [a, b] < [c, d]

    If a < c OR a==c AND b < d.
 */
public class P101_2PrimeNoSum 
{
    public static void main(String[] args) 
    {
        System.out.println(Arrays.toString(getPrime(52)));
    }
    private static int[] getPrime(int n) 
    {
        int[] arr = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        List<int[]> set = new ArrayList<>();
        for (int i = 0; i < n; i++) 
        {
            if (isPrime(i)) {
                map.put(i, i);
            }
        }
        List<Integer> keys = new ArrayList<>();
        map.entrySet().forEach(e->keys.add(e.getKey()));
        /*
        for (Integer key : keys) {
            int a = key;
            if (map.containsKey(n - a)) 
            {
                int[] c = {a,n-a};
                set.add(c);
                map.remove(a);
                map.remove(n-a);
            }
        }
        */
        keys.stream().map((key) -> key).filter((a) -> (map.containsKey(n - a))).map((a) -> {
            int[] c = {a,n-a};
            set.add(c);
            map.remove(a);
            return a;
        }).forEachOrdered((a) -> {
            map.remove(n-a);
        });
//        set.forEach(s->System.out.print(Arrays.toString(s) + " "));
        if (set.size() == 1) {
            return set.get(0);
        }
        return set.get(0);
    }
    private static boolean isPrime(int num)
    {
        if ( num > 2 && num%2 == 0 ) 
        {
            return false;
        }
        int top = (int)Math.sqrt(num) + 1;
        for(int i = 3; i < top; i+=2)
        {
            if(num % i == 0)
            {
                return false;
            }
        }
        return true; 
    }
}
