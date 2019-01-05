/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 *
 * @author SHUBHAM
 */
public class P20_IntersactionLinkedList 
{
    public static void main(String[] args) 
    {
        LinkedList<Integer> l1 = new LinkedList<>(); 
        LinkedList<Integer> l2 = new LinkedList<>(); 
        for (int i = 0; i <= 5; i++) 
        {
            l1.add(i);
            l2.add(i+5);
        }
        System.out.println(intersaction(l1, l2));
    }
    public static int intersaction(LinkedList<Integer> l1 ,LinkedList<Integer> l2) 
    {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < l1.size(); i++) 
        {
            map.putIfAbsent(l1.get(i), i);
        }
        for (int i = 0; i < l2.size(); i++) 
        {
            if(map.containsKey(l2.get(i))) return l2.get(i);
        }
        return -1;
    }
}
