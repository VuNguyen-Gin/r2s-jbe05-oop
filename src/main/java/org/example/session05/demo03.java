package org.example.session05;

import java.util.Scanner;

public class demo03 {

    public static int inputInteger() throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a whole number: ");
        int n = Integer.parseInt(sc.nextLine());

        if (n<0 || n>100) {
            throw new Exception("The number between 0 and 100");
        }


        return n;
    }

    public static void main(String[] args) {
        try {

            int num = inputInteger();
            System.out.println(num);
        } catch (Exception exception) {

            System.out.println(exception.getMessage());
        }
    }
}
