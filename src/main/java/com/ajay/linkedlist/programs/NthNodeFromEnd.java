package com.ajay.linkedlist.programs;

/**
 * Created by ajayk297 on 26/09/17.
 */
public class NthNodeFromEnd {
    static class LinkedList{
        private Node head;

        class Node{
            private int data;
            private Node next;

            Node(int data){
                this.data = data;
                next = null;
            }
        }

        public void push(int data){
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;

        }
        public void printList(Node head){
            Node currentNode = head;
            while (currentNode != null){
                System.out.println("Data-"+ currentNode.data);
                currentNode = currentNode.next;
            }

        }

        public void findNthNodeFromEnd(int index){
            if(head == null){
                return;
            }
            Node headPointer = head, referencePointer = head;
            int count = 1;
            while (count <= index){
                if (referencePointer.next == null){
                    System.out.println("Linked list length is smaller then given indexs");
                    return ;
                }
                referencePointer = referencePointer.next;
                count++;
            }

            while (referencePointer != null) {
                headPointer = headPointer.next;
                referencePointer = referencePointer.next;
            }
            System.out.println("Nth node from end is-"+ headPointer.data);
        }
    }

    public static void main(String[] args) {
        LinkedList myList = new LinkedList();
        myList.push(6);
        myList.push(5);
        myList.push(4);
        myList.push(3);
        myList.push(2);
        myList.push(1);
        myList.printList(myList.head);
        myList.findNthNodeFromEnd(4);

    }
}
