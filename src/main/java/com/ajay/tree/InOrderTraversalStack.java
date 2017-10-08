package com.ajay.tree;

import java.util.Stack;

/**
 * Created by ajayk297 on 05/10/17.
 */
class BinaryTree extends AbstractTree{

    BinaryTree(){
        root = null;
    }

    public void inOrderTraversalUsingStack(Node root){
        if (root == null){
            return ;
        }
        Stack<Node> stack = new Stack();
        Node node = root;

        //until node is null traverse to the left of the tree till the end
        while (node != null){
            stack.push(node);
            node = node.left;
        }

        while (!stack.isEmpty()){
            node = stack.pop();
            System.out.println(node.data + " ");
            if (node.right != null){
                node = node.right;

                //visit the left most node of this node
                while(node != null){
                    stack.push(node);
                    node = node.left;
                }
            }
        }
    }
}

//Time complexity here is O(n)
public class InOrderTraversalStack {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left =  new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.right.left = new Node(6);
        tree.root.left.right.right = new Node(7);

        tree.inOrderTraversalUsingStack(tree.root);
    }
}
