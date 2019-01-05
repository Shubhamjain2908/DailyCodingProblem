/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

import java.util.Random;

/**
 *
 * @author SHUBHAM
 */
public class P14_PiCalculatingMonteCarlo 
{
    public static void main(String[] args) 
    {
        System.out.println(calPi());
    }
    private static String calPi()
    {
        String pi = "";
        int x=0,y=0,interval=100,d;
        Random r = new Random();
        for (int i = 0; i < interval; i++) 
        {
            x = r.nextInt();
            y = r.nextInt();
            d = x*x + y*y;
            System.out.println(d);
            if (d <= 1) {
                x+=1;
                y+=1;
            }
        }
        double ds = 4 * (x/y);
        pi = String.valueOf(ds);
        return pi;
    }
}
