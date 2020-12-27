package com.sujit.three_binary_tree;

import com.sujit.three_binary_tree.lab2codereuse.LinkedQueue;
import com.sujit.three_binary_tree.lab2codereuse.Queue;

public class Node {
    int data;
    Node leftNode, rightNode;

    public Node(int data) {
        this.data = data;
        leftNode = rightNode = null;
    }

    public boolean accept(int value) {
        if (value == data)
            return false;
        if(value > data){
            if(rightNode == null){
                rightNode = new Node(value);
                return true;
            }
            else return rightNode.accept(value);

        }
        else {
            if (leftNode == null) {
                leftNode = new Node(value);
                return true;
            }
            else return leftNode.accept(value);
        }

    }
    public int depth(int key) {
        Node currentNode;
        Queue<Node> queue = new LinkedQueue<>();
        int level = 1;
        queue.enque(this);
        while ( !queue.isEmpty()) {

            currentNode = queue.deque();
            if(key == currentNode.data){
                return level;
            }
            if(key > currentNode.data){
                if(currentNode.rightNode == null)
                    return 0;
                else queue.enque(currentNode.rightNode);

            }
            else {
                if(currentNode.leftNode == null)
                    return 0;
                else queue.enque(currentNode.leftNode);
            }
            level++;
        }
        return level;

    }
    public int treeDepth(){
       int level = 0;
       int levelCounter = 1;
       Node currentNode = this;
       if(currentNode != null){
           Queue<Node> queue = new LinkedQueue<>();
           queue.enque(this);

           while ( !queue.isEmpty()){
               currentNode = queue.deque();
               levelCounter--;

               if(currentNode.leftNode !=null){
                   queue.enque(currentNode.leftNode);
               }

               if(currentNode.rightNode !=null){
                   queue.enque(currentNode.rightNode);
               }

               if (levelCounter == 0){
                   level += 1;
                   levelCounter = queue.size();
               }

           }
       }
       return level;

    }

}
