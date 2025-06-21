package t150.linkedlist;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// TODO : not yet implemented correctly
public class LRUCacheApp {
    public static void main(String[] args) {

        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);

        System.out.println(cache.get(1)); // 1

        cache.put(3, 3); // Removes key 2

        System.out.println(cache.get(2)); // -1 (not found)

        cache.put(4, 4); // Removes key 1

        System.out.println(cache.get(1)); // -1 (not found)

        System.out.println(cache.get(3)); // 3

        System.out.println(cache.get(4)); // 4
    }

}

class LRUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    private Node head;
    private Node tail;
    private Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            moveToHead(node);
            return node.value;
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            moveToHead(node);
        }else{
            if(map.size() >= capacity){
                removeLastNode();
            }
            Node node = new Node(key, value);
            if(head == null){
                head = tail = node;
                map.put(key, node);
            }else{
                node.next = head;
                head.prev = node;
                head = node;
                map.put(key, node);
            }
        }
    }

    private void removeLastNode() {
        if(map.size() == 0){
            return;
        }
        if(map.size() == 1){
            head = tail = null;
            map.remove(head.key);
        }else{
            map.remove(tail.value);
            Node preLast = tail.prev;
            preLast.next = null;
            tail.prev = null;
        }
    }


//    0->1->2

    private void moveToHead(Node node) {

        Node pre = node.prev;
        Node next = node.next;

        //It is already head
        if(pre == null){
            return;
        }

        pre.next = next;
        //If it is not last node
        if(next != null){
            next.prev = pre;
        }

        node.next = head;
        head.prev = head;
        head = node;
    }

}
