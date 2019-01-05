/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 *  Google
 * @author SHUBHAM
 *  Implement an LRU (Least Recently Used) cache. It should be able to be initialized with a cache size n, and contain the following methods:
    set(key, value): sets key to value. If there are already n items in the cache and we are adding a new item, then it should also remove the least recently used item.
    get(key): gets the value at key. If no such key exists, return null.
    Each operation should run in O(1) time.
 */
public class P67_LeastRecentlyUsedCache 
{
    public static void main(String[] args) 
    {
        int[] arr = {1,0,3,2,7,5,9,2,3,6};
        int size = 3;
        LRU_67 cache = new LRU_67(size);
        for (int i = 0; i < arr.length; i++) 
        {
            cache.set(i, arr[i]);
        }
        int[] c = cache.getCache();
        for(int ch: c) System.out.println(ch);
    }
}
class LRU_67
{
    private final int size;
    private final Map<Integer, Integer> map = new HashMap<>();
    private final Queue<Integer> q = new LinkedList<>();
    
    public LRU_67(int size)
    {
        this.size = size;
    }
    
    public void set(int key, int value)
    {
        if (q.size() == size) {
            map.remove(q.poll());
        }
        map.put(key, value);
        q.add(key);
    }
    
    public int get(int key)
    {
        if (map.containsKey(key)) {
            return map.get(key);
        }
        return 0;
    }
    
    public int[] getCache()
    {
        int[] arr = new int[size];
        int[] i = {0};
        map.entrySet().forEach(e -> {
            arr[i[0]] = e.getValue();
            i[0]++;
        });
        return arr;
    }
}
