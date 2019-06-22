/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dailycodingproblem;

import java.io.*;
import java.util.*;
import java.lang.Math;

public class DailyCodingProblem {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         PrintWriter wr = new PrintWriter(System.out);
         long[][] arr = new long[1][3];
         for(int i_arr=0; i_arr<1; i_arr++)
         {  String[] arr_arr = br.readLine().split(" ");
         	for(int j_arr=0; j_arr<arr_arr.length; j_arr++)
         	{
         		arr[i_arr][j_arr] = Long.parseLong(arr_arr[j_arr]);
         	}
         }
         int[] out_ = Solution(arr,1);
         for (int i_out_=0; i_out_<1; i_out_++)
         {
            System.out.println(out_[i_out_]);
         }
         wr.close();
         br.close();
    }
    static int[] Solution(long[][] arr,int n){
        int[] a = new int[n];
        double log3 = Math.log(3);
        for (int i=0; i<n; i++)
        {
            int count = 0;
            long N = arr[i][0];
            long u = arr[i][1];
            long v = arr[i][2];
            
            long diff = Math.abs(v-u);
            while((int)diff != 3 && diff > 0) {
                
                int roundLog = (int)Math.floor(Math.log(diff) / log3);
                long powerOfTwo = power(3, roundLog);
                count += (int)roundLog;
                diff -= powerOfTwo;
            }
            count++;
            a[i] = count;
        }
        return a;
    }
    static int power(int x, int y) 
    { 
        // Initialize result 
        int res = 1;  
      
        while (y > 0)  
        { 
            // If y is odd,  
            // multiply 
            // x with result 
            if ((y & 1) == 1) 
                res = res * x; 
      
            // n must be even now 
            y = y >> 1; // y = y/2 
            x = x * x; // Change x to x^2 
        } 
        return res; 
    } 
}