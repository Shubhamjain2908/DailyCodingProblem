/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

/**
 *
 * @author SHUBHAM
 */
public class LinkedLists1 {
    
    public static void main(String[] args) {
        
        Employee george = new Employee("RR", "Martin", 1); 
        Employee dany = new Employee("Emilia", "Clark", 2);
        Employee jon = new Employee("Kit", "Harington", 3);
        Employee tyrion = new Employee("Peter", "Dinklage", 4);
        
        EmployeeLinkedList list = new EmployeeLinkedList();
        
        System.out.println(list.isEmpty());
        
        list.addToFront(george);
        list.addToFront(dany);
        list.addToFront(jon);
        list.addToFront(tyrion);
        
        list.removeFromFront();
        
        System.out.println(list.getSize());
        
        list.printList();
    }
    
}
