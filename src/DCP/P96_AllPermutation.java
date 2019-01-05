/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Microsoft
 * @author SHUBHAM
 * Given a number in the form of a list of digits, return all possible permutations.
   For example, given [1,2,3], return [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]].
 */
public class P96_AllPermutation 
{
    public static void main(String[] args) 
    {
        int[] arr = {1,2,3};
        P96_AllPermutation p = new P96_AllPermutation();
        p.getPermutations(arr).forEach(t->System.out.println(Arrays.toString(t)));
    }
    private final List<char[]> list = new ArrayList<>();
    private List<char[]> getPermutations(int[] arr)
    {
//        String str = Integer.toString(arr).chars().map(c -> c-'0').toArray();
//        int[] intArray = Arrays.stream(arr).mapToInt(Integer::intValue).toArray();
        String str = "";
        for (int i = 0; i < arr.length; i++) 
        {
            str += arr[i];
        }
        permute(str, 0, arr.length-1);
        return list;
    }
    private void permute(String str, int l, int r) 
    { 
        if (l == r) {
            char[] c = str.toCharArray();
            list.add(c);
        }   
        else
        { 
            for (int i = l; i <= r; i++) 
            { 
                str = swap(str,l,i); 
                permute(str, l+1, r); 
                str = swap(str,l,i); 
            } 
        } 
    } 
  
    /** 
     * Swap Characters at position 
     * @param a string value 
     * @param i position 1 
     * @param j position 2 
     * @return swapped string 
     */
    public String swap(String a, int i, int j) 
    { 
        char temp; 
        char[] charArray = a.toCharArray(); 
        temp = charArray[i] ; 
        charArray[i] = charArray[j]; 
        charArray[j] = temp; 
        return String.valueOf(charArray); 
    }  
}
