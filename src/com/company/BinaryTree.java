package com.company;

import java.util.ArrayList;

public class BinaryTree {

    private Node root;
    private static ArrayList<Node> visitedNodes = new ArrayList<>();


    BinaryTree(){
        root = null;
    }
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.root=new Node();
        tree.root.leftChild= new Node();
        tree.root.rightChild= new Node();
        tree.root.rightChild.rightChild=new Node();
        tree.root.leftChild.leftChild=new Node();
        tree.root.leftChild.rightChild=new Node();
        tree.root.leftChild.rightChild.rightChild=new Node();
        tree.root.leftChild.rightChild.leftChild=new Node();
        tree.root.leftChild.leftChild.leftChild=new Node();
        tree.root.leftChild.leftChild.rightChild=new Node();
        tree.root.leftChild.leftChild.rightChild.leftChild=new Node();
        tree.root.leftChild.leftChild.rightChild.rightChild=new Node();
        tree.root.leftChild.leftChild.leftChild.leftChild=new Node();
        tree.root.leftChild.leftChild.leftChild.rightChild=new Node();

        // Binary tree yapısına uymayan -Anomaliye sahip- bir ağaç oluşturuldu.
        tree.root.rightChild.leftChild =  tree.root.leftChild.leftChild;

       // tree.InOrderTraversal(tree.root);
        boolean isAnomaly = tree.CheckAnomaly(tree.root);
        System.out.println("Anomaly Status: " + isAnomaly);

    }
    public boolean CheckAnomaly(Node node) {

        if (node != null) {

            return ContainNode(node) || CheckAnomaly(node.getLeftChild()) || CheckAnomaly(node.getRightChild())  ;

        }
        return false;
    }
    private boolean ContainNode(Node node){
        if(visitedNodes.contains(node))
            return true;
        else {
            visitedNodes.add(node);
            return false;
        }
    }

    public void InOrderTraversal(Node node) {
        if (node != null) {
            InOrderTraversal(node.getLeftChild());
            System.out.println(node.toString());
            InOrderTraversal(node.getRightChild());
        }
    }

}
