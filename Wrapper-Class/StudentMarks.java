import java.util.*;

public class StudentMarks {
    public static void main(String[] args) {
        String[] data = {"85", "95", "88", "null"};

        ArrayList<Integer> list = new ArrayList<>();

        for (String s : data) {
            try {
                list.add(Integer.parseInt(s));
            } catch (Exception ignored) {}
        }

        double avg = list.stream().mapToInt(Integer::intValue).average().orElse(0);
        System.out.println("Average marks: " + avg);
    }
}