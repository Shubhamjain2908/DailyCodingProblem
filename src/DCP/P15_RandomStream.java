/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

import java.util.Random;

/**
 * Facebook
 * @author SHUBHAM
 * Given a stream of elements too large to store in memory, pick a random element from the stream with uniform probability.
 */
public class P15_RandomStream 
{
    public static void main(String[] args) 
    {
        int stream[] = {4,56,8,23,32,1,7,9,0,93,390};
        int n = stream.length; 
        for(int i = 0; i < n; i++) 
        {
            System.out.println("Random number from first " + (i+1) + 
                               " numbers is " + selectRandom(stream[i])); 
        }
    }
    static int res = 0;
    static int count = 0;
    public static int selectRandom(int x) 
    {
        count++;
        if (count == 1) res = x;
        else 
        {
            Random r = new Random();
            int i = r.nextInt(count);
            if(i == count-1) res = x;
        }
        return res;
    }
}
