/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List.doubly;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author SHUBHAM
 */
public class LinkedListJDK 
{
    public static void main(String[] args)
    {
        Employee george = new Employee("RR", "Martin", 1); 
        Employee dany = new Employee("Emilia", "Clark", 2);
        Employee jon = new Employee("Kit", "Harington", 3);
        Employee tyrion = new Employee("Peter", "Dinklage", 4);
        
        LinkedList<Employee> list = new LinkedList<>();
        list.addFirst(george);
        list.addFirst(dany);
        list.addFirst(jon);
        list.addFirst(tyrion);
        list.addLast(new Employee("Ned","Stark",21));
        list.addLast(new Employee("Rob","Stark",11));
        
        Iterator it = list.iterator();
        System.out.print("Head -> ");
        while(it.hasNext())
        {
            System.out.println(it.next());
            System.out.print(" <-> ");
        }
        System.out.print("null");
        
//        for(Employee employee: list)
//        {
//            System.out.println(employee);
//        }
    }
}
