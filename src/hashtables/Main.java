/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtables;

/**
 *
 * @author SHUBHAM
 */
public class Main {
    public static void main(String[] args) {
        
        Employee george = new Employee("RR", "Martin", 1); 
        Employee dany = new Employee("Emilia", "Clark", 2);
        Employee jon = new Employee("Kit", "Harington", 3);
        Employee tyrion = new Employee("Peter", "Dinklage", 4);
        Employee arya = new Employee("Maisie","Williams",5);
        
        SimpleHashTable ht = new SimpleHashTable();
        ht.put("George", george);
        ht.put("Dany", dany);
        ht.put("Jon", jon);
        ht.put("Tyrion", tyrion);
        ht.put("Arya", arya);
        
        //ht.printHashTable();
        
        System.out.println("Retrieving Dany -> " + ht.get("Dany"));
    }
}
