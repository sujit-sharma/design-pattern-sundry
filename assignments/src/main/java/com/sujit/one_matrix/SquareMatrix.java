package com.sujit.one_matrix;


import com.sujit.one_matrix.exceptions.MatrixIncompitableException;

public class SquareMatrix extends Matrix {

    public SquareMatrix(int size) {
        super(size, size);
    }

    public boolean isValidSquareMatrix() {
            if(this.row != this.cloumn){
                System.out.println("This is Not a Square Matrix");
                return false;
            }
            return true;
    }

    public void toDiagonalMatrix() throws MatrixIncompitableException {
        for (int row =0; row < this.row; row++){
            for (int col = 0; col < this.cloumn; col++){
                if(row != col){
                    this.values[row][col] = 0;
                }
            }
        }

    }
    public void toLowerTriangularMatrix() {
        for (int row =0; row < this.row; row++){
            for (int col = 0; col < this.cloumn; col++){
                if(row < col){
                    this.values[row][col] = 0;
                }
            }
        }

    }

    public void toUpperTriangularMatrix() {
        if ( !isValidSquareMatrix()) {
            throw new MatrixIncompitableException("Not a Square Matrix");
        }
        for (int row =0; row < this.row; row++){
            for (int col = 0; col < this.cloumn; col++){
                if(row > col){
                    this.values[row][col] = 0;
                }
            }
        }

    }

    public Integer calculateDeterminant(Matrix matrix) {
        Integer determinant = 0;
        if( matrix.row == 1) {
            return matrix.values[0][0];
        }
        else if(matrix.row == 2){
            return ((matrix.values[0][0] * matrix.values[1][1]) - (matrix.values[0][1] * matrix.values[1][0]));

        }
        int sign = 1;
        for (int row = 0; row < matrix.row; row++) {
            determinant += (sign * matrix.values[0][row] * calculateDeterminant(this.subMatrix(0,row)));
            sign = -sign;
        }
        return determinant;
    }
}
