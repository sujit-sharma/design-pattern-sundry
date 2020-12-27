package com.sujit.one_matrix;

import com.sujit.one_matrix.exceptions.MatrixIncompitableException;
import com.sujit.one_matrix.helper.MatrixHelper;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        MatrixHelper inputHelper = new MatrixHelper();
        Scanner scanner = new Scanner(System.in);
        int option;

        System.out.println("Please Choose one From the options:");
        System.out.println("1. For Matrix Addition ");
        System.out.println("2. For Scalar Multiplication ");
        System.out.println("3. For Matrix Multiplication ");
        System.out.println("4. For Matrix Transposition ");
        System.out.println("5. For Generating Sub-Matrix ");
        System.out.println("6. To Convert Matrix into Diagonal Matrix ");
        System.out.println("7. To Convert Matrix into Lower Triangular Matrix ");
        System.out.println("8. To Convert Matrix into Upper Triangular Matrix ");
        System.out.println("9. To Calculate Determinant Of Matrix ");
        option= scanner.nextInt();


        try {
            inputHelper.startWithNewMatrix(option);
        }
        catch (MatrixIncompitableException incompitableException ) {
            incompitableException.printStackTrace();
        }


    }
}
