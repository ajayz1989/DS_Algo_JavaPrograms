package com.ajay.linkedlist.programs;

/**
 * Created by ajayk297 on 26/09/17.
 */
public class SwapTwoNodes {

   static class Node{
        private int data;
        private Node next;

        Node(int data){
            this.data = data;
            next = null;
        }
    }

    static class LinkedList {
        private Node head;


        private void push(int data){
            Node newNode =  new Node(data);
            newNode.next = head;
            head = newNode;
        }

        private void printList(Node head){
            Node currentNode = head;
            while (currentNode != null){
                System.out.println("Data-"+ currentNode.data);
                currentNode = currentNode.next;
            }
        }

        private void swapNodes(int value1, int value2){
            if (value1 == value2) return;

            Node prevNodeX = null, currentNodeX = head;
            //iterate and set the pointers to the prev and current node of first value
            while (currentNodeX != null && currentNodeX.data != value1){
                prevNodeX = currentNodeX;
                currentNodeX = currentNodeX.next;
            }

            Node prevNodeY = null, currentNodeY = head;
            //iterate and set the pointers to the prev and current node of second value
            while (currentNodeY != null && currentNodeY.data != value2){
                prevNodeY = currentNodeY;
                currentNodeY = currentNodeY.next;
            }

            //validate corner cases
            if (currentNodeX == null || currentNodeY == null){
                return;
            }

            //swap next pointers of prevNodeX
            if(prevNodeX != null){
                prevNodeX.next = currentNodeY;
            }else{//if X is head node then swap and make Y as head node
                head = currentNodeY;
            }

            //swap next pointers of prevNodeY
            if(prevNodeY != null){
                prevNodeY.next = currentNodeX;
            }else{//if Y is head node then swap and make X as head node
                head = currentNodeX;
            }

            //swap next pointers of currentNodeX & currentNodeY
            Node temp = currentNodeX.next;
            currentNodeX.next = currentNodeY.next;
            currentNodeY.next = temp;
        }
    }

    public static void main(String[] args) {
        LinkedList myList = new LinkedList();
        myList.push(10);
        myList.push(15);
        myList.push(12);
        myList.push(13);
        myList.push(20);
        myList.push(14);
        myList.printList(myList.head);

        int value1 = 14;
        int value2 = 115;
        myList.swapNodes(value1, value2);
        System.out.println("Linked list after swapping given nodes Value1-"+value1 +" Value2-"+value2);
        myList.printList(myList.head);

    }
}
