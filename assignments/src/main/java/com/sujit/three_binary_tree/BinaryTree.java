package com.sujit.three_binary_tree;

public class BinaryTree {

    private Node node;

    public BinaryTree(int val) {
        node = new Node(val);

    }

    public void insert(int data){
       boolean isAccepted =  node.accept(data);
       if(!isAccepted) {
           System.out.println("Unable to insert :" +data +"May be already On the Tree");
       }
       else System.out.println("Inserted Successfully");
    }

    public void findDepth(int key){
        int depth = node.depth(key);
        if(depth == 0 ) {
            System.out.println("No such Value Present");
        }
        else
            System.out.println("The Depth of " + key + " is " + depth);
    }

    public void findTreeDepth() {
       int depth =  node.treeDepth();
       System.out.println("The Depth of Tree is " +depth);
    }

    public void printSortedBinaryTree(){
        System.out.println("The Ascending Order Sorted of Binary Tree is: ");
        inOrder(node);

    }

    public void inOrder(Node currentNode){
        if(currentNode == null)
            return;
        inOrder(currentNode.leftNode);
        System.out.println(currentNode.data);
        inOrder(currentNode.rightNode);

    }

}
