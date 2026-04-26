import java.util.*;

public class ProductRatings {
    public static void main(String[] args) {
        int[] arr = {4, 5};
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(3, null, 5));

        ArrayList<Integer> all = new ArrayList<>();

        for (int x : arr) all.add(x);
        for (Integer x : list) {
            if (x != null) all.add(x);
        }

        double avg = all.stream().mapToInt(Integer::intValue).average().orElse(0);
        System.out.println("Average rating: " + avg);
    }
}