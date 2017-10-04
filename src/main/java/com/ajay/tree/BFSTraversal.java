package com.ajay.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ajayk297 on 04/10/17.
 */


class BFSBinaryTree extends AbstractTree{

    BFSBinaryTree(){
        root = null ;
    }

    //using queue for printing the levelorder traversal
    public void printLevelOrderForBFS(Node root) {
        Queue<Node> queue = new LinkedList();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp_node = queue.poll();
            System.out.println(temp_node.data );

            if (temp_node.left != null) {
                queue.add(temp_node.left);
            }
            if (temp_node.right != null) {
                queue.add(temp_node.right);
            }
        }

    }
}

public class BFSTraversal {

    public static void main(String[] args) {
        BFSBinaryTree binaryTree = new BFSBinaryTree();
        binaryTree.root = new Node(1);
        binaryTree.root.left = new Node(2);
        binaryTree.root.right = new Node(3);
        binaryTree.root.left.left = new Node(4);
        binaryTree.root.right.right = new Node(5);

        System.out.println("Level order traversal for BFS binary tree-");
        binaryTree.printLevelOrderForBFS(binaryTree.root);
    }

}
