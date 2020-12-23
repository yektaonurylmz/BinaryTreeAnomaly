package com.company;

class Node {

     private int data;
      Node leftChild;
      Node rightChild;
      Node mid;

    public Node(int data) {
        this.data = data;


    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public Node getMid(){
        return mid;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }


}
