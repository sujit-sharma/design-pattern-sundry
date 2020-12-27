package com.sujit.two_data_structure.utils;

import com.sujit.two_data_structure.exception.IllegalQueueStateException;
import com.sujit.two_data_structure.exception.IllegalStackStateException;
import com.sujit.two_data_structure.queue.CircularArrayQueue;
import com.sujit.two_data_structure.queue.LinkedQueue;
import com.sujit.two_data_structure.queue.Queue;
import com.sujit.two_data_structure.stack.ArrayStack;
import com.sujit.two_data_structure.stack.LinkedStack;
import com.sujit.two_data_structure.stack.Stack;

import java.util.Scanner;

public class Helper {

    private Stack<String> stack;
    private Queue<String> queue;

    private void operationSelector() throws IllegalStackStateException {
        Scanner scanner = new Scanner(System.in);
        int operation;
        String receiveddData;

        while(true) {

            System.out.print("Choose from Given Options");
            System.out.print("\t1. For Push From Stack");
            System.out.print("\t2. For Pop From Stack");
            System.out.print("\t3. For Peek From Stack");
            System.out.print("\t4. To Find Size of Stack");
            operation = scanner.nextInt();

            switch (operation) {

                case 1:
                    System.out.println("Enter Element to push on Stack");
                    this.stack.push(scanner.next());
                    break;
                case 2:
                    receiveddData = stack.pop();
                    System.out.println("The Popped data is " + receiveddData);
                    break;
                case 3:
                    receiveddData = stack.peek();
                    System.out.println("The Peeked data is " + receiveddData);
                    break;
                case 4:
                    System.out.println("The Size of Stack is " + stack.size());
            }

        }

    }

    private void operationSelector(String type) throws IllegalQueueStateException {
        Scanner scanner = new Scanner(System.in);
        int operation;
        String receiveddData;

        while(true) {

            System.out.print("Choose from Given Options");
            System.out.print("\t1. For Enque From Queue");
            System.out.print("\t2. For Dque From Queue");
            System.out.print("\t3. For Peek From Queue");
            System.out.print("\t4. To Find Size of Queue");
            operation = scanner.nextInt();

            switch (operation) {

                case 1:
                    System.out.println("Enter Element to Enque");
                    this.queue.enque(scanner.next());
                    break;
                case 2:
                    receiveddData = queue.deque();
                    System.out.println("The Dequed data is " + receiveddData);
                    break;
                case 3:
                    receiveddData = queue.peek();
                    System.out.println("The Peeked data is " + receiveddData);
                    break;
                case 4:
                    System.out.println("The Size of Queue is " + queue.size());
            }

        }

    }

    public void classSelector(int option) throws IllegalQueueStateException {

        try {
            switch (option) {
                case 1: stack = new ArrayStack();
                    operationSelector();
                    break;

                case 2: stack = new LinkedStack();
                    operationSelector();
                    break;
                case 3: queue = new CircularArrayQueue();
                    operationSelector("Queue");
                    break;
                case 4: queue = new LinkedQueue<>();
                    operationSelector("Queue");
                    break;

                default: System.out.println("Please Enter a Valid Option. Insert Number From 1 to 4");
            }
        }
        catch (IllegalQueueStateException illegalQueueStateException) {
            illegalQueueStateException.printStackTrace();
        }
        catch (IllegalStackStateException illegalStackStateException) {
            illegalStackStateException.printStackTrace();
        }

    }
}
