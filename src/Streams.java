import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {

    //question 10 method
    public static List randomNumberList(int size) {
        return new Random().doubles(size, 0, 1).boxed().collect(Collectors.toList());
    }

    //question 11 method
    public static List orderedNumberList(int start, int step, int size) {
        return IntStream.iterate(start, i -> i + step).limit(size).boxed().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("hi", "hello", "tonight", "once", "forever", "midnight",
                                            "black", "white", "back", "yellow", "sun", "red");

        System.out.println("*****Question 1*****");
        words.stream().forEach((s) -> System.out.println("  " + s));
        System.out.println();

        System.out.println("*****Question 2*****");
        words.stream().forEach(System.out::println);
        System.out.println();

        System.out.println("*****Question 3*****");
        Stream<String> excitingWords = words.stream().map((s) -> s + "!");
        System.out.println("Exciting words: ");
        excitingWords.forEach(System.out::println);
        System.out.println("Eye Words: ");
        Stream<String> eyeWords = words.stream().map((s) -> s.replace("i", "eye"));
        eyeWords.forEach(System.out::println);
        System.out.println("Upper Case Words: ");
        Stream<String> upperCaseWords = words.stream().map(String::toUpperCase);
        upperCaseWords.forEach(System.out::println);
        System.out.println();

        System.out.println("*****Question 4*****");
        System.out.println("Short Words: ");
        Stream<String> shortWords = words.stream().filter((s) -> s.length() < 4);
        shortWords.forEach(System.out::println);
        System.out.println("Words with B: ");
        Stream<String> wordsWithB = words.stream().filter((s) -> s.contains("b"));
        wordsWithB.forEach(System.out::println);
        System.out.println("Even Words:");
        Stream<String> evenWords = words.stream().filter((s) -> s.length() % 2 == 0);
        evenWords.forEach(System.out::println);
        System.out.println();

        System.out.println("*****Question 5*****");
        System.out.println(words.stream().map(String::toUpperCase).filter((s) -> s.length() < 4)
                                                            .filter((s) -> s.contains("E"))
                                                            .findFirst().orElse("Not found."));


        System.out.println(words.stream().map(String::toUpperCase).filter((s) -> s.length() < 4)
                                                                    .filter((s) -> s.contains("Q"))
                                                                    .findFirst().orElse("Not found."));
        System.out.println();


        System.out.println("*****Question 6*****");// NOT IMPLEMENTED
        /*
        List<String> upperCaseList = new ArrayList<>();
        System.out.printf(words.stream().map(String::toUpperCase).filter((s) -> s.length() < 4)
                                                                    .filter((s) -> s.contains("E"))
                                                                     .findFirst().orElse(null));
        */
        System.out.println();

        System.out.println("*****Question 7*****");
        System.out.println(words.stream().reduce("", (s, t) -> (s + t).toUpperCase()));
        System.out.println();

        System.out.println("*****Question 8*****");
        System.out.println(words.stream().map(String::toUpperCase).reduce("", String::concat));
        System.out.println();

        System.out.println("*****Question 9*****");
        String q9 = words.stream().reduce((s, t) -> s + "," + t).orElse("need two strings.");
        System.out.println(q9);
        System.out.println();

        System.out.println("*****Question 10*****");
        System.out.println(Streams.randomNumberList(5));
        System.out.println(Streams.randomNumberList(10));

        System.out.println();

        System.out.println("*****Question 11*****");
        System.out.println(Streams.orderedNumberList(1, 1, 5));
        System.out.println(Streams.orderedNumberList(10, 10, 10));
    }
}
