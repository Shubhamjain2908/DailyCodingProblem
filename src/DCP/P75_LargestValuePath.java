/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *  Google
 * @author SHUBHAM
 *  In a directed graph, each node is assigned an uppercase letter. We define a path's value as the number of most frequently-occurring letter along that path. For example, if a path in the graph goes through "ABACA", the value of the path is 3, since there are 3 occurrences of 'A' on the path.
    Given a graph with n nodes and m directed edges, return the largest value path of the graph. If the largest value is infinite, then return null.
    The graph is represented with a string and an edge list. The i-th character represents the uppercase letter of the i-th node. Each tuple in the edge list (i, j) means there is a directed edge from the i-th node to the j-th node. Self-edges are possible, as well as multi-edges.
    For example, the following input graph:
    ABACA
    [(0, 1),
     (0, 2),
     (2, 3),
     (3, 4)]

    Would have maximum value 3 using the path of vertices [0, 2, 3, 4], (A, A, C, A).
    The following input graph:
    A
    [(0, 0)]

    Should return null, since we have an infinite loop.
 */
public class P75_LargestValuePath 
{
    public static void main(String[] args) 
    {
        String g = "ABACA";
        List<int[]> edges = new ArrayList<>();
        int[] c1 = {0,1};
        int[] c2 = {0,2};
        int[] c3 = {2,3};
        int[] c4 = {3,4};
        edges.add(c1);
        edges.add(c2);
        edges.add(c3);
        edges.add(c4);
        System.out.println(getLargestPath(g, edges));
    }
    
    private static int getLargestPath(String graph, List<int[]> paths)
    {
        int count = 0;
        Map<Integer, Character> g = new HashMap<>(graph.length());
        for (int i = 0; i < graph.length(); i++) 
        {
            g.put(i, graph.charAt(i));
        }
        Map<Integer, List<Integer>> edges = new HashMap<>();
        paths.forEach(t -> {
            int x = t[0];
            int y = t[1];
            List<Integer> l = new ArrayList<>();
            if (edges.containsKey(x)) 
            {
                l.addAll(edges.get(x));
            }
            l.add(y);
            edges.put(x, l);
        });
        Set<List<Integer>> sets = new HashSet<>();
        Map<Integer, List<Integer>> map = new HashMap<>(edges);
        List<Integer> l = new ArrayList<>();
        int key = 0;
        while(!map.isEmpty()){
            if (map.containsKey(key)) {
                List<Integer> f = map.get(key);
                int s = f.get(0);
                l.add(s);
                f.remove(0);
                if (f.isEmpty()) {
                    map.remove(key);
                    sets.add(l);
                    l.clear();
                }
                key = s;
            } else{
                map.remove(key);
            }
        }
        return count;
    }
}
