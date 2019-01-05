/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Airbnb
 * @author SHUBHAM
 * We're given a hashmap with a key courseId and value a list of courseIds, which represents that the prerequsite of courseId is courseIds. Return a sorted ordering of courses such that we can finish all courses.
Return null if there is no such ordering.
For example, given {'CSC300': ['CSC100', 'CSC200'], 'CSC200': ['CSC100'], 'CSC100': []}, should return ['CSC100', 'CSC200', 'CSCS300'].
 */
public class P92_HashmapOrdering 
{
    public static void main(String[] args) 
    {
        Map<String, List<String>> map = new HashMap<>();
        String c1 = "CSC100";
        String c2 = "CSC200";
        String c3 = "CSC300";
        List<String> l1 = new ArrayList<>();
        List<String> l2 = new ArrayList<>();
        l2.add(c1);
        List<String> l3 = new ArrayList<>();
        l3.add(c1);
        l3.add(c2);
        map.put(c1, l1);
        map.put(c2, l2);
        map.put(c3, l3);
        System.out.println(getOrderedList(map));
    }
    private static List<String> getOrderedList(Map<String, List<String>> map)
    {
        String max = map.entrySet().stream().max((e1,e2) -> e1.getValue().size() > e2.getValue().size() ? 1:-1).get().getKey();
        List<String> str = new ArrayList<>(map.get(max));
        
//        str.addAll(map.get(max));
        str.add(max);
        return str;
    }
}
