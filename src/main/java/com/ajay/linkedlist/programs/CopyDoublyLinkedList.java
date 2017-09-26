package com.ajay.linkedlist.programs;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ajayk297 on 24/09/17.
 */
public class CopyDoublyLinkedList {

     Node head;

    public CopyDoublyLinkedList(Node head) {
        this.head = head;
    }

    static class Node {

         int data;
         Node next;
         Node randomPointer;

        public Node(int data) {
            this.data = data;
            next = randomPointer = null;
        }
    }

    public void pushAtHead(int data){
        Node newNode = new Node(data);
        newNode.next = head ;
        head = newNode;
    }

    public void printList(){
        Node currentNode = head;
        while (currentNode != null){
            Node randomPointer = currentNode.randomPointer;
            int randomData = randomPointer!=null ? randomPointer.data : -1;
            System.out.println("Data-" + currentNode.data + "RandomData-"+ randomData);
            currentNode =currentNode.next;
        }
    }

    public CopyDoublyLinkedList copy(){

        Node originalCurrentNode = head;
        Node copyCurrentNode = null;
        Map<Node, Node> table = new HashMap<Node, Node>();

        while (originalCurrentNode != null)
        {
            copyCurrentNode = new Node(originalCurrentNode.data);
            table.put(originalCurrentNode, copyCurrentNode);
            originalCurrentNode = originalCurrentNode.next;
        }
        //adjust original current node again to head
        originalCurrentNode = head;

        while (originalCurrentNode != null)
        {
            copyCurrentNode = table.get(originalCurrentNode);
            copyCurrentNode.next = table.get(originalCurrentNode.next);
            copyCurrentNode.randomPointer = table.get(originalCurrentNode.randomPointer);
            originalCurrentNode = originalCurrentNode.next;

        }
        return new CopyDoublyLinkedList(table.get(head));
    }

    public void call(){
        CopyDoublyLinkedList originalList = new CopyDoublyLinkedList(new Node(3));
    }
    public static void main(String[] args) {

        CopyDoublyLinkedList list = new CopyDoublyLinkedList(new Node(4));
        list.pushAtHead(3);
        list.pushAtHead(1);
        list.pushAtHead(9);
        list.head.randomPointer = list.head.next.next.next;
        list.head.next.randomPointer = list.head.next.next;
        list.head.next.next.randomPointer = list.head;
        list.head.next.next.next.randomPointer = list.head.next;
        list.printList();

        list.copy();
        System.out.println("after copy");
        list.printList();
    }
}
