package lambdas;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.logging.Logger;

public class FileFilterDemo {

    public static void main(String[] args) {
        File srcDir = new File("src/main/java");
        Arrays.stream(srcDir.listFiles())
                .filter(File::isDirectory)
                .forEach(System.out::println);

        Logger log = Logger.getLogger(FileFilterDemo.class.getName());
        Consumer<String> printer = System.out::println;
        Consumer<String> logger = log::info;
        Consumer<String> printAndLog = logger.andThen(printer);
        List<String> strings = List.of("this", "is", "a", "list", "of", "strings");

        strings.forEach(printAndLog);

        strings.stream()
            .map(String::length)
            .forEach(System.out::println);

        strings.stream()
                .map(String::length)
                .forEach(System.out::println);

    }
}
