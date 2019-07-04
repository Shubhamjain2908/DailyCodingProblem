/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP_2;

/**
 * Microsoft
 * @author SHUBHAM
 * Given a clock time in hh:mm format, determine, to the nearest degree, the angle between the hour and the minute hands.
    Bonus: When, during the course of a day, will the angle be zero?
 */
public class P303_HourMinutesAngle 
{
    public static void main(String[] args) 
    {
        String str = "10:20";
        double h = Double.valueOf(str.split(":")[0]);
        double m = Double.valueOf(str.split(":")[1]);
        System.out.println(calcAngle(h, m));
    }
    private static int calcAngle(double h, double m) 
    { 
        // validate the input 
        if (h <0 || m < 0 || h >12 || m > 60) 
            System.out.println("Wrong input"); 
  
        if (h == 12) 
            h = 0; 
        if (m == 60)  
            m = 0; 
  
        // Calculate the angles moved by hour and minute hands 
        // with reference to 12:00 
        int hour_angle = (int)(0.5 * (h*60 + m)); 
        int minute_angle = (int)(6*m); 
  
        // Find the difference between two angles 
        int angle = Math.abs(hour_angle - minute_angle); 
  
        // smaller angle of two possible angles 
        angle = Math.min(360-angle, angle); 
  
        return angle; 
    } 
}
