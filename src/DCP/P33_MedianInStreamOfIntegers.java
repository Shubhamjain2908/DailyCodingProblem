/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

/**
 *
 * @author SHUBHAM
 */
public class P33_MedianInStreamOfIntegers 
{
    public static void main(String[] args) 
    {
        int[] arr = {2, 1, 5, 7, 2, 0, 5};
        for (int i = 0; i < arr.length; i++) 
        {
            int[] nArr = new int[arr.length];
            System.arraycopy(arr, 0, nArr, i+1, i+1);
            System.out.println(calculteMedian(nArr));
        }
    }
    private static int calculteMedian(int[] arr)
    {
        int med = 0;
        int l = arr.length;
        if (l%2==0) {
            med = arr[l/2] + arr[(l/2)+1];
        } else {
            med = arr[l/2];
        }
        return med;
    }
}
