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
         tree.root.rightChild.mid =new Node(73);
         tree.root.rightChild.leftChild =  tree.root.leftChild.leftChild;
        tree.InOrderTraversal(tree.root);
        boolean isAnomaly = tree.CheckAnomaly(tree.root);
        System.out.println("Anomaly Status: " + isAnomaly);
       // System.out.println(visitedNodes);

         /*
                           50

                      /           \
                     /             \
                    /               \
                   /                 \
                  25                 75
               /      \             /  |  \
              15       30         15   73  80
             /  \      /  \      / \
          13    23    26  32     . .
        /   \   /  \             . .
      12    14  22  24

  */


    }


    boolean CheckMidNode(Node node){

        if(node.getMid()!=null){
            CheckMidNode(node.getMid());
            return true;

        }

       return false;
    }

    public boolean CheckAnomaly(Node node) {

        if (node != null) {

            return ContainNode(node) || CheckAnomaly(node.getLeftChild()) || CheckMidNode(node)|| CheckAnomaly(node.getRightChild())  ;

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
            InOrderTraversal(node.getMid());
            System.out.println(node.toString());
            InOrderTraversal(node.getRightChild());
        }
    }



}
