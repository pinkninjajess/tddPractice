import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers.length() == 0) {
            return 0;
        }

        String outerDelimiter = "";
        String insideDelimiter = "";
        String numbersWithoutDelimiterDefinition = numbers;

        if (numbers.startsWith("//[")) {
            Pattern p = Pattern.compile("//\\[(.*?)]");
            Matcher m = p.matcher(numbers);
            if (m.find()) {
                outerDelimiter = "|(" + m.group(1) + ")";
            }
            String[] parts = numbers.split("//\\[(.*?)]", 2);
            numbersWithoutDelimiterDefinition = parts[1];
        } else if (numbers.startsWith("//")) {
            String[] parts = numbers.split("//", 2);
            numbersWithoutDelimiterDefinition = parts[1];
            insideDelimiter = numbers.substring(2, 3);
        }

        String regex = "[" + insideDelimiter + ",\n]" + outerDelimiter;

        Stream<String> streamNumbers = Arrays.stream(numbersWithoutDelimiterDefinition.split(regex));
        return streamNumbers
                .filter((s) -> s.matches("\\d+"))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
