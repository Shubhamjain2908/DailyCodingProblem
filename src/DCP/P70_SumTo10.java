/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

/**
 * Microsoft
 * @author SHUBHAM
 * A number is considered perfect if its digits sum up to exactly 10.

Given a positive integer n, return the n-th perfect number.

For example, given 1, you should return 19. Given 2, you should return 28.
 */
public class P70_SumTo10 
{
    public static void main(String[] args) 
    {
        int n = 90;
        System.out.println(nth10number2(n));
    }
    
    private static int nth10number2(int n)
    {
        // nth = a + (n-1) * d
        int count = 0;
        for (int i = 19; ; i+=9) 
        {
            int sum = 0;
            for (int j = i; j > 0; j = j/10) {
                sum = sum + j%10;
            }
            
            if(sum == 10){               
                count++;
            }
            
            if (count == n) {
                return i;
            }
        }
    }
    
    private static int nth10number(int n)
    {
        int count = 0;
        for (int curr = 1; ; curr++) 
        { 
  
            int sum = 0; 
            for (int x = curr; x > 0; x = x / 10) 
                sum = sum + x % 10; 

            if (sum == 10) 
                count++; 

            if (count == n) 
                return curr; 
        } 
    }
}
