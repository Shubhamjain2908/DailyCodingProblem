/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/**
 * Microsoft
 * @author SHUBHAM
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
    For example, given [100, 4, 200, 1, 3, 2], the longest consecutive element sequence is [1, 2, 3, 4]. Return its length: 4.
    Your algorithm should run in O(n) complexity.
 */
public class P99_LongestConsecutiveElementsSequence 
{
    public static void main(String[] args) 
    {
        int[] arr = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(arr));
    }
    private static int longestConsecutiveSequence(int[] arr)
    {
        int max = Arrays.stream(arr).max().getAsInt();
        boolean[] newArr = new boolean[max];
        for (int i = 0; i < arr.length; i++) 
        {
            newArr[i] = true;
        }
        int m1 = 1;
        int m2 = 1;
        boolean found = true;
        for (int i = 0; i < max; i++) 
        {
            if (newArr[i] && newArr[i+1]) {
                m1++;
            }
            else 
            {
                m2 = Math.max(m1, m2);
                m1 = 0;
            }
        }
        return m2;
    }
    public static int longestConsecutive(int[] num) 
    {
	// if array is empty, return 0
	if (num.length == 0) {
		return 0;
	}
 
	Set<Integer> set = new HashSet<>();
	int max = 1;
 
	for (int e : num)
		set.add(e);
 
	for (int e : num) 
        {
            int left = e - 1;
            int right = e + 1;
            int count = 1;

            while (set.contains(left)) 
            {
                count++;
                set.remove(left);
                left--;
            }

            while (set.contains(right)) 
            {
                count++;
                set.remove(right);
                right++;
            }

            max = Math.max(count, max);
	}
	return max;
    }
}
    