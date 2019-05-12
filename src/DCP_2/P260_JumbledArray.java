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
 * Pinterest
 * @author SHUBHAM
 * The sequence [0, 1, ..., N] has been jumbled, and the only clue you have for its order is an array representing whether each number is larger or smaller than the last. 
 * Given this information, reconstruct an array that is consistent with it. 
 * For example, given [None, +, +, -, +], you could return [1, 2, 3, 0, 4].
 */
public class P260_JumbledArray {
    public static void main(String[] args) {
        String[] arr = {"None", "+", "+", "-", "+"};
        List<String> al = new ArrayList<>(Arrays.asList(arr));
        System.out.println(deduceArray(al));
    }
    public static List<Integer> deduceArray(List<String> al) {
        int n = al.size();
        List<Integer> list = new ArrayList<>();
        int plusCount = (int)al.stream().filter(e -> "+".equals(e)).count();
        int first = n - plusCount - 1;
        list.add(first);
        int small = first - 1, large = first + 1;
        for (int i = 1; i < n; i++) {
            if ("+".equals(al.get(i))) {
                list.add(large);
                large += 1;
            } else {
                list.add(small);
                small -= 1;
            }
        }
        return list;
    }
}
