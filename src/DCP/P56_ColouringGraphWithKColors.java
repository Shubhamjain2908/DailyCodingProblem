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
import java.util.Stack;

/**
 * Google
 * @author SHUBHAM
 * Given an undirected graph represented as an adjacency matrix and an integer k, write a function to determine whether each vertex in the graph can be colored such that no two adjacent vertices share the same color using at most k colors.
 */
public class P56_ColouringGraphWithKColors 
{
    private static int[][] adjMatrix;
    private static final Map<Integer, List<Integer>> nodes = new HashMap<>();
    private static Map<Integer, String> ans = new HashMap<>(); 
    private static List<String> colors = new ArrayList<>();
    private static Stack<String> completed = new Stack<>();
    public static void main(String[] args) 
    {
        DCP56_Graph graph = new DCP56_Graph(10);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.addEdge(6, 7);
        graph.addEdge(7, 8);
        graph.addEdge(8, 9);
        graph.addEdge(9, 0);
        int k = 6;
        adjMatrix = graph.getAdjMatrix();
        if (solve(adjMatrix, k)) {
            ans.entrySet().forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));
        }
        mColoringProblem color = new mColoringProblem();
        color.graphColoring(adjMatrix, k);
    }
    
    private static boolean solve(int[][] matrix, int k)
    {
        fillMap();
        fillColors(k);
        nodes.keySet().forEach(s -> ans.put(s, ""));
        if (!backtrack(0, 0)) {
            System.out.println("Cannot be solved!!");
            return false;
        }
        System.out.println("Solved!!!");
        return true;
    }
    
    private static boolean backtrack(int nodeIndex, int optionIndex)
    {
        while(optionIndex < colors.size())
        {
            if (!isPossible(nodeIndex, colors.get(optionIndex))) 
            {
                optionIndex += 1;
            }
            else 
            {
                ans.put(nodeIndex, colors.get(optionIndex));
                completed.push(colors.get(optionIndex)); 
                if (completed.size() == nodes.size()) 
                {
                    return true;
                } 
                else
                {
                    if (backtrack(nodeIndex+1, 0)) {
                        return true;
                    }
                    else 
                    {
                        ans.put(nodeIndex, "");
                        colors.add(completed.pop());
                        optionIndex += 1;
                    }
                }
            }
        }
        return false;
    }
    
    private static boolean isPossible(int nodeIndex, String color)
    {
        List<Integer> adjacentNodes = nodes.get(nodeIndex);
        for (int i = 0; i < adjacentNodes.size(); i++) {
            int g = adjacentNodes.get(i);
            if (ans.get(g) == null ? color == null : ans.get(g).equals(color)) {
                return false;
            }
        }
        return true;
    }
    
    private static void fillMap()
    {
        for (int i = 0; i < adjMatrix.length; i++) {
            List<Integer> l = new ArrayList<>();
            for (int j = 0; j < adjMatrix[i].length; j++) {
                if (adjMatrix[i][j] == 1) {
                    l.add(j);
                }
            }
            nodes.put(i, l);
        }
    }
    
    private static void fillColors(int k)
    {
        for (int i = 0; i < k; i++) 
        {
            colors.add("Color " + i);
        }
    }
    
}
class DCP56_Graph
{
    private final int V;
    private final List<Integer>[] adjListArray;
    private final int[][] adjMatrix;

    public int getV() {
        return V;
    }

    public List<Integer>[] getAdjListArray() {
        return adjListArray;
    }

    public int[][] getAdjMatrix() {
        return adjMatrix;
    }
    
    
    
    public DCP56_Graph(int V)
    {
        this.V = V;
        adjListArray = new ArrayList[V];
        adjMatrix = new int[V][V];
        
        for (int i = 0; i < V; i++) 
        {
            adjListArray[i] = new ArrayList<>();
        }
    }
    
