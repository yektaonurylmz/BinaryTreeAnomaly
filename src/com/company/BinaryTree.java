package com.company;

public class BinaryTree {

    private Node rootNode;


    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.addNode(50);
        tree.addNode(25);
        tree.addNode(10);
        tree.addNode(75);
        tree.addNode(15);
        tree.addNode(60);
        tree.addNode(80);
        tree.addNode(100);
        tree.addNode(10);
        tree.PrintInOrder(tree.rootNode);
        boolean result = tree.checkBinaryTree(tree.rootNode);
        System.out.println("Result: " + result);

    }

    /**
     * Node ekleme fonksiyonu ancak soru icin  agac bozuk sekilde olusturuldu.
     *
     * @param data eklenecek node
     */
    public void addNode(int data) {
        Node newNode = new Node(data);
        int value;
        if (rootNode == null) {
            rootNode = newNode;
        } else {
            Node focusNode = rootNode;
            Node parent;
            while (true) {
                parent = focusNode;
              //  value=parent.getData();


                if (data < focusNode.getData()) {
                    focusNode = focusNode.getLeftChild();
                    if (focusNode == null) {
                        parent.setLeftChild(newNode);
                        return;
                    }
                } else {
                    focusNode = focusNode.getRightChild();
                    if (focusNode == null) {
                        parent.setRightChild(newNode);
                        return;
                    }
                }
            }
        }
    }

    public void PrintInOrder(Node node) {
        if (node != null) {
            PrintInOrder(node.getLeftChild());
            System.out.println(node.toString());
            PrintInOrder(node.getRightChild());
        }
    }


    boolean checkBinaryTree(Node root) {
        return this.checkBinaryTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean checkBinaryTree(Node node, int min, int max) {
        if (node == null) return true;
        return min < node.getData() && node.getData() < max &&
                this.checkBinaryTree(node.getLeftChild(), min, node.getData()) &&
                this.checkBinaryTree(node.getRightChild(), node.getData(), max);
    }

}
