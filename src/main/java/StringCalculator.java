import java.util.Arrays;

public class StringCalculator {

    // "//;1,2;3\n4" -> 10
    // "//.1,2.3\n4" -> 10       // double slash registers new separator
    // "//[;;;]1,2;;;3\n4" -> 10 // new separator between the square brackets
    public int add(String numbers) {
        if (numbers.length() == 0) {
            return 0;
        }

        return Arrays.stream(numbers.split(
                "[,\n/;]"))
                .filter((s) -> s.matches("\\d+"))
                .mapToInt(Integer::valueOf)
                .reduce(0, Integer::sum);
    }
}
