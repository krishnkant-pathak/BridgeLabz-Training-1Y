package com.gla.workshop;
import java.util.*;
public class Question1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> a = new ArrayList<>();
        for(int i = 0; i < n; i++){
            a.add(sc.nextInt());
        }
        Set<Integer> s = new LinkedHashSet<>(a);
        System.out.println(s);
    }}