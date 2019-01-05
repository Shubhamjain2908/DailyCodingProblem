/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack.link;
import java.util.Stack;
/**
 *
 * @author SHUBHAM
 */
public class StackChallengePallin {
    public static void main(String[] args) {
        System.out.println(checkPallindrome("who's your daddy?"));
        System.out.println(checkPallindrome("abbba"));
    }
    public static boolean checkPallindrome(String str){
        String s = str.replaceAll("[^A-Za-z]+", "").toLowerCase();
        Stack<String> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            st.push(String.valueOf(s.charAt(i)));
        }
        StringBuilder sb = new StringBuilder(s.length());
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.toString().equals(s);
    }
}
