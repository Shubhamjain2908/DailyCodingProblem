/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Airbnb
 * @author SHUBHAM
 * You are given a huge list of airline ticket prices between different cities around the world on a given day. These are all direct flights. Each element in the list has the format (source_city, destination, price).
Consider a user who is willing to take up to k connections from their origin city A to their destination B. Find the cheapest fare possible for this journey and print the itinerary for that journey.
For example, our traveler wants to go from JFK to LAX with up to 3 connections, and our input flights are as follows:
[
    ('JFK', 'ATL', 150),
    ('ATL', 'SFO', 400),
    ('ORD', 'LAX', 200),
    ('LAX', 'DFW', 80),
    ('JFK', 'HKG', 800),
    ('ATL', 'ORD', 90),
    ('JFK', 'LAX', 500),
]
Due to some improbably low flight prices, the cheapest itinerary would be JFK -> ATL -> ORD -> LAX, costing $440.
 */
public class P346_CheapestFlightsFare {
    
    private static List<Flight> flights;
    
    public static void main(String[] args) {
        Flight f1 = new Flight("JFK", "ATL", 150);
        Flight f2 = new Flight("ATL", "SFO", 400);
        Flight f3 = new Flight("ORD", "LAX", 200);
        Flight f4 = new Flight("LAX", "DFW", 80);
        Flight f5 = new Flight("JFK", "HKG", 800);
        Flight f6 = new Flight("ATL", "ORD", 90);
        Flight f7 = new Flight("JFK", "LAX", 500);
        flights = new ArrayList<>(Arrays.asList(f1, f2, f3, f4, f5, f6, f7));
        String source = "JFK";
        String destination = "LAX";
        int k = 3;
        System.out.println("Fare -> " + cheapestFare(source, destination, k));
    }
    
    public static int cheapestFare(String source, String destination, int k) {
        Map<String, List<FlightDTO>> cityMap = getCityMap();
        cityMap.entrySet().forEach(e -> {
            System.out.print(e.getKey() + " -> ");
            System.out.println(e.getValue());
        });
        return getCheapestFare(source, destination, k, cityMap, 0, 0);
    }
    
    private static Map<String, List<FlightDTO>> getCityMap() {
        Map<String, List<FlightDTO>> cityMap = new HashMap<>();
        for (int i = 0; i < flights.size(); i++) {
            Flight fl = flights.get(i);
            String dest = fl.getDestination();
            String src = fl.getSource();
            int price = fl.getPrice();
            FlightDTO fd = new FlightDTO(src, price);
            List<FlightDTO> data = new ArrayList<>();
            data.add(fd);
            if (cityMap.containsKey(dest)) {
                data.addAll(cityMap.get(dest));
            }
            cityMap.put(dest, data);
        }
        return cityMap;
    }
    
    private static int getCheapestFare(String src, String dest, int maxStops, Map<String, List<FlightDTO>> cityMap, int totalFare, int stops) {
        if (stops > maxStops) {
            return Integer.MAX_VALUE;
        }
        if (src.equals(dest)) {
            return totalFare;
        }
        List<FlightDTO> fd = cityMap.get(dest);
        List<Integer> allFares = new ArrayList<>();
        for (int i = 0; i < fd.size(); i++) {
            String newDest = fd.get(i).getCity();
            int fare = fd.get(i).getFare();
            int price = getCheapestFare(src, newDest, maxStops, cityMap, totalFare + fare, stops+1);
            allFares.add(price);
        }
        return allFares.stream().reduce(Integer::min).get();
    }
    
    private static class Flight {
        private final String source;
        private final String destination;
        private final int price;

        public Flight(String source, String destination, int price) {
            this.source = source;
            this.destination = destination;
            this.price = price;
        }

        public String getSource() {
            return source;
        }

        public String getDestination() {
            return destination;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return "Flight{" + "source=" + source + ", destination=" + destination + ", price=" + price + '}';
        }
        
    }
    
    private static class FlightDTO {
        private final String city;
        private final int fare;

        public FlightDTO(String city, int fare) {
            this.city = city;
            this.fare = fare;
        }

        public String getCity() {
            return city;
        }

        public int getFare() {
            return fare;
        }
        
        @Override
        public String toString() {
            return "FlightDTO{" + "city=" + city + ", fare=" + fare + '}';
        }
        
    }
}
