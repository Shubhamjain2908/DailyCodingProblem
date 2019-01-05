/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP_2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Microsoft
 * @author SHUBHAM
 * Implement the singleton pattern with a twist. First, instead of storing one instance, store two instances. And in every even call of getInstance(), return the first instance and in every odd call of getInstance(), return the second instance.
 */
public class P120_SingletonPattern 
{
    public static void main(String[] args) throws IllegalArgumentException, InvocationTargetException {
        //Create the 1st instance
        SingletonClass instance1 = SingletonClass.getInstance();
        
        //Create 2nd instance using Java Reflection API.
        SingletonClass instance2 = null;
        try {
            Class<SingletonClass> clazz = SingletonClass.class;
            Constructor<SingletonClass> cons = clazz.getDeclaredConstructor();
            cons.setAccessible(true);
            instance2 = cons.newInstance();
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

        //now lets check the hash key.
        System.out.println("Instance 1 hash:" + instance1.hashCode());
        System.out.println("Instance 2 hash:" + instance2.hashCode());
   }

}
class SingletonClass {
    
    private static SingletonClass sSoleInstance;

    private SingletonClass(){}  

    public static SingletonClass getInstance()
    {
        if (sSoleInstance == null) //if there is no instance available... create new one
        { 
            sSoleInstance = new SingletonClass();
        }
        return sSoleInstance;
    }
}