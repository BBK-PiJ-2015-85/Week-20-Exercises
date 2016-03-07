import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Streams {
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
        String q5 = words.stream().map(String::toUpperCase).filter((s) -> s.length() < 4)
                                                            .filter((s) -> s.contains("E"))
                                                            .findFirst().orElse(null);
        if (q5 != null) {
            System.out.println(q5);
        } else {
            System.out.println("Result was null.");
        }
    }
}
