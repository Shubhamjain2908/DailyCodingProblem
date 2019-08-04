/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Stripe
 *
 * @author SHUBHAM 
 reduce (also known as fold) is a function that takes in an array, a combining function, and an initial value and builds up a result by calling the combining function on each element of the array, left to right. For example, we can write sum() in terms of reduce:
def add(a, b):
    return a + b

def sum(lst):
    return reduce(lst, add, 0)
This should call add on the initial value with the first element of the array, and then the result of that with the second element of the array, and so on until we reach the end, when we return the sum of the array.
Implement your own version of reduce.
 */
public class P342_ReduceCustom {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7));
        System.out.println("Sum => " + sum(list));
    }

    private static Integer add(int a, int b) {
        return a + b;
    }

    private static Integer sum(List<Integer> list) {
        return reduce(list, 0);
    }

    private static Integer reduce(List<Integer> list, int temp) {
        int sum = add(temp, list.get(0));
        for (int i = 1; i < list.size(); i++) {
            sum = add(sum, list.get(i));
        }
        return sum;
    }

}