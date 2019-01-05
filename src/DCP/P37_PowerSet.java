/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author SHUBHAM
 * The power set of a set is the set of all its subsets. Write a function that, given a set, generates its power set.
For example, given the set {1, 2, 3}, it should return {{}, {1}, {2}, {3}, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}}.
 */
public class P37_PowerSet {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        Set<List<Integer>> set = powerSets(arr);
        set.forEach(System.out::println);
    }
    public static Set<List<Integer>> powerSets(int[] inputArray)
    {   
        Set<List<Integer>> set = new HashSet<>();
        int n = inputArray.length;
        int pow = (int) Math.pow(2, n)-1;
        for (int i = 1; i <= pow; i++) 
        {
            String binary = Integer.toBinaryString(i);
            while(binary.length() != n){
                binary = "0" + binary;
            }
            StringBuilder sb = new StringBuilder();
            List<Integer> l = new ArrayList<>();
            for (int j = 0; j < binary.length(); j++) 
            {
                if (binary.charAt(j) == '1') {
                    sb.append(inputArray[j]);
                    l.add(inputArray[j]);
                }
            }
            set.add(l);
        }
        return set;
    }
}
