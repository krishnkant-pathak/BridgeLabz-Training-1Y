import java.util.*;

public class EmployeeProcessing {
    public static void main(String[] args) {
        int[] ages = {22, 30, 18, 45};

        ArrayList<Integer> list = new ArrayList<>();
        for (int a : ages) list.add(a);

        System.out.println("Youngest: " + Collections.min(list));
        System.out.println("Oldest: " + Collections.max(list));
    }
}