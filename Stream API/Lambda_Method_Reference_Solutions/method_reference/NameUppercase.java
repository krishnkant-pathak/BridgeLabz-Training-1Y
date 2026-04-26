import java.util.*;
import java.util.stream.Collectors;

public class NameUppercase {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Ansh", "Rahul", "Priya");

        List<String> upper = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        upper.forEach(System.out::println);
    }
}