    public void addEdge(int src, int dest)
    {
        adjListArray[src].add(dest);
        adjListArray[dest].add(src);
        
        adjMatrix[src][dest] = 1;
        adjMatrix[dest][src] = 1;
    }
    
    public void printAdjacencyList()
    {
        for (int i = 0; i < V; i++) 
        {
            System.out.print("head " + i + " : ");
            for (Integer p: adjListArray[i]) {
                System.out.print(" -> " + p);
            }
            System.out.println("");
        }
    }
    
    public void printAdjacencyMatrix()
    {
        for (int i = 0; i < adjMatrix.length; i++) 
        {
            for (int j = 0; j < adjMatrix[i].length; j++) 
            {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println("");
        }
    } 
}
/* Java program for solution of M Coloring problem 
   using backtracking */
class mColoringProblem { 
    final int V = 10; 
    int color[]; 
  
    /* A utility function to check if the current 
       color assignment is safe for vertex v */
    boolean isSafe(int v, int graph[][], int color[], 
                   int c) 
    { 
        for (int i = 0; i < V; i++) 
            if (graph[v][i] == 1 && c == color[i]) 
                return false; 
        return true; 
    } 
  
    /* A recursive utility function to solve m 
       coloring  problem */
    boolean graphColoringUtil(int graph[][], int m, 
                              int color[], int v) 
    { 
        /* base case: If all vertices are assigned 
           a color then return true */
        if (v == V) 
            return true; 
  
        /* Consider this vertex v and try different 
           colors */
        for (int c = 1; c <= m; c++) 
        { 
            /* Check if assignment of color c to v 
               is fine*/
            if (isSafe(v, graph, color, c)) 
            { 
                color[v] = c; 
  
                /* recur to assign colors to rest 
                   of the vertices */
                if (graphColoringUtil(graph, m, 
                                      color, v + 1)) 
                    return true; 
  
                /* If assigning color c doesn't lead 
                   to a solution then remove it */
                color[v] = 0; 
            } 
        } 
  
        /* If no color can be assigned to this vertex 
           then return false */
        return false; 
    } 
  
    /* This function solves the m Coloring problem using 
       Backtracking. It mainly uses graphColoringUtil() 
       to solve the problem. It returns false if the m 
       colors cannot be assigned, otherwise return true 
       and  prints assignments of colors to all vertices. 
       Please note that there  may be more than one 
       solutions, this function prints one of the 
       feasible solutions.*/
    boolean graphColoring(int graph[][], int m) 
    { 
        // Initialize all color values as 0. This 
        // initialization is needed correct functioning 
        // of isSafe() 
        color = new int[V]; 
        for (int i = 0; i < V; i++) 
            color[i] = 0; 
  
        // Call graphColoringUtil() for vertex 0 
        if (!graphColoringUtil(graph, m, color, 0)) 
        { 
            System.out.println("Solution does not exist"); 
            return false; 
        } 
  
        // Print the solution 
        printSolution(color); 
        return true; 
    } 
  
    /* A utility function to print solution */
    void printSolution(int color[]) 
    { 
        System.out.println("Solution Exists: Following" + 
                           " are the assigned colors"); 
        for (int i = 0; i < V; i++) 
            System.out.print(" " + color[i] + " "); 
        System.out.println(); 
    } 
  
    // driver program to test above function 
    /*
    public static void main(String args[]) 
    { 
        mColoringProblem Coloring = new mColoringProblem(); 
        /* Create following graph and test whether it is 
           3 colorable 
          (3)---(2) 
           |   / | 
           |  /  | 
           | /   | 
          (0)---(1) 
        */
    /*
        int graph[][] = {{0, 1, 1, 1}, 
            {1, 0, 1, 0}, 
            {1, 1, 0, 1}, 
            {1, 0, 1, 0}, 
        }; 
        int m = 3; // Number of colors 
        Coloring.graphColoring(graph, m); 
    } 
*/
} 