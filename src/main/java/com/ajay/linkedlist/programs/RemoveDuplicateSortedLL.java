package com.ajay.linkedlist.programs;

/**
 * Created by ajayk297 on 27/09/17.
 */
class Node<T> {
    T data;
    Node next;

    Node(T data) {
        this.data = data;
        next = null;
    }

}

class LinkedList<T> {
    private Node head;

    public void push(T data) {
        Node currentNode = new Node(data);
        currentNode.next = head;
        head = currentNode;
    }

    public void removeDuplicatesFromSortedList() {
        //if list is empty
        if (head == null)return;

        Node currentNode = head;
        //next pointer which needs to be deleted
        Node nextPointer;

        while (currentNode.next != null) {
            if (currentNode.data == currentNode.next.data) {
                nextPointer = currentNode.next.next;
                currentNode.next = null;
                currentNode.next = nextPointer;
            } else {
                //increment if no deletion
                currentNode = currentNode.next;
            }
        }
    }

    public void printList() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.println("Data-" + currentNode.data);
            currentNode = currentNode.next;
        }

    }
}

public class RemoveDuplicateSortedLL {
    public static void main(String[] args) {

        LinkedList myList = new LinkedList();
        myList.push(60);
        myList.push(13);
        myList.push(13);
        myList.push(13);
        myList.push(11);
        myList.push(11);
        myList.printList();
        System.out.println("After removing duplicates");
        myList.removeDuplicatesFromSortedList();
        myList.printList();

    }

}
