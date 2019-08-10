/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP_2;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Zillow
 * @author SHUBHAM
 * A ternary search tree is a trie-like data structure where each node may have up to three children. 
 * Here is an example which represents the words code, cob, be, ax, war, and we.
        c
     /  |  \
    b   o   w
  / |   |   |
 a  e   d   a
 |    / |   | \ 
 x   b  e   r  e  
The tree is structured according to the following rules:
• left child nodes link to words lexicographically earlier than the parent prefix
• right child nodes link to words lexicographically later than the parent prefix
• middle child nodes continue the current word
For instance, since code is the first word inserted in the tree, and cob lexicographically precedes cod, cob is represented as a left child extending from cod.
Implement insertion and search functions for a ternary search tree.
 */
public class P348_TernarySearchTree {

    public static void main(String[] args) {
//        Trie t = new Trie();
//        t.insert("shubham");
//        t.insert("jain");
//        t.insert("sugar");
//        t.insert("laptop");
//        t.display();
        TernaryTrie tt = new TernaryTrie();
        tt.insert("shubham");
        tt.insert("jain");
        tt.insert("sugar");
        tt.insert("laptop");
        System.out.println(tt.search("jain"));
        System.out.println(tt);
        
    }

}

class TernaryTrie {

    private Node root;
    private ArrayList<String> al;
    
    public TernaryTrie() {
        root = null;
    }
    
    private static class Node {

        char data;
        boolean isEndOfWord;
        Node left, right, middle;

        public Node(char data) {
            this.data = data;
            this.isEndOfWord = false;
            this.left = this.middle = this.right = null;
        }
    }

    /**
     * function to check if empty *
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * function to clear *
     */
    public void makeEmpty() {
        root = null;
    }

    /**
     * function to insert for a word *
     */
    public void insert(String word) {
        root = insert(root, word.toCharArray(), 0);
    }

    /**
     * function to insert for a word *
     */
    private Node insert(Node r, char[] word, int ptr) {
        if (r == null) {
            r = new Node(word[ptr]);
        }

        if (word[ptr] < r.data) {
            r.left = insert(r.left, word, ptr);
        } else if (word[ptr] > r.data) {
            r.right = insert(r.right, word, ptr);
        } else {
            if (ptr + 1 < word.length) {
                r.middle = insert(r.middle, word, ptr + 1);
            } else {
                r.isEndOfWord = true;
            }
        }
        return r;
    }

    /**
     * function to delete a word *
     */
    public void delete(String word) {
        delete(root, word.toCharArray(), 0);
    }

    /**
     * function to delete a word *
     */
    private void delete(Node r, char[] word, int ptr) {
        if (r == null) {
            return;
        }

        if (word[ptr] < r.data) {
            delete(r.left, word, ptr);
        } else if (word[ptr] > r.data) {
            delete(r.right, word, ptr);
        } else {
            /**
             * to delete a word just make isEnd false *
             */
            if (r.isEndOfWord && ptr == word.length - 1) {
                r.isEndOfWord = false;
            } else if (ptr + 1 < word.length) {
                delete(r.middle, word, ptr + 1);
            }
        }
    }

    /**
     * function to search for a word *
     */
    public boolean search(String word) {
        return search(root, word.toCharArray(), 0);
    }

    /**
     * function to search for a word *
     */
    private boolean search(Node r, char[] word, int ptr) {
        if (r == null) {
            return false;
        }

        if (word[ptr] < r.data) {
            return search(r.left, word, ptr);
        } else if (word[ptr] > r.data) {
            return search(r.right, word, ptr);
        } else {
            if (r.isEndOfWord && ptr == word.length - 1) {
                return true;
            } else if (ptr == word.length - 1) {
                return false;
            } else {
                return search(r.middle, word, ptr + 1);
            }
        }
    }

    /**
     * function to print tree *
     */
    @Override
    public String toString() {
        al = new ArrayList<>();
        traverse(root, "");
        return "\nTernary Search Tree : " + al;
    }

    /**
     * function to traverse tree *
     */
    private void traverse(Node r, String str) {
        if (r != null) {
            traverse(r.left, str);

            str = str + r.data;
            if (r.isEndOfWord) {
                al.add(str);
            }

            traverse(r.middle, str);
            str = str.substring(0, str.length() - 1);

            traverse(r.right, str);
        }
    }
}

class Trie {

    private static final Node root = new Node();

    private static final int ALPHABET_SIZE = 26;

    static class Node {

        Node[] children = new Node[ALPHABET_SIZE];
        boolean isEndOfWord;

        Node() {
            for (int i = 0; i < ALPHABET_SIZE; i++) {
                children[i] = null;
            }
            isEndOfWord = false;
        }

        @Override
        public String toString() {
            return "Node{isEndOfWord=" + isEndOfWord + '}';
        }

    }

    public void insert(String key) {
        Node pCrawl = root;
        key = key.toLowerCase();
        int index;
        for (int level = 0; level < key.length(); level++) {
            index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null) {
                pCrawl.children[index] = new Node();
            }
            pCrawl = pCrawl.children[index];
        }
        pCrawl.isEndOfWord = true;
        System.out.println(key + " :Inserted successfully");
    }

    public boolean search(String key) {
        Node pCrawl = root;
        key = key.toLowerCase();
        int index;
        for (int level = 0; level < key.length(); level++) {
            index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null) {
                return false;
            }
            pCrawl = pCrawl.children[index];
        }
        return pCrawl != null && pCrawl.isEndOfWord;
    }

    public void display() {
        Node pCrawl = root;
        this.display(pCrawl, new char[100], 0);
    }

    // function to display the content of Trie 
    private void display(Node pCrawl, char str[], int level) {
        // If node is leaf node, it indiicates end 
        // of string, so a null charcter is added 
        // and string is displayed
        System.out.println("pC: " + pCrawl);
        if (pCrawl != null && pCrawl.isEndOfWord == true) {
            str[level] = '\0';
            System.out.println(str);
        }

        for (int i = 0; i < ALPHABET_SIZE; i++) {
            // if NON NULL child is found 
            // add parent key to str and 
            // call the display function recursively 
            // for child node 
            if (pCrawl.children[i] != null) {
                str[level] = (char) (i + 'a');
                pCrawl = pCrawl.children[i];
                display(pCrawl, str, level + 1);
            }
        }
    }

    // Returns true if root has no children, else false 
    private boolean isEmpty(Node root) {
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if (root.children[i] != null) {
                return false;
            }
        }
        return true;
    }

    // Recursive function to delete a key from given Trie 
    public Node remove(Node root, String key, int depth) {
        // If tree is empty 
        if (root == null) {
            return null;
        }

        // If last character of key is being processed 
        if (depth == key.length()) {

            // This node is no more end of word after 
            // removal of given key 
            if (root.isEndOfWord) {
                root.isEndOfWord = false;
            }

            // If given is not prefix of any other word 
            if (isEmpty(root)) {
//                delete(root); 
                root = null;
            }

            return root;
        }

        // If not last character, recur for the child 
        // obtained using ASCII value 
        int index = key.charAt(depth) - 'a';
        root.children[index] = remove(root.children[index], key, depth + 1);

        // If root does not have any child (its only child got  
        // deleted), and it is not end of another word. 
        if (isEmpty(root) && root.isEndOfWord == false) {
//            delete (root); 
            root = null;
        }

        return root;
    }
}
