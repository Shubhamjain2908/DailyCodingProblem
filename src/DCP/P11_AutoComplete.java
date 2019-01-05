/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author SHUBHAM
 */
public class P11_AutoComplete 
{
    public static void main(String[] args) 
    {
        String s = "d";
        List<String> l = find(s);
        l.forEach(t -> System.out.println(t));
    }
    private static List<String> find(String s) 
    {
        String[] dict = {"dog","deer","deal"};
        List<String> list = new ArrayList<>();
        for (String dict1 : dict) {
            if (dict1.startsWith(s)) {
                list.add(dict1);
            }
        }
        return list;
    }
}
