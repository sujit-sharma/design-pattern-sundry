package com.sujit.one_matrix.helper;

import com.sujit.one_matrix.Matrix;
import com.sujit.one_matrix.SquareMatrix;
import com.sujit.one_matrix.exceptions.MatrixIncompitableException;

import java.util.Scanner;

public class MatrixHelper {

    public Matrix inputMatrix(String name) {
        int row, column;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter dimensions for Matrix :" +name + "\n Enter Number of Row");
        row = scanner.nextInt();
        System.out.println("Enter Number of Column ");
        column = scanner.nextInt();
        Matrix matrix =new Matrix(row,column);
        matrix.fillData();
        return matrix;
    }

    public SquareMatrix inputMatrix() {
        int size;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter a Square Matrix ");
        System.out.println("Enter size of for First Matrix : ");
        size = scanner.nextInt();
        SquareMatrix squareMatrix = new SquareMatrix(size);
        squareMatrix.fillData();

        return squareMatrix;
    }


    public void startWithNewMatrix(int option ) throws MatrixIncompitableException {
        Matrix matrix_A;
        Matrix matrix_B ;
        SquareMatrix squareMatrix;
        Matrix resultantMatrixAfterOperation;
        Integer scalarValue;

        switch (option) {
            case 1: matrix_A = inputMatrix("A");
                    matrix_B = inputMatrix("B");
                    resultantMatrixAfterOperation= matrix_A.sumWith(matrix_B);
                    resultantMatrixAfterOperation.printMatrix();
                    break;
            case 2: matrix_A = inputMatrix(" ");
                    System.out.println("Enter integer with we need to multiply matrix");
                    scalarValue = new Scanner(System.in).nextInt();
                    resultantMatrixAfterOperation = matrix_A.multiply(scalarValue);
                    resultantMatrixAfterOperation.printMatrix();
                    break;
            case 3: matrix_A = inputMatrix("A");
                    matrix_B = inputMatrix("B");
                    resultantMatrixAfterOperation= matrix_A.multiply(matrix_B);
                    resultantMatrixAfterOperation.printMatrix();
                    break;
            case 4: matrix_A = inputMatrix("");
                   resultantMatrixAfterOperation = matrix_A.transpose();
                   resultantMatrixAfterOperation.printMatrix();
                   break;
            case 5: matrix_A = inputMatrix(" ");
                    resultantMatrixAfterOperation = matrix_A.subMatrix(1,0);
                    resultantMatrixAfterOperation.printMatrix();
                    break;
            case 6: squareMatrix= inputMatrix();
                    squareMatrix.toDiagonalMatrix();
                    squareMatrix.printMatrix();
                    break;
            case 7: squareMatrix = inputMatrix();
                    squareMatrix.toLowerTriangularMatrix();
                    squareMatrix.printMatrix();
                    break;
            case 8: squareMatrix = inputMatrix();
                    squareMatrix.toUpperTriangularMatrix();
                    squareMatrix.printMatrix();
                    break;
            case 9: squareMatrix = inputMatrix();
                    System.out.println("The Determinant is : " + squareMatrix.calculateDeterminant(squareMatrix));
                    break;
            default: System.out.println("Please Enter a Valid Option");

        }

    }
}
