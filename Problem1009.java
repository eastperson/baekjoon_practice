package com.company;

import java.util.Scanner;

public class Problem1009 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            double a = sc.nextDouble();
            double b = sc.nextDouble();
            long result = (long) Math.pow(a,b);
            if(result % 10 == 0) {
                System.out.println(10);
            } else {
                System.out.println(result % 10);
            }
        }

    }
}
