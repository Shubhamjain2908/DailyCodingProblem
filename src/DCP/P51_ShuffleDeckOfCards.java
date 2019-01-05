/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

import java.util.Arrays;
import java.util.Random;

/**
 * Facebook
 * @author SHUBHAM
 *  Given a function that generates perfectly random numbers between 1 and k (inclusive), where k is an input, write a function that shuffles a deck of cards represented as an array using only swaps.
    It should run in O(N) time.
    Hint: Make sure each one of the 52! permutations of the deck is equally likely.
 */
public class P51_ShuffleDeckOfCards 
{
    public static void main(String[] args) 
    {
        int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 
                   9, 10, 11, 12, 13, 14, 15, 
                   16, 17, 18, 19, 20, 21, 22, 
                   23, 24, 25, 26, 27, 28, 29, 
                   30, 31, 32, 33, 34, 35, 36, 
                   37, 38, 39, 40, 41, 42, 43, 
                   44, 45, 46, 47, 48, 49, 50,  
                   51, 52}; 
        shuffleDeck(a);
    }
    private static void shuffleDeck(int[] arr)
    {
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) 
        {
            int index = i + r.nextInt(arr.length-i);
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
