import java.util.Arrays;
import java.util.stream.Stream;

public class StringCalculator {

    // "//;1,2;3\n4" -> 10
    // "//.1,2.3\n4" -> 10       // double slash registers new separator
    // "//[;;;]1,2;;;3\n4" -> 10 // new separator between the square brackets
    public int add(String numbers) {
        if (numbers.length() == 0) {
            return 0;
        }

        String delimiter = "";

        if (numbers.startsWith("//")) {
            delimiter = numbers.substring(2, 3);
        }

        String regex = "[" + delimiter + ",\n]";

        Stream<String> streamNumbers = Arrays.stream(numbers.split(regex));
        return streamNumbers
                .filter((s) -> s.matches("\\d+"))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
