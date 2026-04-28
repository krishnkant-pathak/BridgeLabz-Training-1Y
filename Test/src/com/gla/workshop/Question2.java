package com.gla.workshop;
import java.util.Scanner;
public class Question2 {
    public static void main(String[] args){
                Scanner sc = new Scanner(System.in);
                int a = sc.nextInt();
                int b = sc.nextInt();
                int sum1 = 0;
                int sum2 = 0;
                for (int i = 1; i <= a; i++) {
                    if (a%i == 0) {
                        sum1 += i;
                    }}
                for (int i = 1; i <= b; i++) {
                    if (b% i == 0) {
                        sum2 += i;
                    }}
                if (sum1*b==sum2*a){
                    System.out.println("Yes, they are friendly pair");
                }
            }
        }


