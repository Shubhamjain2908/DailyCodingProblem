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
 * Uber
 * @author SHUBHAM
 * A rule looks like this:
    A NE B
    This means this means point A is located northeast of point B.
    A SW C
    means that point A is southwest of C.
    Given a list of rules, check if the sum of the rules validate. For example:
    A N B
    B NE C
    C N A

    does not validate, since A cannot be both north and south of C.
    A NW B
    A N B

    is considered valid.
 */
public class P87_ValidPosition 
{
    private final Map<String, int[]> map;
    
    public P87_ValidPosition()
    {
        map = new HashMap<>();
        int[] N = {0,1};
        int[] NE = {1,1};
        int[] NW = {-1,1};
        int[] S = {0,-1};
        int[] SE = {1,-1};
        int[] SW = {-1,-1};
        int[] E = {1,0};
        int[] W = {-1,0};
        map.put("N", N);
        map.put("NE", NE);
        map.put("NW", NW);
        map.put("S", S);
        map.put("S", SE);
        map.put("SW", SW);
        map.put("E", E);
        map.put("W", W);
    }
    
    public static void main(String[] args) 
    {
        String r1 = "A N B";
        String r2 = "B NE C";
        String r3 = "C N A";
        List<String> rules = new ArrayList<>();
        rules.add(r1);
        rules.add(r2);
        rules.add(r3);
        String r4 = "A N B";
        String r5 = "A NE B";
        List<String> rules2 = new ArrayList<>();
        rules2.add(r4);
        rules2.add(r5);
        P87_ValidPosition p = new P87_ValidPosition();
        System.out.println(p.isValid(rules));
        System.out.println(p.isValid(rules2));
    }
    private boolean isValid(List<String> rules)
    {
        Map<String, int[]> position = new HashMap<>();
        rules.forEach(t-> {
            String[] s = t.split(" ");
            String x = s[0];
            String y = s[2];
            String p = s[1];
            int[] c = map.get(p);
            if (position.containsKey(y)) 
            {
                
            }
            else 
            {
                int[] yy = {0,0};
                position.put(y, yy);
            }
        });
        return false;
    }
}
