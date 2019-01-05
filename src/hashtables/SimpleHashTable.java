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
public class SimpleHashTable {
    
    private Employee[] hashtable;
    
    public SimpleHashTable(){
        hashtable = new Employee[10];
    }
    
    public void put(String key, Employee employee){
        int hashedKey = hashKey(key);
        if(occupied(hashedKey)){
            
        }
        
        if(occupied(hashedKey)){
            System.out.println("Sorry, there's already an employee at position " + hashedKey);
        } else {
            hashtable[hashedKey] = employee;
        }
    }
    
    public Employee get(String key){
        int hashedKey = hashKey(key);
        return hashtable[hashedKey];
    } 
    
    private int hashKey(String key){
        return key.length() % hashtable.length;
    }
    
    private boolean occupied(int index){
        return hashtable[index] != null;
    }
    
    public void printHashTable(){
        for (Employee hashtable1 : hashtable) {
            System.out.println(hashtable1);
        }
    }
}
