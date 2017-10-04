package com.ajay.tree;

/**
 * DFS various traversal strategies.
 */
class DFSBinaryTree extends AbstractTree {

    DFSBinaryTree(){
        root = null;
    }

    public void printInorderTraversal(Node root) {

        if (root == null) return;
        printInorderTraversal(root.left);
        System.out.println(root.data + " ");
        printInorderTraversal(root.right);

    }

    public void printPreorderTraversal(Node root){

        if (root == null) return;
        System.out.println(root.data + " ");
        printPreorderTraversal(root.left);
        printPreorderTraversal(root.right);
    }

    public void printPostorderTraversal(Node root){

        if (root == null) return;
        printPostorderTraversal(root.left);
        printPostorderTraversal(root.right);
        System.out.println(root.data + " ");
    }
}

public class DFSTraversals {

    public static void main(String[] args) {
        DFSBinaryTree tree = new DFSBinaryTree();

        tree.root = new Node(1);

        tree.root.left = new Node(2);

        tree.root.right = new Node(3);

        tree.root.left.left = new Node(4);

        tree.root.left.right = new Node(5);

        System.out.println("Inorder traversal of binary tree is ");
        tree.printInorderTraversal(tree.root);

        System.out.println("Preorder traversal of binary tree is ");
        tree.printPreorderTraversal(tree.root);

        System.out.println("Postorder traversal of binary tree is ");
        tree.printPostorderTraversal(tree.root);

    }


}
