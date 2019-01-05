/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

/**
 * Facebook
 * @author SHUBHAM
 * Given an unordered list of flights taken by someone, each represented as (origin, destination) pairs, and a starting airport, compute the person's itinerary. If no such itinerary exists, return null. If there are multiple possible itineraries, return the lexicographically smallest one. All flights must be used in the itinerary.
For example, given the list of flights [('SFO', 'HKO'), ('YYZ', 'SFO'), ('YUL', 'YYZ'), ('HKO', 'ORD')] and starting airport 'YUL', you should return the list ['YUL', 'YYZ', 'SFO', 'HKO', 'ORD'].
Given the list of flights [('SFO', 'COM'), ('COM', 'YYZ')] and starting airport 'COM', you should return null.
Given the list of flights [('A', 'B'), ('A', 'C'), ('B', 'C'), ('C', 'A')] and starting airport 'A', you should return the list ['A', 'B', 'C', 'A', 'C'] even though ['A', 'C', 'A', 'B', 'C'] is also a valid itinerary. However, the first one is lexicographically smaller.
 */
public class P41_Itinerary
{
    public static void main(String[] args) 
    {
        List<String[]> airports = new ArrayList<>();
//        String[] f1 = {"SFO","HKO"};
//        String[] f2 = {"YYZ","SFO"};
//        String[] f3 = {"YUL","YYZ"};
//        String[] f4 = {"HKO","ORD"};
//        String[] f1 = {"SFO", "COM"};
//        String[] f2 = {"COM", "YYZ"};
        String[] f1 = {"A","B"};
        String[] f2 = {"A","C"};
        String[] f3 = {"B","C"};
        String[] f4 = {"C","A"};
        airports.add(f1);
        airports.add(f2);
        airports.add(f3);
        airports.add(f4);
        String startingAirport = "A";
        List<String> flights = getFlights(airports, startingAirport);
        System.out.println(flights);
    }
    public static List<String> getFlights(List<String[]> airports, String startingAirport) 
    {
        List<String> flights = new ArrayList<>();
        flights.add(startingAirport);
        Map<String, List<String>> map = new HashMap<>();
        airports.forEach(t->{
            List<String> f = new ArrayList<>();
            if (map.containsKey(t[0])) {
                f.addAll(map.get(t[0]));
                f.add(t[1]);
                map.put(t[0], f);
            } else{
                f.add(t[1]);
                map.putIfAbsent(t[0], f);
            }
        });
        String key = startingAirport;
        while(!map.isEmpty()){
            if (map.containsKey(key)) {
                List<String> f = map.get(key);
                String s = f.get(0);
                flights.add(s);
                f.remove(0);
                if (f.isEmpty()) {
                    map.remove(key);
                }
                key = s;
            } else{
                map.clear();
            }
        }
        if (flights.size() <= 2) {
            return new ArrayList<>();
        }
        return flights;
    }
}