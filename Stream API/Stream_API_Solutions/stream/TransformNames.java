import java.util.*;
import java.util.stream.*;

public class TransformNames {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ansh", "Rahul", "Priya");

        names.stream()
            .map(String::toUpperCase)
            .sorted()
            .forEach(System.out::println);
    }
}
