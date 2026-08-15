package functionprogramming;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileManipulation {
    public static void main(String[] args) throws IOException {

        Files.lines(Paths.get("file.txt")).map(String::toUpperCase).forEach(System.out::println);

        Files.list(Paths.get(".")).forEach(System.out::println);

        Stream<Integer> stream = Stream.of(1,2,3);
        stream.forEach(System.out::println);
        stream.forEach(System.out::println);

    }

}
