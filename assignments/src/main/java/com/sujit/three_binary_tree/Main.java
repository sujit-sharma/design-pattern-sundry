package com.sujit.three_binary_tree;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int option, value;
		System.out.println("Enter root element of tree");
		BinaryTree binaryTree = new BinaryTree(scanner.nextInt());

		while (true){
			System.out.println("BINARY SEARCH TREE");
			System.out.print("Choose from Options:\t");
			System.out.print("1. To Insert \t");
			System.out.print("2. To Find Depth \t");
			System.out.print("3. To Find Tree Depth \t");
			System.out.print("4. To Print Sorted Values \t");
			option = scanner.nextInt();

			if(option ==1){
				System.out.println("Enter value to insert");
				value= scanner.nextInt();
				binaryTree.insert(value);
			}
			else if(option == 2){
				System.out.println("Enter element whose depth should find");
				value = scanner.nextInt();
				binaryTree.findDepth(value);

			}
			else if(option == 3){
				binaryTree.findTreeDepth();
			}
			else if(option == 4){
				binaryTree.printSortedBinaryTree();

			}
			else {
				System.out.println("Invalid Input, Please Enter number from 1 to 4 " );
			}


		}

    }
}
