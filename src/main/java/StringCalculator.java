import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers.length() == 0) {
            return 0;
        }

        String customDelimiter = "";
        String numbersWithoutDelimiterDefinition = numbers;

        if (numbers.startsWith("//[")) {
            Pattern p = Pattern.compile("//\\[(.*?)]");
            Matcher m = p.matcher(numbers);
            if (m.find()) {
                customDelimiter = "|" + "(" + Pattern.quote(m.group(1)) + ")";
            }
            String[] parts = numbers.split("//\\[(.*?)]", 2);
            numbersWithoutDelimiterDefinition = parts[1];
        } else if (numbers.startsWith("//")) {
            numbersWithoutDelimiterDefinition = numbers.substring(3);
            customDelimiter = "|" + Pattern.quote(numbers.substring(2, 3));
        }

        String regex = ",|\\n" + customDelimiter;

        return Arrays.stream(numbersWithoutDelimiterDefinition.split(regex))
                .mapToInt(Integer::parseInt)
                .sum();
    }

}
