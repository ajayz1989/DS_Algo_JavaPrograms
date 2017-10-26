package com.ajay.linkedlist.programs;

import java.util.HashMap;

/**
 * Created by ajayk297 on 24/10/17.
 */
public class LRUCacheUsingDLL {
    static class Node{
         int key;
         int value;
         Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            prev = next = null;
        }
    }
    static class LRUCache{
        private int capacity;
        HashMap<Integer, Node> map = new HashMap();
        Node head = null;
        Node tail = null;

        LRUCache(int capacity){
            this.capacity = capacity;
        }
        public int get(int key){
            if (map.containsKey(key)){
                Node node = map.get(key);
                remove(node);
                setHead(node);
                return node.value;
            }
            return -1;
        }
        public void putInCache(int key, int value){
            if (map.containsKey(key)){
                Node old = map.get(key);
                old.value = value;
                remove(old);
                setHead(old);
            }else{
                Node newNode = new Node(key, value);
                if (map.size()>=capacity){
                    map.remove(tail.key);
                    remove(tail);
                    setHead(newNode);
                }else{
                    setHead(newNode);
                }
                map.put(key,newNode);
            }
        }

        private void remove(Node node) {
            if (node.prev != null){
                node.prev.next = node.next;
            }else{
                head = node.next;
            }

            if (node.next != null){
                node.next.prev = node.prev;
            }else{
                tail = node.prev;
            }

        }

        private void setHead(Node newNode) {
            newNode.next = head;
            if(head != null){
                head.prev = newNode;
            }

            if (tail == null){
                tail = head;
            }
            head = newNode;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(4);
        lruCache.putInCache(1,1);
        lruCache.putInCache(2,2);
        lruCache.putInCache(3,3);
        lruCache.putInCache(4,4);
        lruCache.get(1);
        lruCache.putInCache(5,5);

        System.out.println(lruCache);
    }
}
