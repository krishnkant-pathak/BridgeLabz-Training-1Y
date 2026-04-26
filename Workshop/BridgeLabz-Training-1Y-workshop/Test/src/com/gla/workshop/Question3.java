package com.gla.workshop;
import java.util.*;

public class Question3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s= 0, t= 1;
        while (n > 0) {
            int d = n % 10;
            if (d == 0) d = 1;
            s+= d * t;
            t*= 10;
            n /= 10;
        }
        System.out.println(s);
    }
}