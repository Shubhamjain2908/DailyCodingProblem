/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP_2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Calendar;

/**
 * Riot Games
 * @author SHUBHAM
 * Design and implement a HitCounter class that keeps track of requests (or hits). It should support the following operations:
    •	record(timestamp): records a hit that happened at timestamp
    •	total(): returns the total number of hits recorded
    •	range(lower, upper): returns the number of hits that occurred between timestamps lower and upper (inclusive)
    Follow-up: What if our system has limited memory?
 */
public class P132_HitCounter 
{
    public static void main(String[] args) throws ParseException 
    {
        String s = new Date().toGMTString();
        DateFormat format = new SimpleDateFormat("dd MMM yyyy hh:mm:ss");
        System.out.println(format.parse(s));
//        HitCounter h = new HitCounter();
//        h.hit();
//        h.hit();
//        h.hit();
//        h.hit();
//        h.hit();
//        h.getRecordMap().entrySet().forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));
    }
}
class HitCounter 
{
    private static Map<Double, Date> record;
    private static double id;
    private static int total;
    
    public HitCounter()
    {
        record = new HashMap<>();
        id = 0;
        total = 0;
    }
    
    public void hit() 
    {
        record.put(id + 1, new Date());
        id++;
        total++;
    }
    
    public Map<Double, Date> range(Date start, Date end)
    {
        
        return record;
    }
    
    public int getTotalHits()
    {
        return total;
    }
    
    public Map<Double, Date> getRecordMap()
    {
        return record;
    }
}
class DateValidator 
{
    public boolean isThisDateWithin3MonthsRange(String dateToValidate, String dateFromat) 
    {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
        sdf.setLenient(false);
        try 
        {
            Date date = sdf.parse(dateToValidate);
            // current date after 3 months
            Calendar currentDateAfter3Months = Calendar.getInstance();
            currentDateAfter3Months.add(Calendar.MONTH, 3);

            // current date before 3 months
            Calendar currentDateBefore3Months = Calendar.getInstance();
            currentDateBefore3Months.add(Calendar.MONTH, -3);

            /*************** verbose ***********************/
            System.out.println("\n\ncurrentDate : " + Calendar.getInstance().getTime());
            System.out.println("currentDateAfter3Months : " + currentDateAfter3Months.getTime());
            System.out.println("currentDateBefore3Months : " + currentDateBefore3Months.getTime());
            System.out.println("dateToValidate : " + dateToValidate);
            return date.before(currentDateAfter3Months.getTime()) && date.after(currentDateBefore3Months.getTime()); //ok everything is fine, date in range
        } 
        catch (ParseException e) 
        {
            return false;
        }
    }
}