import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers.length() == 0) {
            return 0;
        }

        return Arrays.stream(removeDelimitersFrom(numbers).split(getDelimitersOf(numbers)))
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private String getDelimitersOf(String numbers) {
        return ",|\\n" + getCustomDelimiter(numbers);
    }

    private String removeDelimitersFrom(String numbers) {
        if (numbers.startsWith("//[")) {
            String[] parts = numbers.split("//\\[(.*?)]", 2);
            return parts[1];
        }
        if (numbers.startsWith("//")) {
            return numbers.substring(3);
        }
        return numbers;
    }

    private String getCustomDelimiter(String numbers) {
        if (numbers.startsWith("//[")) {
            Pattern p = Pattern.compile("//\\[(.*?)]");
            Matcher m = p.matcher(numbers);
            if (m.find()) {
                return "|" + "(" + Pattern.quote(m.group(1)) + ")";
            }
        } else if (numbers.startsWith("//")) {
            return "|" + Pattern.quote(numbers.substring(2, 3));
        }
        return "";
    }

}
