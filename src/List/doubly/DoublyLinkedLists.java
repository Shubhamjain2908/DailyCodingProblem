/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List.doubly;

import List.*;

/**
 *
 * @author SHUBHAM
 */
public class DoublyLinkedLists 
{
    public static void main(String[] args) {
        
        Employee george = new Employee("RR", "Martin", 1); 
        Employee dany = new Employee("Emilia", "Clark", 2);
        Employee jon = new Employee("Kit", "Harington", 3);
        Employee tyrion = new Employee("Peter", "Dinklage", 4);
    
        EmployeeDoublyLinkedList list = new EmployeeDoublyLinkedList();
        
        list.addToFront(george);
        list.addToFront(dany);
        list.addToFront(jon);
        list.addToFront(tyrion);
        
        list.printList();
        System.out.println(list.getSize());
    
        Employee ned = new Employee("Sean","Bean",212);
        list.addToEnd(ned);
        list.printList();
        System.out.println(list.getSize());
        list.removeFromFront();
        list.printList();
        System.out.println(list.getSize());
        list.removeFromEnd();
        list.printList();
        System.out.println(list.getSize());
        
    }   
}
