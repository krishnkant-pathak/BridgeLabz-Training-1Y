import java.util.*;
import java.util.stream.*;

class Movie {
    String name;
    double rating;
    int year;

    Movie(String name, double rating, int year) {
        this.name = name;
        this.rating = rating;
        this.year = year;
    }
}

public class TopTrendingMovies {
    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
            new Movie("A", 4.5, 2023),
            new Movie("B", 4.8, 2024),
            new Movie("C", 4.2, 2022),
            new Movie("D", 4.9, 2024),
            new Movie("E", 4.1, 2021),
            new Movie("F", 4.7, 2023)
        );

        movies.stream()
            .sorted((m1, m2) -> Double.compare(m2.rating, m1.rating))
            .limit(5)
            .forEach(m -> System.out.println(m.name));
    }
}
