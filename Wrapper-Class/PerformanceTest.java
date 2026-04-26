import java.util.*;

public class PerformanceTest {
    public static void main(String[] args) {
        long start, end;

        int[] arr = new int[1000000];
        start = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) arr[i] = i;
        long sum = 0;
        for (int x : arr) sum += x;
        end = System.currentTimeMillis();
        System.out.println("Array time: " + (end - start));

        ArrayList<Integer> list = new ArrayList<>();
        start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) list.add(i);
        sum = 0;
        for (int x : list) sum += x;
        end = System.currentTimeMillis();
        System.out.println("ArrayList time: " + (end - start));
    }
}