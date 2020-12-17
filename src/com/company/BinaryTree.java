package com.company;

import java.util.ArrayList;

public class BinaryTree {

    private Node root;
    private static ArrayList<Integer> visitedNodes = new ArrayList<>();

    BinaryTree(int data){
        root=new Node(data);
    }
    BinaryTree(){
        root = null;
    }
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.root=new Node(50);
        tree.root.leftChild= new Node(25);
        tree.root.rightChild= new Node(75);
        tree.root.rightChild.rightChild=new Node(80);
        tree.root.leftChild.leftChild=new Node(15);
        tree.root.leftChild.rightChild=new Node(30);
        tree.root.leftChild.rightChild.rightChild=new Node(32);
        tree.root.leftChild.rightChild.leftChild=new Node(26);
        tree.root.leftChild.leftChild.leftChild=new Node(13);
        tree.root.leftChild.leftChild.rightChild=new Node(23);
        tree.root.leftChild.leftChild.rightChild.leftChild=new Node(22);
        tree.root.leftChild.leftChild.rightChild.rightChild=new Node(24);
        tree.root.leftChild.leftChild.leftChild.leftChild=new Node(12);
        tree.root.leftChild.leftChild.leftChild.rightChild=new Node(14);

        // Binary tree yapısına uymayan -Anomaliye sahip- bir ağaç oluşturuldu.
        tree.root.rightChild.leftChild =  tree.root.leftChild.leftChild;
        tree.PrintInOrder(tree.root);
        boolean isAnomaly = tree.IsAnomaly(tree.root);
        System.out.println("Anomaly Status: " + isAnomaly);

         /*

                           50

                      /           \
                     /             \
                    /               \
                   /                 \
                  25                 75
               /      \             /   \
              15       30         15      80
             /  \      /  \      / \
          13    23    26  32     . .
        /   \   /  \             . .
      12    14  22  24

  */



    }
    //
    public boolean IsAnomaly(Node node) {

        if (node != null) {

            return IsExist(node) || IsAnomaly(node.getLeftChild()) || IsAnomaly(node.getRightChild());

        }
        return false;
    }

    private boolean IsExist(Node node){
        if(visitedNodes.contains(node.getData()))
            return true;
        else {
            visitedNodes.add(node.getData());
            return false;
        }
    }

    public void PrintInOrder(Node node) {

        if (node != null) {
            PrintInOrder(node.getLeftChild());
            System.out.println(node.toString());
            PrintInOrder(node.getRightChild());
        }
    }

}
