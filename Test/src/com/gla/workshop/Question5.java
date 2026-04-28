package com.gla.workshop;
import java.util.*;

public class Question5 {
    public static void main(String[] args) {
        int a[] ={1,2,2,3,3,3,4};
        Arrays.sort(a);
        int c = 1;
        for(int i = 1; i < a.length; i++){
            if(a[i] == a[i-1]){
                c++;
            } else {
                System.out.println(a[i-1] + " " + c);
                c = 1;}}
        System.out.println(a[a.length-1] + " " + c);
    }
}