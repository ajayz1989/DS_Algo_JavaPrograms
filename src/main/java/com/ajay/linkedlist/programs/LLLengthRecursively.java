package com.ajay.linkedlist.programs;

/**
 * Created by ajayk297 on 25/09/17.
 */
public class LLLengthRecursively {

   static class Node {
        private int data;
        private Node next;

        private Node(int data) {
            this.data = data;
            next = null;
        }
    }

    static class LinkedList{
        private Node head;

        public void push(int data){
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }

        public int getListSize(Node head){
            if (head == null){
                return 0;
            }
            return 1 + getListSize(head.next);
        }

        public void printList(Node head){
            Node currentNode = head;
            while (currentNode != null){
                System.out.println("Data-"+ currentNode.data);
                currentNode = currentNode.next;
            }

        }

    }
        public static void main(String[] args) {

            LinkedList myList = new LinkedList();
            myList.push(3);
            myList.push(4);
            myList.push(7);
            myList.push(3);
            myList.push(6);

            myList.printList(myList.head);
            System.out.println("........Size-"+myList.getListSize(myList.head));
        }
}
