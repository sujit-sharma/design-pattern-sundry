package com.sujit.one_matrix;


import com.sujit.one_matrix.exceptions.MatrixIncompitableException;

import java.util.Scanner;

public class Matrix {

    protected int row;
    protected int cloumn;

    protected Integer values[][];

    public Matrix(){

    }

    public Matrix(int row, int column) {
        this.row = row;
        this.cloumn = column;
        this.values = new Integer[row][column];
    }
    public Matrix(int row, int column, Integer[][] values) {
        this(row,column);
        this.values = values;
    }

    public void fillData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter elements of Matrix");
        for (int i = 0; i< this.row; i++ ) {
            for( int j = 0; j< this.cloumn; j++) {
                values[i][j] = scanner.nextInt();
            }
        }
    }

    public void printMatrix(){
        System.out.println();
        for (int row = 0; row < this.row; row++) {
            for (int col = 0; col < this.cloumn; col++) {
                System.out.print(this.values[row][col] + "\t");
            }
            System.out.println();
        }
    }

    public Matrix sumWith( Matrix secondMatrix ) throws MatrixIncompitableException {
        if(this.row != secondMatrix.row && this.cloumn != secondMatrix.cloumn) {
            throw new MatrixIncompitableException("Given matrices are of different size for performing sum ");
        }

        Matrix matrix = new Matrix(this.row, this.cloumn);
        for (int row = 0; row < matrix.row; row++) {
            for (int col = 0; col < matrix.cloumn; col++) {
                matrix.values[row][col] = this.values[row][col] + secondMatrix.values[row][col];
            }
        }

        return matrix;
    }

    public Matrix multiply(Integer scalarValue) {
        Integer scaledValue[][] = new Integer[this.row][this.cloumn];
        for(int row = 0; row < this.row; row++ ) {
            for (int col =0; col < this.cloumn; col++ ) {
                scaledValue[row][col] = this.values[row][col] * scalarValue;
            }
        }
        return new Matrix(this.row, this.cloumn,scaledValue);
    }
// This multiply method is overloaded. When calls with Integer value method that compute scalar multiply is called. If another matrix is passed as argument matrix multiplication is computed
    public Matrix multiply(Matrix secondMatrix) {
        Integer sum[][] = new Integer[this.row][secondMatrix.cloumn];
        if (this.cloumn != secondMatrix.row) {
            throw new MatrixIncompitableException("Multiplication cannot be performed. Number of column of one matrix is not equal to number of row of another");
        }
        for(int row = 0; row < this.row; row++ ) {
            for (int col = 0; col < secondMatrix.cloumn; col++) {
                sum[row][col] = 0;
                for (int element = 0; element < this.cloumn; element++) {
                    sum[row][col] += this.values[row][element] * secondMatrix.values[element][col];
                }

            }

        }
        return new Matrix(this.row, secondMatrix.cloumn,sum);
    }

    public Matrix transpose(){
        Integer newMatrixData[][] = new Integer[this.cloumn][this.row];
        for(int row = 0; row < this.cloumn; row++ ) {
            for (int col =0; col < this.row; col++ ) {
                newMatrixData[row][col] = this.values[col][row];

            }
        }
        return new Matrix(this.cloumn,this.row,newMatrixData);
    }

    public Matrix subMatrix(int rowToRemove, int cloumnToRemove) throws MatrixIncompitableException {
        if (rowToRemove > this.row || cloumnToRemove > this.cloumn) {
            throw new MatrixIncompitableException("Passed dimension must me less than original dimensions");
        }
        Matrix subMatrix = new Matrix(this.row -1, this.cloumn -1);

        for (int i = 0, tracki =0 ; i< this.row; i++) {
            if(i != rowToRemove){
                for (int j = 0, trackj = 0; j< this.cloumn; j++){
                    if( j != cloumnToRemove ){
                        subMatrix.values[tracki][trackj] = this.values[i][j];
                        trackj++;
                    }
                }
                tracki++;
            }
        }
        return subMatrix;
    }

}
