package com.codertomwu.my1025.scannerme;

import java.util.Scanner;

public class MYScanner {

    public static void main(String[] args) {

        System.out.println("Hello Scanner");

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(a+b);

    }
}
