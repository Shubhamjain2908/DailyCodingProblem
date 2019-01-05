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
 *  Stripe
 *  @author SHUBHAM
 *  Write a map implementation with a get function that lets you retrieve the value of a key at a particular time.
    It should contain the following methods:
    set(key, value, time): sets key to value for t = time.
    get(key, time): gets the key at t = time.
    The map should work like this. If we set a key at a particular time, it will maintain that value forever or until it gets set at a later time. In other words, when we get a key at a time, it should return the value that was set for that key set at the most recent time.
    Consider the following examples:
    d.set(1, 1, 0) # set key 1 to value 1 at time 0
    d.set(1, 2, 2) # set key 1 to value 2 at time 2
    d.get(1, 1) # get key 1 at time 1 should be 1
    d.get(1, 3) # get key 1 at time 3 should be 2
    * 
    d.set(1, 1, 5) # set key 1 to value 1 at time 5
    d.get(1, 0) # get key 1 at time 0 should be null
    d.get(1, 10) # get key 1 at time 10 should be 1
    * 
    d.set(1, 1, 0) # set key 1 to value 1 at time 0
    d.set(1, 2, 0) # set key 1 to value 2 at time 0
    d.get(1, 0) # get key 1 at time 0 should be 2
 */
public class P97_KeyValueTimeMap 
{
    public static void main(String[] args) 
    {
        System.out.println("T1 : ");
        TimeMap t = new TimeMap();
        t.set(1, 1, 0);
        t.set(1, 2, 2);
        System.out.println(t.get(1, 1));
        System.out.println(t.get(1, 3));
        
        System.out.println("T2 : ");
        TimeMap t2 = new TimeMap();
        t2.set(1, 1, 5);
        System.out.println(t2.get(1, 0));
        System.out.println(t2.get(1, 10));
        
        System.out.println("T3 : ");
        TimeMap t3 = new TimeMap();
        t3.set(1, 1, 0);
        t3.set(1, 2, 0);
        System.out.println(t3.get(1, 0));
    }
    static class TimeMap
    {
        private final Map<Integer,List<Node>> map;

        public TimeMap() 
        {
            map = new HashMap<>();
        }
        
        public void set(int key, int value, int time)
        {
            List<Node> l = new ArrayList<>();
            if (map.containsKey(key)) 
            {
                l.addAll(map.get(key));
            }
            l.add(new Node(value,time));
            map.put(key, l);
        }
        
        public int get(int key, int time)
        {
            int ans = Integer.MIN_VALUE;
            if (map.containsKey(key)) 
            {
                List<Node> l = map.get(key);
                boolean found = false;
                for (int i = 0; i < l.size(); i++) 
                {
                    Node n = l.get(i);
                    if (n.getTime() == time) {
                        ans = n.getValue();
                        found = true;
                    } else {
                        if (!found) {
                            if (n.getTime() < time) {
                                ans = n.getValue();
                            }
                        }
                    }
                }
            }
            return ans;
        }
        
        public void print()
        {
            map.entrySet().forEach(e -> {
                System.out.println(e.getKey() + " -> " + e.getValue());
            });
        }
        
        class Node
        {
            private final int value;
            private final int time;

            public Node(int value, int time) {
                this.value = value;
                this.time = time;
            }

            public int getValue() {
                return value;
            }

            public int getTime() {
                return time;
            }
        }
    }
}
